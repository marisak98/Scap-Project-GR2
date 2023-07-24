package com.app.Scap.view;
import com.app.Scap.controllers.LoginScapControler;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class LoginScap extends Application {

    public LoginScapControler menuScapControler;
    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/static/login.fxml"));
        GridPane stackPane = loader.load();
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
