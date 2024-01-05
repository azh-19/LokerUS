/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package koneksi;

import static koneksi.BaseDAO.closeCon;
import static koneksi.BaseDAO.getCon;
import Aplikasi.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

/**
 *
 * @author Azhar Nurulhaifa
 */
public class UserDAO {
    private static PreparedStatement st;
    private static Connection con;
    
    public static User validate(String username, String password) throws SQLException {
        User u = null;
        try{
            con = getCon();
            String query = "select id from users where username = '%s' and password = '%s' ";
            query = String.format(query,
                    username,
                    password);
            st = con.prepareStatement(query);
            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                u = new User(UUID.fromString(rs.getString("id")), username, password) {};
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally{
            closeCon(con);
        }
        return u;
    } 
    
     public static User searchByUid(String id){
         User u = null;
         try{
             con = getCon();
             String query = "select * from users where id = '%s' ";
             query = String.format(query, id);
             
             st = con.prepareStatement(query);
             ResultSet rsUser = st.executeQuery();
             u = new User(UUID.fromString(rsUser.getString("id")),
                        rsUser.getString("username"), rsUser.getString("password")) {};
         }catch(SQLException e){
             e.printStackTrace();
         }finally{
             closeCon(con);
         }
         return u;
     }
     
     public static void registerUser(User u){
         try{
             con = getCon();
             String query = "insert into users"
                     + " values ('%s', '%s', '%s') ";
             query = String.format(query,
                     u.getId(),
                     u.getNama(),
                     u.getPassword());
             st = con.prepareStatement(query);
             st.executeUpdate();
         }catch (Exception e){
             e.printStackTrace();
         }finally{
             closeCon(con);
         }
     }
}
