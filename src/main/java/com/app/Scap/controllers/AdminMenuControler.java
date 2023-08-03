package com.app.Scap.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AdminMenuControler implements Initializable {

    @FXML
    private Label lbl_currentprojects;
    @FXML
    private VBox pnl_scroll;
    @FXML
    private void handleButtonAction(){
        refreshNode();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // TODO
    }

    public void closeWindows(){
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/static/MainMenu.fxml"));
            Parent root = loader.load();

            mainMenuPaneController controller = loader.getController();

            Scene scene = new Scene(root);
            Stage stage = new Stage();

            stage.setScene(scene);
            stage.show();


        }catch (IOException ex){
            Logger.getLogger(AdminMenuControler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void refreshNode(){
        pnl_scroll.getChildren().clear();

        Node [] nodes = new Node[15];

        for (int i =0; i<10; i++){
            try {
                nodes[i] = (Node) FXMLLoader.load(getClass().getResource(""));
                pnl_scroll.getChildren().add(nodes[i]);
            }catch (IOException ex){
                Logger.getLogger(AdminMenuControler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
