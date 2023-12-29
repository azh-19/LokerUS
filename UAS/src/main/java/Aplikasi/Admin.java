/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Aplikasi;

/**
 *
 * @author Azhar Nurulhaifa
 */

import Aplikasi.Lowongan;
import Aplikasi.Pelamar;
import Aplikasi.Perusahaan;
import java.util.List;

public class Admin {
    private List<Perusahaan> daftarPerusahaan;
    private List<Pelamar> daftarPelamar;
    
    public void addPerusahaan(String nmPerusahaan, String noTlp, String jenis, String kat, int jmlKaryawan, String nm, String email, String pass){
        Perusahaan pe = new Perusahaan(getDaftarPerusahaan().size(), nmPerusahaan, noTlp, jenis, kat, jmlKaryawan, nm, email, pass);
        daftarPerusahaan.add(pe);
    }
    
    public List<Perusahaan> getDaftarPerusahaan() {
        return daftarPerusahaan;
    }
    
    public List<Lowongan> getDaftarLowongan(int i){
        return daftarPerusahaan.get(i).getDaftarLowongan();
    }
    
    public void addPelamar(String nama, String email, String password){
        Pelamar p = new Pelamar(getDaftarPelamar().size(),nama, email,password);
        daftarPelamar.add(p);
    }
    
    public Pelamar getDaftarPelamar(int id){
        return daftarPelamar.get(id);
    }
    
    public void deletePelamar(int id){
        daftarPelamar.remove(id);
    }
    
    public List<Pelamar> getDaftarPelamar(){
        return daftarPelamar;
    }
    
    public void setDaftarPelamar(List<Pelamar> daftarPelamar){
        this.daftarPelamar = daftarPelamar;
    }
}
