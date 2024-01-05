/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class SignupController {
    
    ObservableList<String> roleList = FXCollections.observableArrayList("Perusahaan", "Pelamar");

    @FXML
    private AnchorPane AnchorPane;
    @FXML
    private TextField username;
    @FXML
    private ChoiceBox role;
    @FXML
    private PasswordField password;
    @FXML
    private Button onSignup;

     @FXML
    private void initialize(){
    role.setItems(roleList);
    }
    
}   
