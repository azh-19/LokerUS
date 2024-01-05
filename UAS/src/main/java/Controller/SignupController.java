/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import dao.baseDAO;
import static dao.baseDAO.getCon;

/**
 * FXML Controller class
 *
 * @author Azhar Nurulhaifa
 */
public class SignupController {

    @FXML
    private TextField username;
    @FXML
    private ChoiceBox <String> role;
    @FXML
    private PasswordField password;
    @FXML
    private Button onSignup;

    ObservableList<String> roleList = FXCollections.observableArrayList("Perusahaan", "Pelamar");

     @FXML
    private void initialize(){
    role.setItems(roleList);
    
//    String selectedRole = role.getValue();
//        String enteredUsername = username.getText();
//        String enteredPassword = password.getText();
//
//        saveToDatabase(selectedRole, enteredUsername, enteredPassword);
//
//        redirectToLogin(selectedRole);
    
    role.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            switch (newValue) {
                case "Perusahaan":
                {
                    try {
                        showPerusahaanView();
                    } catch (IOException ex) {
                        Logger.getLogger(SignupController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                    break;

                case "Pelamar":
                {
                    try {
                        showPelamarView();
                    } catch (IOException ex) {
                        Logger.getLogger(SignupController.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                    break;

            }
    });
    }
    
//    private void saveToDatabase(String selectedRole, String enteredUsername, String enteredPassword) {
//       
//        try {
//            Connection con = getCon();
//            String query = "INSERT INTO user (role, username, password) VALUES (?, ?, ?)";
//            PreparedStatement preparedStatement = con.prepareStatement(query);
//            preparedStatement.setString(1, selectedRole);
//            preparedStatement.setString(2, enteredUsername);
//            preparedStatement.setString(3, enteredPassword);
//            preparedStatement.executeUpdate();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
    
//    private void redirectToLogin(String selectedRole) throws IOException {
//         FXMLLoader loader = new FXMLLoader();
//        URL url = new File("src/main/java/View/Login"+selectedRole+".fxml").toURI().toURL();
//        loader.setLocation(url);
//        
//        Parent root = loader.load();
//        Scene scene = new Scene(root);
//        
//        Stage stage = new Stage();
//        stage.centerOnScreen();
//        stage.setScene(scene);
//        stage.show();
//    }
//    
    public void showPerusahaanView() throws MalformedURLException, IOException{
     FXMLLoader loader = new FXMLLoader();
        URL url = new File("src/main/java/View/LoginPerusahaan.fxml").toURI().toURL();
        loader.setLocation(url);
        
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        Stage stage = new Stage();
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();
    }
    
    public void showPelamarView() throws MalformedURLException, IOException{
     FXMLLoader loader = new FXMLLoader();
        URL url = new File("src/main/java/View/LoginPelamar.fxml").toURI().toURL();
        loader.setLocation(url);
        
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        Stage stage = new Stage();
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    private void handleSignup(ActionEvent event) throws IOException {
    
    }
    
  
}
