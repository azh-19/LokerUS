/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package koneksi;

/**
 *
 * @author Azhar Nurulhaifa
 */
import Aplikasi.berkas;
import Aplikasi.Lowongan;
import Aplikasi.Pelamar;
import Aplikasi.Perusahaan;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Database {
    private Connection con;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    Date date2 = null;
    
    public void connect() {
        String url = "jdbc:mysql://localhost:3306/Loker";
        String username = "root";
        String password = "Azh@#195#*";
        try {
            con = DriverManager.getConnection(url, username, password);
            con.setTransactionIsolation(Connection.TRANSACTION_SERIALIZABLE);
            con.setAutoCommit(false);
            System.out.println("connected");
        } catch (SQLException ex){
            System.out.println("gagal konek");
        }
    }
    
    public void saveBerkas(int idPelamar, List<String> skill){
        try{
            for(int i = 0; i < skill.size(); i++) {
                Statement stmt = con.createStatement();
                String query = "insert into berkas values("
                        + 0 + ", "
                        + idPelamar + ", "
                        + idPelamar + ", "
                        + (i+1) + ", "
                        + ");";
                stmt.execute(query);
                con.commit();
                stmt.close();
            }
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null, "Ada eror!");
            e.printStackTrace();
        }
    }
    
    public berkas loadBerkas(Pelamar p){
        berkas berkas1;
        List<String> skill = new ArrayList<>();
        int idBerkas = 0;
        try{
            Statement stmt = con.createStatement();
            String query = "select idBerkas, idLowongan from berkasmasuk where idBerkas = "+p.getB().getIdBerkas()+";";
            System.out.println(query);
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()) {
                idBerkas = rs.getInt(1);
                skill.add(loadSkill(rs.getInt(2)));
            }
            berkas1 = new berkas();
            berkas1.setSkill(skill);
            return berkas1;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Data Tidak dapat di update!");
            return null;
        }
    }
    
    public void saveBerkasMasuk(Pelamar p){
        try{
            Statement stmt = con.createStatement();
            String query = "insert into berkasmasuk values("
                    + 0 + ", "
                    + p.getB().getIdBerkas() + ", "
                    + p.getIdPelamar()
                    + ");";
            stmt.execute(query);
            con.commit();
            stmt.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Ada error!");
            e.printStackTrace();
        }
    }
    
    public berkas loadBerkasMasuk(Pelamar p) {
        berkas berkas1;
        int idBerkas = 0;
        int idLowongan = 0;
        try{
            Statement stmt = con.createStatement();
            String query = "select idBerkas, idLowongan from berkasmasuk where idBerkas = "+p.getB().getIdBerkas()+");";
            System.out.println(query);
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()) {
                idBerkas = rs.getInt(1);
                idLowongan = rs.getInt(2);
            }
            berkas1 = loadBerkas(p);
            return berkas1;
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Data tidak dapat di update!");
            return null;
        }
    }
    
    public void saveBerkasdiTerima(Pelamar p){
        try{
            Statement stmt = con.createStatement();
            String query = " insert into berkasLamarandiTerima values("
                    + 0 + ", "
                    + p.getB().getIdBerkas() + ", "
                    + p.getIdPelamar()
                    + ");";
            stmt.execute(query);
            con.commit();
            stmt.close();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Ada error di save berkas lamaran diterima!");
            e.printStackTrace();
        }
    }
    
    public berkas loadBerkasLamaranDiTerima(Pelamar p){
        berkas berkas1;
        int idBerkas = 0;
        int idLowongan = 0;
        try{
            Statement stmt = con.createStatement();
            String query = "select idBerkas, idLowongan from berkasditerima where idBerkas = "+p.getB().getIdBerkas()+";";
            System.out.println(query);
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()) {
                idBerkas = rs.getInt(1);
                idLowongan = rs.getInt(2);
            }
            berkas1 = loadBerkas(p);
            return berkas1;
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Data tidak dapat di update!");
            return null;
        }
    }
    
    public void saveSkill(String skill, int idSkill){
        try{
            Statement stmt = con.createStatement();
            String query = "insert into skill values("
                    + idSkill + ", "
                    + skill
                    + ");";
            stmt.execute(query);
            con.commit();
            stmt.close();
        }catch (Exception ex){
            System.out.println("Ada error!");
            ex.printStackTrace();
        }
    }
    
    public String loadSkill(int idSkill){
        String skill = "";
        try{
            Statement stmt = con.createStatement();
            String query="select *from skill where idSkill = "+idSkill+";";
            System.out.println(query);
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                skill = rs.getString(2);
            }
            skill = skill;
            return skill;
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Data tidak dapat di update!");
            return null;
        }
    }
    
    public Pelamar loadPelamar(String emil, String pass){
        int idPelamar = 0;
        String nama = "";
        String jk = "";
        String tempatLahir = "";
        String tglLahir = null;
        String noTlp = "";
        String email = "";
        String password = "";
        try{
            Statement stmt  = con.createStatement();
            String query = "select *from pelamar where email = ' "+emil+" ' and password = ' " + pass+";";
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()) {
                idPelamar = rs.getInt(1);
                nama = rs.getString(2);
                jk = rs.getString(3);
                tempatLahir = rs.getString(4);
                tglLahir = rs.getString(5);
                noTlp = rs.getString(6);
                email = rs.getString(7);
                password = rs.getString(8);
            }
            Pelamar p = new Pelamar(idPelamar, nama, email, password);
            p.setJk(jk);
            p.setTempatLahir(tempatLahir);
            p.setNoTlp(noTlp);
            return p;
        }catch (Exception e){
            System.out.println("Data tidak dapat di update!");
            return null;
        }
    }
    
    public void savePelamar(Pelamar p){
        try{
            Statement stmt = con.createStatement();
            String query = "insert into pelamar values("
                    + p.getIdPelamar()+ ", "
                    +p.getNama()+ ", "
                    +p.getJk()+ ", "
                    +p.getTempatLahir()+ ", "
                    +p.getTglLahir()+ ", "
                    +p.getNoTlp()+ ", "
                    +p.getEmail()+ ", "
                    +p.getPassword()
                    + "');";
            stmt.execute(query);
            con.commit();
            stmt.close();
        }catch (SQLException ex){
            System.out.println("Ada error!");
            ex.printStackTrace();
        }
    }
    
    public void setPelamar(Pelamar p){
        try{
            Statement stmt = con.createStatement();
            String query = "update pelamar "
                    + "set nama= ' "+ p.getNama()+ ", "
                    + "email= ' "+ p.getEmail() + ", "
                    + "where idPelamar=" + p.getIdPelamar()+ ";";
            stmt.execute(query);
            con.commit();
            stmt.close();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Ada Error!");
            ex.printStackTrace();
        }
    }
    
    public void updateProfilPelamar(Pelamar p){
        try{
            Statement stmt = con.createStatement();
            String query = "update pelamar "
                    + "set nama= ' " + p.getNama()+ "', "
                    + "jk=' " + p.getJk()+ " ', "
                    + "tempatLahir=' " + p.getTempatLahir()+ " ', "
                    + "tglLahir=' " + p.getTglLahir()+ " ', "
                    + "noTlp=' " + p.getNoTlp()+ " ', "
                    + "email=' " + p.getEmail() + " ', "
                    + "where idPelamar=" + p.getIdPelamar()+ ";";
            stmt.execute(query);
            con.commit();
            stmt.close();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Ada Error!");
            ex.printStackTrace();
        }
    }
    
    public List<Perusahaan> loadPerusahaan(){
        List<Perusahaan> p = new ArrayList<>();
        int idPerusahaan = 0;
        String nmPerusahaan = "";
        String jenis = "";
        String kat = "";
        int karyawan = 0;
        String nama = "";
        String jk = "";
        String tempatLahir = "";
        String tglLahir = null;
        String noTlp = "";
        String email = "";
        String password = "";
        try{
            Statement stmt = con.createStatement();
            String query = "select * from perusahaan;";
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()) {
                idPerusahaan = rs.getInt(1);
                nmPerusahaan = rs.getString(2);
                jenis = rs.getString(3);
                kat = rs.getString(4);
                karyawan = rs.getInt(5);
                nama = rs.getString(6);
                jk = rs.getString(7);
                tempatLahir = rs.getString(8);
                tglLahir = rs.getString(9);
                noTlp = rs.getString(10);
                email = rs.getString(11);
                password = rs.getString(12);
                p.add(new Perusahaan(idPerusahaan, nmPerusahaan, noTlp, jenis, kat, karyawan, nama, email, password));
                p.get(p.size()-1).setTempatLahir(tempatLahir);
                p.get(p.size()-1).setTglLahir(dateFormat.parse(tglLahir));
                p.get(p.size()-1).setJk(jk);
            }
            return p;
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "Ada Error!");
            e.printStackTrace();
            return null;
        }
    }
    
    public Perusahaan loadPerusahaan(String emil, String pass){
        int idPerusahaan = 0;
        String nmPerusahaan = "";
        String jenis = "";
        String kat = "";
        int karyawan = 0;
        String nama = "";
        String jk = "";
        String tempatLahir = "";
        String tglLahir = null;
        String noTlp = "";
        String email = "";
        String password = "";
        try{
            Statement stmt = con.createStatement();
            String query = "select * from perusahaan where email = ' "+emil+" ' and password = ' "+pass+";";
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                idPerusahaan = rs.getInt(1);
                nmPerusahaan = rs.getString(2);
                jenis = rs.getString(3);
                kat = rs.getString(4);
                karyawan = rs.getInt(5);
                nama = rs.getString(6);
                jk = rs.getString(7);
                tempatLahir = rs.getString(8);
                tglLahir = rs.getString(9);
                noTlp = rs.getString(10);
                email = rs.getString(11);
                password = rs.getString(12);
            }
            Perusahaan p = new Perusahaan(idPerusahaan, nmPerusahaan, noTlp, jenis, kat, karyawan, nama, email, password);
            p.setTempatLahir(tempatLahir);
            p.setJk(jk);
            return p;
        }catch (Exception e){
            System.out.println("Data tidak dapat di update!");
            return null;
        }
    }
    
    public void savePerusahaan(Perusahaan p){
        try{
            Statement stmt = con.createStatement();
            String query = "insert into perusahaan values("+""
                    + p.getId() + ", ' "
                    + p.getNmPerusahaan() + " ' , ' "
                    +p.getJenis() + " ',' "
                    + p.getKat() + " ',' "
                    + p.getKaryawan() + ",' "
                    + p.getNama() + " ' ,' "
                    + p.getJk() + " ',' "
                    + p.getTempatLahir() + " ', "
                    + p.getTglLahir()+ ",' "
                    + p.getNoTlp() + " ',' "
                    + p.getEmail()+ " ',' "
                    + p.getPassword()
                    + " ');";
            stmt.execute(query);
            con.commit();
            stmt.close();
        }catch (SQLException ex){
            System.out.println("Ada Error!");
            ex.printStackTrace();
        }
    }
    
    public void setPerusahaan(Perusahaan p){
        try{
            Statement stmt = con.createStatement();
            String query = "update perusahaan "
                    + "set nmPerusahaan=' " + p.getNmPerusahaan() + " ', "
                    + "email=' " + p.getEmail() + " ' "
                    + "where idPerusahaan=" + p.getId()+ ";";
            stmt.execute(query);
            con.commit();
            stmt.close();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Ada Error!");
            ex.printStackTrace();
        }
    }
    
    public void updateProfilPerusahaan(Perusahaan p){
        try{
            Statement stmt = con.createStatement();
            String query = "update perusahaan "
                    + "set nama=' " + p.getNama()+ " ', "
                    + "tempatLahir=' " + p.getTempatLahir()+ " ', "
                    + "tglLahir=' " + p.getTglLahir()+ " ', "
                    + "noTlp=' " + p.getNoTlp()+ " ', "
                    + "email=' " + p.getEmail() + " ', "
                    + "where idPerusahaan=" + p.getId()+ ";";
            stmt.execute(query);
            con.commit();
            stmt.close();
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Ada Error!");
            ex.printStackTrace();
        }
    }
    
    public void saveLowongan(Perusahaan p, Date deadline){
        try{
            Statement stmt = con.createStatement();
            String query = "insert into lowongan values("+
                    + (p.getDaftarLowongan().size()-1) + ",' "
                    + deadline+ " ', "
                    + p.getId()
                    + ");";
            stmt.execute(query);
            con.commit();
            stmt.close();
        }catch(SQLException ex){
            System.out.println("Ada Error!");
            ex.printStackTrace();
        }
    }
    
    public void deleteLowongan(Perusahaan p, int pil){
        try{
            Statement stmt = con.createStatement();
            String query = "delete from lowongan where idPerusahaan = " + p.getId() + " and idLowongan = "+pil+";";
            System.out.println(query);
            stmt.execute(query);
            System.out.println("Berhasil!");
        }catch (Exception e){
            System.out.println("Ada Error!");
            e.printStackTrace();
        }
    }
    
    public Date loadLowongan(int idPerusahaan){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date2 = null;
        try{
            Statement stmt = con.createStatement();
            String query = "select deadline from lowongan where idPerusahaan = "+ idPerusahaan+";";
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next()){
                date2 = rs.getDate(1);
            }
            return date2;
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Data tidak dapat di update!");
            return null;
        }
    }
}
