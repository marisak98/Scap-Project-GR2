package com.app.Scap.view;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import org.springframework.boot.SpringApplicationShutdownHandlers;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import javafx.scene.text.Text;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;


public class menuScap  extends Application {
    @FXML
    private Button myButton;
    @FXML
    private Label lblMensaje;

    @FXML
    private ImageView imageView;


    public void imageLogo(URL url, ResourceBundle rb) {
        File file = new File("img/icon.png");
        Image image = new Image(file.toURI().toString());
        imageView.setImage(image);
    }
    @FXML
    private void handleButtonClick(ActionEvent event)  {
        System.out.printf("¡WTF Soy un Boton!!");
        lblMensaje.setText("WTF soy un boton!!");

    }
    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/static/test.fxml"));
        GridPane stackPane = loader.load();
        Scene scene = new Scene( new Group());
        scene.getStylesheets().add(getClass().getResource("/static/style.css").toExternalForm());

        stackPane.getStyleClass().add("body");
        scene.setRoot(stackPane);

        lblMensaje = (Label) loader.getNamespace().get("lblMensaje");

        

        myButton = (Button) loader.getNamespace().get("myButton");
        AnchorPane.setTopAnchor(myButton, 10.0);
        AnchorPane.setLeftAnchor(myButton, 10.0);

        myButton.setOnAction(this::handleButtonClick);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
