/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author Azhar Nurulhaifa
 */
public class baseDAO {
    private static String DB_NAME = "uas";
    private static String DB_HOST = "localhost";
    private static String DB_USER = "root";
    private static String DB_PASS = "Azh@#195#*";
    
    public static Connection getCon(){
        Connection con = null;
        try{
            con = DriverManager.getConnection("jdbc:mysql://" + DB_HOST + ":3306/" + DB_NAME, DB_USER, DB_PASS);
        }catch (Exception e){
            e.printStackTrace();
        }
        return con;
    }
    
    public static void closeCon(Connection con) {
        try{
            con.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
