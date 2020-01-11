/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cbt.controller;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author nathan
 */
public class AdminFormController implements Initializable {

    double x, y;
    @FXML
    private HBox userHbox;
    @FXML
    private HBox creatorHbox;
    @FXML
    private HBox agendaHbox;
    @FXML
    private Button addButton;
    @FXML
    private Button editButton;
    @FXML
    private VBox creatorVbox;
    @FXML
    private Button addButton1;
    @FXML
    private Button editButton1;
    @FXML
    private VBox userVbox;
    @FXML
    private VBox agendaVbox;
    @FXML
    private Button addButton2;
    @FXML
    private Button editButton2;
    @FXML
    private Button button1;
    @FXML
    private Button button2;
    @FXML
    private Button button3;
    @FXML
    private Button button4;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void dragged(MouseEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setX(event.getScreenX() - x);
        stage.setY(event.getScreenY() - y);
    }

    @FXML
    private void pressed(MouseEvent event) {
        x = event.getSceneX();
        y = event.getSceneY();
    }

    @FXML
    private void mouseExitedUser(MouseEvent event) {
        userHbox.setStyle("-fx-background-color:#03a9f4;");
    }

    @FXML
    private void mouseEnteredUser(MouseEvent event) {
        userHbox.setStyle("-fx-background-color:#67daff;");
    }

    @FXML
    private void mouseExitedCreatorPermission(MouseEvent event) {
        creatorHbox.setStyle("-fx-background-color:#03a9f4;");
    }

    @FXML
    private void mouseEnteredCreatorPermission(MouseEvent event) {
        creatorHbox.setStyle("-fx-background-color:#67daff;");
    }

    @FXML
    private void mouseExitedAgenda(MouseEvent event) {
        agendaHbox.setStyle("-fx-background-color:#03a9f4;");
    }

    @FXML
    private void mouseEnteredAgenda(MouseEvent event) {
        agendaHbox.setStyle("-fx-background-color:#67daff;");
    }

    @FXML
    private void mouseExitedAddButton(MouseEvent event) {
        addButton.setStyle("-fx-background-color:#03a9f4;");
    }

    @FXML
    private void mouseEnteredAddButton(MouseEvent event) {
        addButton.setStyle("-fx-background-color:#67daff;");
    }

    @FXML
    private void mouseExitedEditButton(MouseEvent event) {
        editButton.setStyle("-fx-background-color:#03a9f4;");
    }

    @FXML
    private void mouseEnteredEditButton(MouseEvent event) {
        editButton.setStyle("-fx-background-color:#67daff;");
    }

    @FXML
    private void userOnClick(MouseEvent event) {
        userVbox.toFront();
    }

    @FXML
    private void creatorOnClick(MouseEvent event) {
        creatorVbox.toFront();
    }

    @FXML
    private void agendaOnClick(MouseEvent event) {
        agendaVbox.toFront();
    }
    

}
