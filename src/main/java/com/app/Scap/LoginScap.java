package com.app.Scap;
import com.app.Scap.controllers.LoginScapControler;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.BorderImage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;


public class LoginScap extends Application {


    public LoginScapControler menuScapControler;
    @Override
    public void start(Stage primaryStage) throws Exception{


        FXMLLoader loader = new FXMLLoader(getClass().getResource("/static/login.fxml"));
        BorderPane stackPane = loader.load();
        Scene scene = new Scene( new Group());
        scene.getStylesheets().add(getClass().getResource("/static/style.css").toExternalForm());


        stackPane.getStyleClass().add("body");
        scene.setRoot(stackPane);

        menuScapControler = loader.getController();
        menuScapControler.initialize(null, null);

        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}
