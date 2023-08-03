package com.app.Scap.controllers;
import com.app.Scap.DAO.UsuarioDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Screen;

import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginScapControler implements Initializable {
    @FXML
    private ImageView imageView;

    @FXML
    private Button btnLogin;
    @FXML
    private TextField loginUsername;
    @FXML
    private PasswordField loginPassword;

    private AuthController authController;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        double screenWidth = Screen.getPrimary().getBounds().getWidth();
        double screenHeigth = Screen.getPrimary().getBounds().getHeight();

      double halfScreenW =  screenWidth /2;
      double halfScreenH = screenHeigth /2;

        ColumnConstraints col1 = new ColumnConstraints(halfScreenW);
        ColumnConstraints col2 = new ColumnConstraints(halfScreenW);
        RowConstraints row1 = new RowConstraints(halfScreenH);
        RowConstraints row2 = new RowConstraints(halfScreenH);
        GridPane.setHgrow(imageView, Priority.ALWAYS);
        GridPane.setVgrow(imageView, Priority.ALWAYS);


    }


    public void setAuthController(AuthController authController){
        this.authController = authController;
    }

    @FXML
    public void Login(ActionEvent event) {
            String usuario = loginUsername.getText();
            String clave = loginPassword.getText();
            if (authController != null && authController.loginUsuarios(usuario, clave)) {

                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/static/MainMenu.fxml"));

                    Parent root = loader.load();

                    mainMenuPaneController controller = new mainMenuPaneController();

                    Scene scene = new Scene(root);
                    Stage stage = new Stage();

                    stage.setScene(scene);
                    stage.show();

                    stage.setOnCloseRequest(e -> controller.closeWindow());

                    Stage myStage = (Stage) this.btnLogin.getScene().getWindow();
                    myStage.close();

                    mostrarNotificacion("Inicio de Session", "Sesión iniciada correctamente.",
                            Alert.AlertType.INFORMATION);

                } catch (IOException exception) {
                    Logger.getLogger(AdminMenuControler.class.getName()).log(Level.SEVERE, null, exception);
                }
            } else {
                mostrarNotificacion("Error de Inicio de Sesión", "Credenciales incorrectas. Intente nuevamente.", Alert.AlertType.ERROR);
            }
    }

    private void mostrarNotificacion(String titulo, String mesaje, Alert.AlertType tipo){
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mesaje);
        alert.showAndWait();
    }

}
