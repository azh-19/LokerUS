/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Aplikasi;

/**
 *
 * @author Azhar Nurulhaifa
 */
import View.Konsol;
import Controller.HomeController;
import Aplikasi.Admin;
import View.Homepage;
import View.LokerUs;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class Loker extends Application{
    
    public static void main(String[] args) throws ParseException {
        LokerUs view = new LokerUs();
        view.setVisible(true);
        try{
            for(int i = 0; i <= 100; i++){
                Thread.sleep(40);
                view.lblload.setText(Integer.toString(i)+"%");
                view.load.setValue(i);
            }
            view.dispose();
            Homepage viewHome = new Homepage();
            UAS Aplikasi = new UAS();
            HomeController controller = new HomeController(viewHome, Aplikasi);
            viewHome.setVisible(true);
            Konsol konsol = new Konsol(Aplikasi);
            konsol.MainMenu();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan");
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
