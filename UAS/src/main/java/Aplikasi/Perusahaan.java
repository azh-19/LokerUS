package Aplikasi;

import Aplikasi.Lowongan;
import Aplikasi.User;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Perusahaan extends User{
    private List<Lowongan> daftarLowongan;
    private int id;
    private String nmPerusahaan;
    private String jenis;
    private String kat;
    private int karyawan;

    // Constructor
    public Perusahaan(int id, String nama, String jk, String tempatLahir, Date tglLahir, String noTlp, String email, String password, String nmPerusahaan){
        super(id, nama, jk, tempatLahir, tglLahir, noTlp, email, password);
        this.id = id;
        this.nmPerusahaan = nmPerusahaan;
        daftarLowongan = new ArrayList<Lowongan>() {};
    }
    
    public Perusahaan(int id, String nmPerusahaan, String noTelp, String jenis, String kat, int karyawan, String nama, String email, String password){
        super(id, nama, noTelp, email, password);
        this.id = id;
        this.nmPerusahaan = nmPerusahaan;
        this.jenis = jenis;
        this.kat = kat;
        this.karyawan = karyawan;
        daftarLowongan = new ArrayList<Lowongan>() {};
    }
  
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Lowongan getDaftarLowongan(int id){
       return daftarLowongan.get(id);
    }

    public List<Lowongan> getDaftarLowongan() {
        if(daftarLowongan.isEmpty()){
            return null;
        }else{
            return daftarLowongan;
        }
    }

    public void setDaftarLowongan(List<Lowongan> daftarLowongan) {
        this.daftarLowongan = daftarLowongan;
    }
    
    public String getNmPerusahaan() {
        return nmPerusahaan;
    }

    public void setNmPerusahaan(String nmPerusahaan) {
        this.nmPerusahaan = nmPerusahaan;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getKat() {
        return kat;
    }

    public void setKat(String kat) {
        this.kat = kat;
    }

    public int getKaryawan() {
        return karyawan;
    }

    public void setKaryawan(int karyawan) {
        this.karyawan = karyawan;
    }
      
    //Method
    public void createLowongan(int idlowongan, Date deadline) {
        Lowongan l = new Lowongan(idlowongan, deadline);
        daftarLowongan.add(l);
    }
    
    public void removeLowongan(int id){
        daftarLowongan.remove(id);
    }

    @Override
    public String toString() {
        return "Perusahaan{" + "daftarLowongan=" + daftarLowongan + ", id=" + id + ", nmPerusahaan=" + nmPerusahaan + ", jenis=" + jenis + ", kat=" + kat + ", karyawan=" + karyawan + '}';
    }   

}