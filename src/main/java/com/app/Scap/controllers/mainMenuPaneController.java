package com.app.Scap.controllers;

import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import javafx.scene.input.MouseEvent;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;


public class mainMenuPaneController implements Initializable {

    @FXML
    private Button btnBar1;
    @FXML
    private Button btnBar2;
    @FXML
    private AnchorPane paneSlide;
    @FXML
    private Button btnUsers;



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        paneSlide.setTranslateX(-160);
        btnBar1.setVisible(true);
        btnBar2.setVisible(false);

    }

    public void closeWindow(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/static/login.fxml"));

            Parent root = loader.load();

            Scene scene = new Scene(root);
            Stage stage =new Stage();

            stage.setScene(scene);
            stage.show();


        }catch (IOException ex){
            Logger.getLogger(MenuControler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    public void run2(MouseEvent event){
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(0.4));
        transition.setNode(paneSlide);

        transition.setToX(-160);
        transition.play();

        paneSlide.setTranslateX(0);

        transition.setOnFinished((ActionEvent event1) -> {
          btnBar1.setVisible(true);
          btnBar2.setVisible(false);
        });
    }

    @FXML
    public void run1(MouseEvent event){
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(0.4));
        transition.setNode(paneSlide);

        transition.setToX(0);
        transition.play();

        paneSlide.setTranslateX(-160);
        transition.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event1) {
                btnBar1.setVisible(false);
                btnBar2.setVisible(true);
            }
        });
    }
}
