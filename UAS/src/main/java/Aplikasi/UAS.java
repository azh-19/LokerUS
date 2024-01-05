/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package Aplikasi;

/**
 *
 * @author Azhar Nurulhaifa
 */

import java.sql.SQLException;
import koneksi.database;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UAS {
    private List<Pelamar> daftarPelamar = new ArrayList<>();
    private List<Perusahaan> daftarPerusahaan = new ArrayList();
    private List<String> skill = new ArrayList<>();
    private database db;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    private static int idSkill;
    
    public UAS() throws SQLException {
        db = new database();
        db.con();
        daftarPerusahaan = new ArrayList();
        daftarPelamar = new ArrayList();
        skill = new ArrayList();
    }
    
    public void contohAkun(){
        Perusahaan p = new Perusahaan(daftarPerusahaan.size(), "PT Bank Indonesia", "08", "Perbankan", "Keuangan", 5, "Har", "Haria", "123");
        addPerusahaan(p);
        Perusahaan p1 = new Perusahaan(daftarPerusahaan.size(), "PT Madurasa", "08", "Perbankan", "Keuangan", 5, "Az", "Azia", "apa");
        addPerusahaan(p1);
        
        Date date2 = null;
        try{
            date2 = dateFormat.parse("08-12-2023");
            createLowongan(daftarPerusahaan.get(0), date2);
            date2 = dateFormat.parse("02-02-2023");
            createLowongan(daftarPerusahaan.get(0), date2);
            date2 = dateFormat.parse("02-09-2023");
            createLowongan(daftarPerusahaan.get(1), date2);
            date2 = dateFormat.parse("08-09-2023");
            createLowongan(daftarPerusahaan.get(1), date2);
        }catch(ParseException e){
            e.printStackTrace();
        }
        
        Pelamar pel = new Pelamar(daftarPelamar.size(), "Ajeng", "diah", "haha");
        addPelamar(pel);
    }
    
    public List<String> getSkill() {
        if(skill.isEmpty()){
            return null;
        }else{
            return skill;
        }
    }
    
    public void addSkill(String s){
        skill.add(s);
        idSkill++;
        db.saveSkill(s, idSkill);
    }
    
    public void addPerusahaan(Perusahaan p){
        daftarPerusahaan.add(p);
        db.savePerusahaan(p);
    }
    
    public List<Perusahaan> getDaftarPerusahaan(){
        if(daftarPerusahaan.isEmpty()){
            return null;
        }else{
            return daftarPerusahaan;
        }
    }
    
    public void createLowongan(Perusahaan p, Date tgl){
        p.createLowongan(p.getId(), tgl);
        db.saveLowongan(p, tgl);
    }
    
    public List<Lowongan> getDaftarLowongan(Perusahaan p){
        List<Lowongan> lowongan = new ArrayList<>();
        if(p.getDaftarLowongan() == null){
            return null;
        }else{
            for(Lowongan l : p.getDaftarLowongan()){
                lowongan.add(l);
            }
            db.loadLowongan(p.getId());
            return lowongan;
        }
    }
    
    public void hapusLowongan(Perusahaan p, int pil){
        p.removeLowongan(pil);
        db.deleteLowongan(p, pil);
    }
    
    public void PerusahaanMenu(){
        System.out.println("Pilihan");
        System.out.println("1. Login");
        System.out.println("2. Daftar Akun Perusahaan");
        System.out.println("0. Kembali");
        System.out.println("Masukkan Pilihan : ");
    }
    
    public void perusahaanMainMenu(){
        System.out.println("Pilihan :");
        System.out.println("1. Daftar Pelamar");
        System.out.println("2. Lihat Lowongan dan Detailnya");
        System.out.println("3. Buat Lowongan");
        System.out.println("4. Hapus Lowongan");
        System.out.println("5. Lihat berkas lamaran masuk");
        System.out.println("6. Lihat berkas lamaran di terima");
        System.out.println("0. Keluar");
        System.out.println("Masukkan Pilihan : ");
    }
    
    public void ubahProfilPerusahaan(Perusahaan p, String nama, String email, String tmpt, Date tgl, String notlp){
        p.setNama(nama);
        p.setEmail(email);
        p.setTempatLahir(tmpt);
        p.setTglLahir(tgl);
        p.setNoTlp(notlp);
        db.updateProfilPerusahaan(p);
    }
    
    public void ubahSetPerusahaan(Perusahaan p, String nama, String email){
        p.setNmPerusahaan(nama);
        p.setEmail(email);
        db.setPerusahaan(p);
    }
    
    public Perusahaan LoginPerusahaan(String email, String pass){
        int i = 0;
        Perusahaan p = null;
        boolean find = false;
        if(getDaftarPerusahaan()==null){
            while ((find == false) && i < getDaftarPerusahaan().size()){
                if(getDaftarPerusahaan().get(i).getEmail().equals(email) && getDaftarPerusahaan().get(i).getPassword().equals(pass)){
                   find = true;
                   p = getDaftarPerusahaan().get(i);
                }else{
                    i++;
                }
            }
        }else{
            if(find==true || (i<getDaftarPerusahaan().size()) || (getDaftarPerusahaan()==null)){
                p = db.loadPerusahaan(email, pass);
                if(p!=null){
                    daftarPerusahaan.add(p);
                }
                return p;
            }
        }
        return p;
    }
    
    public void ubahProfilPelamar(Pelamar p, String nama, String email, String jk, String tmpt, Date tgl, String notlp){
        p.setNama(nama);
        p.setEmail(email);
        p.setJk(jk);
        p.setTempatLahir(tmpt);
        p.setTglLahir(tgl);
        p.setNoTlp(notlp);
        db.updateProfilPelamar(p);
    }
    
    public void ubahSetPelamar(Pelamar p, String nama, String email){
        p.setNama(nama);
        p.setEmail(email);
        db.setPelamar(p);
    }
    
    public List<Pelamar> getDaftarPelamar(){
        if(daftarPelamar.isEmpty()){
            return null;
        }else{
            return daftarPelamar;
        }
    }
        
    public void addPelamar(Pelamar p){
         daftarPelamar.add(p);
         db.savePelamar(p);
    }
        
    public Pelamar getDaftarPelamar(int id){
         return daftarPelamar.get(id);
    }
        
    public void deletePelamar(int id){
        daftarPelamar.remove(id);
    }
    
    public berkas lihatBerkas(Pelamar p){
        return p.getB();
    }
    
    public void createBerkas(Pelamar p, List<String> skill){
        p.createBerkas(p.getIdPelamar(), skill);
        db.saveBerkas(p.getIdPelamar(), skill);
    }
    
    public void addBerkasMasuk(Pelamar p){
        db.saveBerkasMasuk(p);
    }
    
    public void addBerkasdiTerima(Pelamar p){
        db.saveBerkasdiTerima(p);
    }
    
    public Pelamar LoginPelamar(String email, String pass){
        int i = 0;
        Pelamar p = null;
        boolean find = false;
        if(getDaftarPelamar()!=null){
            while ((find == false) && i < getDaftarPelamar().size()) {
                if(getDaftarPelamar(i).getEmail().equals(email) && getDaftarPelamar(i).getPassword().equals(pass)) {
                    find = true;
                    p = getDaftarPelamar(i);
                }else{
                    i++;
                }
            }
        }else{
            if((find==false) || (i<getDaftarPelamar().size()) || (getDaftarPelamar()==null)) {
                p = db.loadPelamar(email, pass);
                if(p!=null){
                    daftarPelamar.add(p);
                }
                return p;
            }
        }
        return p;
    }
    
    public void PelamarMenu() {
            System.out.println("Pilihan: ");
            System.out.println("1. Login");
            System.out.println("2. Daftar Akun Pelamar");
            System.out.println("0. Kembali");
            System.out.println("Masukkan Pilihan : ");
    }
    
    public void PelamarMainMenu() {
        System.out.println("Pilihan : ");
        System.out.println("1. Daftar Lamaran");
        System.out.println("2. Profil");
        System.out.println("3. Setting");
        System.out.println("4. Lihat Berkas");
        System.out.println("0. Keluar");
        System.out.println("Masukkan Pilihan : ");
    }
    
    public void pelamarProfil(){
        System.out.println("Profil");
        System.out.println("1. Keahlian");
        System.out.println("2. View Profil");
        System.out.println("3. Buat Berkas");
        System.out.println("0. Kembali");
        System.out.println("Masukkan Pilihan : ");
    }
    
    public void pelamarBerkas() {
        System.out.println("Profil");
        System.out.println("1. Keahlian");
        System.out.println("2. Buat Lamaran");
        System.out.println("0. Kembali");
        System.out.println("Masukkan Pilihan : ");
    }
    
    public void mainMenu() {
        System.out.println("Main Menu");
        System.out.println("1. Cari Lowongan");
        System.out.println("2. Perusahaan");
        System.out.println("3. Pencari Kerja");
        System.out.println("4. Daftar akun");
        System.out.println("0. Keluar");
        System.out.println("Masukkan Pilihan :");
    }
}