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
import java.util.List;

public class Pelamar extends User{
    private berkas b;
    private int idPelamar;
    
    public Pelamar(int id, String nama, String jk, String tempatLahir, Date tglLahir, String noTlp, String email, String password){
        super(id, nama, jk, tempatLahir, tglLahir, noTlp, email, password);
        this.idPelamar = id;
        b = new berkas();
    }
    
    public Pelamar(int id, String nama, String email, String password) {
        super(id, nama, email, password);
        this.idPelamar = id;
        b = new berkas();
    }
    
    public void setIdPelamar(int idPelamar){
        this.idPelamar = idPelamar;
    }
    
    public int getIdPelamar(){
        return idPelamar;
    }
    
    public berkas getB(){
        return b;
    }
    
    public void setB(berkas b){
        this.b = b;
    }
    
    public void createBerkas(int idPelamar, List<String> skill){
        getB().setIdBerkas(idPelamar);
        for(int i = 0; i<skill.size(); i++){
            getB().addSkill(skill.get(i));
        }
    }
}
