package com.app.Scap.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
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
    private GridPane gridPane;
    @FXML
    private Button btnLogin;
    @FXML
    private Label lblMensaje;

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


    @FXML
    public void Login(ActionEvent event) {
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


        } catch (IOException exception){
            Logger.getLogger(MenuControler.class.getName()).log(Level.SEVERE, null, exception);
        }
    }

}
