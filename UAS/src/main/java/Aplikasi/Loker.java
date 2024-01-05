/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Aplikasi;

/**
 *
 * @author Azhar Nurulhaifa
 */
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Loker extends Application{
    
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        URL url = new File("src/main/java/View/Signup.fxml").toURI().toURL();
        loader.setLocation(url);
        
        Parent root = loader.load();
        Scene scene = new Scene(root);
        
        stage.centerOnScreen();
        stage.setScene(scene);
        stage.show();
    }
    
    public static void main(String[] args) throws ParseException {
         launch(args);
    }
}
