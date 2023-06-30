package com.app.Scap.view;

import com.app.Scap.ScapApplication;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
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
import java.io.IOException;


public class menuScap  extends Application {
    @FXML
    private Button myButton;
    @FXML
    private void handleButtonClick(ActionEvent event)  {
        System.out.printf("¡WTF Soy un Boton!!");

    }
    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/static/test.fxml"));
        StackPane stackPane = loader.load();
        Scene scene = new Scene( new Group());
        scene.getStylesheets().add(getClass().getResource("/static/style.css").toExternalForm());

        stackPane.getStyleClass().add("my-rect");

        Text text = new Text("Hola culeros");
        text.getStyleClass().add("test");


        stackPane.getChildren().add(text);
        scene.setRoot(stackPane);

        myButton = (Button) loader.getNamespace().get("myButton");
        AnchorPane.setTopAnchor(myButton, 10.0);
        AnchorPane.setLeftAnchor(myButton, 10.0);

        myButton.setOnAction(this::handleButtonClick);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
