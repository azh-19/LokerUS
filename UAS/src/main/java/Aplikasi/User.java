/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Aplikasi;

/**
 *
 * @author Azhar Nurulhaifa
 */
import java.util.Date;

abstract public class User {
    private int id;
    private String nama;
    private String jk;
    private String tempatLahir;
    private Date tglLahir;
    private String noTlp;
    private String email;
    private String password;
    
    public User(int id, String nama, String jk, String tempatLahir, Date tglLahir, String noTlp, String email, String password){
        this.id = id;
        this.nama = nama;
        this.jk = jk;
        this.tempatLahir = tempatLahir;
        this.noTlp = noTlp;
        this.email = email;
        this.password = password;
    }
    
    public User(int id, String nama,String email, String password){
        this.id = id;
        this.nama = nama;
        this.email = email;
        this.password = password;
    }
    
    public User(int id, String nama, String noTlp, String email, String password){
        this.id = id;
        this.nama = nama;
        this.noTlp = noTlp;
        this.email = email;
        this.password = password;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getNama(){
        return nama;
    }
    
    public void setNama(String nama){
        this.nama = nama;
    }
    
    public String getJk(){
        return jk;
    }
    
    public void setJk(String jk){
        this.jk = jk;
    }
    
    public String getTempatLahir(){
        return tempatLahir;
    }
    
    public void setTempatLahir(String tempatLahir){
        this.tempatLahir = tempatLahir;
    }
    
    public Date getTglLahir(){
        return tglLahir;
    }
    
    public void setTglLahir(Date tglLahir){
        this.tglLahir = tglLahir;
    }
    
    public String getNoTlp(){
        return noTlp;
    }
    
    public void setNoTlp(String noTlp){
        this.noTlp = noTlp;
    }
    
    public String getEmail(){
        return email;
    }
    
    public void setEmail(String email){
        this.email = email;
    }
    
    public String getPassword(){
        return password;
    }
    
    public void setPassword(String password){
        this.password = password;
    }
}
