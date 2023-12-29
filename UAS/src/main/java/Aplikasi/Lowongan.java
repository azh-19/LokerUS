/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Aplikasi;

/**
 *
 * @author Azhar Nurulhaifa
 */
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.text.ParseException;
import java.util.ArrayList;

public class Lowongan {
    private int idLowongan;
    private List<berkas> berkasMasuk;
    private List<berkas> berkasDiterima;
    private Date deadline;
    
    public Lowongan(int idLowongan, Date deadline) {
        this.idLowongan = idLowongan;
        this.deadline = deadline;
        berkasMasuk = new ArrayList<berkas>();
        berkasDiterima = new ArrayList<berkas>();
    }
    
    public void setIdLowongan(int idLowongan) {
        this.idLowongan = idLowongan;
    }
    
    public int getIdLowongan() {
        return idLowongan;
    }
    
    public berkas getBerkasMasuk(int index) {
        return berkasMasuk.get(index);
    }
    
    public berkas getBerkasMasukbyid(int id){
        if (berkasMasuk.equals(id)){
            return berkasMasuk.get(id);
        }
        return null;
    }
    
    public void setBerkasMasuk(List<berkas> berkasMasuk) {
        this.berkasMasuk = berkasMasuk;
    }
    
    public berkas getBerkasDiterima(int id) {
        return berkasDiterima.get(id);
    }
    
    public List<berkas> gertBerkasMasuk() {
        if(berkasMasuk.isEmpty()) {
            return null;
        }else{
            return berkasMasuk;
        }
    }
    
    public List<berkas> getBerkasDiterima(){
        if(berkasDiterima.isEmpty()){
            return null;
        }else{
            return berkasDiterima;
        }
    }
    
    public void setBerkasDiterima(List<berkas> berkasDiterima) {
        this.berkasDiterima = berkasDiterima;
    }
    
    public Date getDeadline() {
        return deadline;
    }
    
    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }
    
    public void addBerkas(berkas b) {
        berkasMasuk.add(b);
    }
    
    public void removeBerkasMasuk(){
        
    }
    
    public void terimaBerkas(berkas b){
        berkasDiterima.add(b);
    }
    
    @Override
    public String toString() {
        return "Lowongan{" + "idLowongan=" + idLowongan + ", berkasMasuk=" + berkasMasuk + ", berkasDiterima=" + berkasDiterima + ", deadline=" + deadline + '}';
    }
}
