/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Azhar Nurulhaifa
 */
public class ShowApplicantsController{

    @FXML
    private Button editBtn;
    @FXML
    private Button statusBtn;
    @FXML
    private Button backBtn;
 

    @FXML
    private void statusInfo(ActionEvent event) throws IOException {
         FXMLLoader loader = new FXMLLoader();
        URL url = new File("src/main/java/View/ApplicantDetails.fxml").toURI().toURL();
        loader.setLocation(url);
        
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        Stage stage = new Stage();
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void backClick(ActionEvent event) throws IOException {
             FXMLLoader loader = new FXMLLoader();
        URL url = new File("src/main/java/View/CompanyJobList.fxml").toURI().toURL();
        loader.setLocation(url);
        
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        Stage stage = new Stage();
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();
    }
    
}
