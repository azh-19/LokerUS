/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package Controller;


import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Azhar Nurulhaifa
 */
public class CustomerInterfaceController {

    @FXML
    private Button backBtn;
    @FXML
    private Button lihatBtn;

    @FXML
    private void backClick(ActionEvent event) throws MalformedURLException, IOException {
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
    private void lihatClick(ActionEvent event) throws MalformedURLException, IOException {
        FXMLLoader loader = new FXMLLoader();
        URL url = new File("src/main/java/View/JobDetail.fxml").toURI().toURL();
        loader.setLocation(url);
        
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        Stage stage = new Stage();
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();
    }
    
}
