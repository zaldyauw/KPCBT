/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cbt.controller;

import com.cbt.MainApp;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import com.cbt.dao.UserDaoImpl;
import javafx.scene.control.PasswordField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import com.cbt.entity.Question;
import com.cbt.entity.Role;
import com.cbt.entity.User;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.stage.Modality;
import javafx.stage.StageStyle;



/**
 * FXML Controller class
 *
 * @author Zaldy Auw
 */
public class LoginController implements Initializable {
    
    double x,y;
    @FXML
    private HBox root;
    @FXML
    private TextField usernameTextField;
    @FXML
    private PasswordField passwordTextField;
    private Stage mainStage;

    private UserDaoImpl userDao;

    private User loginUser;
    @FXML
    private ComboBox<?> roleComboBox;

  

     public UserDaoImpl getUserDao() {
        if (userDao == null) {
            userDao = new UserDaoImpl();
        }
        return userDao;
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    //Platform
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
    private void minimizeButtonAction(MouseEvent event) {
        Stage stage = (Stage) ((HBox) event.getSource()).getScene().getWindow();
        stage.setIconified(true);
    }

    @FXML
    private void closeButtonAction(MouseEvent event) {
        Node source = (Node) event.getSource();
        Stage stage = (Stage) source.getScene().getWindow();
        stage.close();
    }

    private boolean login() {
        boolean valid;
        User user = new User();
        user.setUsername(usernameTextField.getText());
        user.setPassword(passwordTextField.getText());

        Role role = new Role();
        role.setId(4);
        user.setRole(role);

        loginUser = getUserDao().getOneData(user);
        valid = (loginUser != null);
        return valid;
    }

    @FXML
    private void loginButtonAction(ActionEvent event) {
        if (login()) {
            try {
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(MainApp.class.getResource("view/PembuatSoalForm_1.fxml"));
                VBox pane = loader.load();
                Scene scene = new Scene(pane);
                PembuatSoalFormController controller = loader.getController();
                controller.setMainController(this);

                mainStage = new Stage();
                mainStage.setScene(scene);
                mainStage.setFullScreen(true);
                mainStage.initStyle(StageStyle.TRANSPARENT);
                mainStage.setFullScreenExitHint("");
                mainStage.setTitle("CBT");

                ((Stage) root.getScene().getWindow()).close();
            } catch (IOException ex) {
                Logger.getLogger(PembuatSoalFormController.class.getName()).log(Level.SEVERE, null, ex);
            }
            mainStage.show();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Login Error");
            alert.setContentText("Username/Password Invalid");
            alert.initOwner(root.getScene().getWindow());
            alert.initModality(Modality.APPLICATION_MODAL);
            alert.show();
        }
    }

    public User getLoginUser() {
        return loginUser;
    }
}

