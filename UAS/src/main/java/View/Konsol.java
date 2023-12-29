package View;

import Aplikasi.UAS;
import Aplikasi.berkas;
import Aplikasi.Pelamar;
import Aplikasi.Perusahaan;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Diah Ajeng
 */
public class Konsol {

    UAS Aplikasi;
    
    Scanner inpInteger = new Scanner(System.in);
    Scanner inpString = new Scanner(System.in);
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    Date tgl=null;
    
    public Konsol(UAS Aplikasi) {
        this.Aplikasi = Aplikasi;
    }
    
    public void MainMenu() throws ParseException{
        // Menu
        System.out.println("LokerUs");
        System.out.println("Pekerjaan Terbaik Menanti Anda!");
        System.out.println("-------------------------------");
        boolean keluar = false;
        do{
            Aplikasi.mainMenu();
            try{
                int pil = Integer.parseInt(inpString.nextLine());
                switch(pil){
                    case 0 : // Keluar
                        System.out.println("Program Keluar");
                        keluar = true;
                        break;
                    case 1 : // Daftar Lowongan Kerja
                        if(Aplikasi.getDaftarPerusahaan()==null){
                            System.out.println("Tidak Ada Daftar Lowongan");
                        }else{
                            LihatDaftarLowongan();
                        }
                        System.out.println("Tekan Enter...");
                        String in = inpString.nextLine();
                        break;
                    case 2 : // Perusahaan
                        MenuPerusahaan();
                        in = inpString.nextLine();
                        break;
                    case 3 : // Pelamar
                        MenuPelamar();
                        in = inpString.nextLine();
                        break;
                    case 4 : // Daftar Akun
                        boolean exit = false;
                        do {
                            exit = DaftarAkun(exit);
                        } while (exit == false);
                        in = inpString.nextLine();
                        break;
                    default :
                        System.out.println("Pilihan Tidak Ada! Tekan Enter...");
                        in = inpString.nextLine();
                        break;
                }
            }catch(Exception e){
                System.out.print("Terjadi kesalahan. Tekan Enter...");
                String in = inpString.nextLine();
            }
        }while(keluar == false);
    }
    
    void LihatDaftarLowongan(){
        // show all
        System.out.println("Daftar Lowongan Kerja\n=====================");
        int SP = Aplikasi.getDaftarPerusahaan().size();
        for(int i=0;i<=SP-1;i++){
            String namaPerusahaan = Aplikasi.getDaftarPerusahaan().get(i).getNmPerusahaan(); 
            if(Aplikasi.getDaftarPerusahaan().get(i).getDaftarLowongan() == null){
                System.out.println("Perusahaan " + namaPerusahaan + " tidak memiliki lowongan pekerjaan");
            }else{
                System.out.println("Nama Perusahaan : " + namaPerusahaan);
                int SL = Aplikasi.getDaftarPerusahaan().get(i).getDaftarLowongan().size();
                for (int j = 0; j <= SL-1; j++) {
                    System.out.println("Lowongan " + (j+1));
                    System.out.println("\t Deadline : " + dateFormat.format(Aplikasi.getDaftarPerusahaan().get(i).getDaftarLowongan(j).getDeadline()) + "\n");
                } 
            }
        } 
    }
    
    void MenuPerusahaan(){
        boolean keluar = false;
        do {
            Aplikasi.PerusahaanMenu();
            try{
                int n = Integer.parseInt(inpString.nextLine());
                switch(n){
                    case 0 : // Kembali
                        keluar = true;
                        break;
                    case 1 : // Login Perusahaan
                        System.out.println("Silahkan masukkan kredensial login Anda di bawah ini.");
                        System.out.println("=====================================================");
                        System.out.print("Email      : ");
                        String email = inpString.nextLine();
                        System.out.print("Kata Sandi : ");
                        String pass = inpString.nextLine();
                        // search
                        Perusahaan perusahaan = Aplikasi.LoginPerusahaan(email, pass);
                        if(perusahaan != null){
                            PerusahaanMainMenu(perusahaan);
                        }else{
                            System.out.println("Masukkan field dengan benar");
                        }
                        System.out.print("Tekan Enter...");
                        String in = inpString.nextLine();
                        break;
                    case 2 : // Daftar Akun Perusahaan
                        DaftarPerusahaan();
                        break;
                    default :
                        System.out.println("Pilihan Tidak Ada! Tekan Enter...");
                        in = inpString.nextLine();
                        break;
                }
            }catch(Exception e8){
                System.out.println("Terjadi kesalahan input. Tekan Enter...");
                String in = inpString.nextLine();
            }  
        }while (keluar == false); 
    }
    
    void DaftarPerusahaan(){
        System.out.println("Silahkan Mendaftar.");
        System.out.println("==================");
        System.out.print("Nama Perusahaan   : ");
        String nmPerusahaan = inpString.nextLine();
        System.out.print("No Telp           : ");
        String noTelp = inpString.nextLine();
        System.out.print("Jenis             : ");
        String jenis = inpString.nextLine();
        System.out.print("Kategori          : ");
        String kat = inpString.nextLine();
        System.out.print("Jumlah Karyawan   : ");
        int karyawan = inpInteger.nextInt();
        System.out.print("Nama              : ");
        String nama = inpString.nextLine();
        System.out.print("Email             : ");
        String email = inpString.nextLine();
        System.out.print("Kata Sandi        : ");
        String password = inpString.nextLine();
        // create
        if(Aplikasi.getDaftarPerusahaan()==null){
            Aplikasi.addPerusahaan(new Perusahaan(0, nmPerusahaan, noTelp, jenis, kat, karyawan, nama, email, password));
        }else{
            Aplikasi.addPerusahaan(new Perusahaan(Aplikasi.getDaftarPerusahaan().size(), nmPerusahaan, noTelp, jenis, kat, karyawan, nama, email, password));
        }
        System.out.println("Berhasil. Silahkan Login! Tekan Enter...");
        String inpt = inpString.nextLine();
    }

    void PerusahaanMainMenu(Perusahaan perusahaan){
        System.out.println("Selamat Datang Perusahaan " + perusahaan.getNmPerusahaan());
        System.out.println("=================================");
        boolean keluar = false;
        do {
            Aplikasi.perusahaanMainMenu();
            try{
                int pil = Integer.parseInt(inpString.nextLine());
                switch(pil){
                    case 0 : // Keluar
                        System.out.println("Apakah anda yakin akan keluar?");
                        System.out.print("Pilihan (Ya/Tidak) : ");
                        String inpt = inpString.nextLine();
                        if(inpt.equals("Ya") || inpt.equals("ya")){
                            keluar = true;
                        }else{
                            System.out.print("Tekan Enter...");
                            inpt = inpString.nextLine();
                        }
                        break;
                    case 1 : // Daftar Pelamar
                        System.out.println("Daftar Pelamar (Keseluruhan) : ");
                        if(perusahaan.getDaftarLowongan() == null){
                            System.out.println("Tidak ada pelamar");
                        }else{
                            int jmlLow = perusahaan.getDaftarLowongan().size();
                            int st =0;
                            for (int j = 0; j <= jmlLow-1; j++) {
                                if(perusahaan.getDaftarLowongan(j).gertBerkasMasuk() == null){
                                    st++;
                                }else{
                                    int jmlBerkas = perusahaan.getDaftarLowongan(j).gertBerkasMasuk().size();
                                    System.out.println("Ada " + jmlBerkas + " berkas yang masuk");
                                    for (int k = 0; k <= jmlBerkas-1; k++) {
                                        System.out.println("Berkas Masuk ke-" + (k+1));
                                        for (int i = 0; i < Aplikasi.getDaftarPelamar().size(); i++) {
                                            if(Aplikasi.getDaftarPelamar(i).getIdPelamar() == perusahaan.getDaftarLowongan(j).getBerkasMasuk(k).getIdBerkas()){
                                                System.out.println("\t Nama            : "+Aplikasi.getDaftarPelamar(i).getNama());
                                                System.out.println("\t No Telp         : "+Aplikasi.getDaftarPelamar(i).getNoTlp());
                                                System.out.println("\t Jenis Kelamin   : "+Aplikasi.getDaftarPelamar(i).getJk() );
                                                System.out.println("\t TTL             : "+Aplikasi.getDaftarPelamar(i).getTempatLahir()+", "+Aplikasi.getDaftarPelamar(i).getTglLahir());
                                            }
                                        }
                                    }
                                }
                            }
                            if(st == jmlLow){
                                System.out.println("Tidak ada pelamar");
                            }
                        }
                        System.out.print("Tekan Enter...");
                        inpt = inpString.nextLine();
                        break;
                    case 2 : // Lihat Lowongan
                        System.out.println("Lihat Lowongan : ");
                        if(perusahaan.getDaftarLowongan() == null){
                            System.out.println("Tidak ada lowongan. Silahkan buat lowongan!");
                        }else {
                            int jmlLow = perusahaan.getDaftarLowongan().size();
                            for (int j = 0; j <= jmlLow-1; j++) {
                                System.out.println("Lowongan ke-" + (j+1));
                                System.out.println("\t Deadline : " + dateFormat.format(perusahaan.getDaftarLowongan(j).getDeadline()) + "\n");
                                // berkas masuk
                                if(perusahaan.getDaftarLowongan(j).gertBerkasMasuk() == null){
                                    System.out.println("Tidak ada berkas masuk pada lowongan ini \n");
                                }else{
                                    int jmlBerkas = perusahaan.getDaftarLowongan(j).gertBerkasMasuk().size();
                                    System.out.println("Ada " + jmlBerkas + " berkas yang masuk");
                                    for (int k = 0; k <= jmlBerkas-1; k++) {
                                        System.out.println("Berkas Masuk ke-" + (k+1));
                                        for (int i = 0; i < Aplikasi.getDaftarPelamar().size(); i++) {
                                            if(Aplikasi.getDaftarPelamar(i).getIdPelamar() == perusahaan.getDaftarLowongan(j).getBerkasMasuk(k).getIdBerkas()){
                                                System.out.println("\t Nama            : "+Aplikasi.getDaftarPelamar(i).getNama());
                                                System.out.println("\t No Telp         : "+Aplikasi.getDaftarPelamar(i).getNoTlp());
                                                System.out.println("\t Jenis Kelamin   : "+Aplikasi.getDaftarPelamar(i).getJk() );
                                                System.out.println("\t TTL             : "+Aplikasi.getDaftarPelamar(i).getTempatLahir()+", "+Aplikasi.getDaftarPelamar(i).getTglLahir());
                                                System.out.println("\tKeahlian         : ");
                                                for (int l = 0; l < Aplikasi.getDaftarPelamar(i).getB().getSkill().size(); l++) {
                                                    System.out.println("\t\t"+(l+1)+". "+Aplikasi.getDaftarPelamar(i).getB().getSkill().get(i));
                                                }
                                            }
                                        }
                                    }
                                    System.out.println("Apakah anda kana menerima berkas lamaran?");
                                    System.out.print("Masukkan pilihan (Ya/Tidak) : ");
                                    inpt = inpString.nextLine();
                                    if(inpt.equals("Ya") || inpt.equals("ya")){
                                        System.out.print("Masukkan pilihan berkas (1 - "+jmlBerkas+") : ");
                                        int plh = Integer.parseInt(inpString.nextLine());
                                        try{
                                            if((plh > jmlBerkas) || (plh < 0)){
                                                System.out.println("Perintah tdk tersedia");
                                            }else{
                                                perusahaan.getDaftarLowongan(j).terimaBerkas(Aplikasi.getDaftarPelamar(plh-1).getB());
                                                Aplikasi.addBerkasdiTerima(Aplikasi.getDaftarPelamar(plh-1));
                                                System.out.println("Berhasil"); 
                                            }
                                        }catch(Exception ex){
                                            System.out.println("file tdk terinput");
                                        }
                                    }
                                    System.out.println("Apakah Anda akan melihat berkas yang diterima? ");
                                    System.out.print("Masukkan Pilihan (Ya/Tidak) : ");
                                    inpt = inpString.nextLine();
                                    if(inpt.equals("Ya") || inpt.equals("ya")){
                                        // berkas di terima
                                        if(perusahaan.getDaftarLowongan(j).getBerkasDiterima()== null){
                                            System.out.println("Tidak ada berkas yang di terima pada lowongan ini \n");
                                        }else{
                                            int jmlterima = perusahaan.getDaftarLowongan(j).getBerkasDiterima().size();
                                            System.out.println("Ada " + jmlterima + " berkas yang di terima");
                                            for (int k = 0; k <= jmlterima-1; k++) {
                                                System.out.println("Berkas di Terima ke-" + (k+1));
                                                for (int i = 0; i < Aplikasi.getDaftarPelamar().size(); i++) {
                                                    if(Aplikasi.getDaftarPelamar(i).getIdPelamar() == perusahaan.getDaftarLowongan(j).getBerkasDiterima(k).getIdBerkas()){
                                                        System.out.println("\t Nama          : "+Aplikasi.getDaftarPelamar(i).getNama());
                                                        System.out.println("\t No Telp       : "+Aplikasi.getDaftarPelamar(i).getNoTlp());
                                                        System.out.println("\t Jenis Kelamin : "+Aplikasi.getDaftarPelamar(i).getJk() );
                                                        System.out.println("\t TTL           : "+Aplikasi.getDaftarPelamar(i).getTempatLahir()+", "+Aplikasi.getDaftarPelamar(i).getTglLahir());
                                                        System.out.println("\tKeahlian : ");
                                                        for (int l = 0; l <Aplikasi.getDaftarPelamar(i).getB().getSkill().size(); l++) {
                                                            System.out.println("\t\t"+(l+1)+". "+Aplikasi.getDaftarPelamar(i).getB().getSkill().get(i));
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                        System.out.print("Tekan Enter...");
                        inpt = inpString.nextLine();
                        break;
                    case 3 : //Buat Lowongan
                        System.out.print("Masukkan Tanggal : ");
                        String tggl = inpString.nextLine();
                        try {
                            tgl = dateFormat.parse(tggl);
                            System.out.println(perusahaan.getNmPerusahaan());
                            // create
                            Aplikasi.createLowongan(perusahaan, tgl);
                            System.out.println("Lowongan telah dibuat!");
                        } catch (ParseException par) {
                            par.printStackTrace();
                        }
                        System.out.print("Tekan Enter...");
                        inpt = inpString.nextLine();
                        break;
                    case 4 : //Hapus Lowongan
                        System.out.println("Daftar Lowongan Kerja\n=====================");
                        int SL = perusahaan.getDaftarLowongan().size();
                        for (int j = 0; j <= SL-1; j++) {
                            System.out.println("Lowongan " + (j+1));
                            System.out.println("\t Deadline : " + dateFormat.format(perusahaan.getDaftarLowongan(j).getDeadline()) + "\n");
                        } 
                        System.out.println("Apakah Anda Akan menghapus data lowongan kerja?");
                        System.out.print("Masukkan pilihan (Ya/Tidak) :");
                        inpt = inpString.nextLine();
                        if(inpt.equals("Ya") || inpt.equals("ya")){
                            System.out.print("Masukkan pilihan berkas (1 - "+SL+") : ");
                            int plh = Integer.parseInt(inpString.nextLine());
                            try{
                                if((plh > (SL-1))||(plh < 0)){
                                    System.out.println("Perintah tdk tersedia");
                                }else{
                                    Aplikasi.hapusLowongan(perusahaan, plh-1);
                                    System.out.println("Berhasil");
                                }
                            }catch(Exception ex){
                                System.out.println("data tdk terinput");
                                ex.printStackTrace();
                            }
                        }
                        System.out.print("Tekan Enter...");
                        inpt = inpString.nextLine();
                        break;
                    case 5 : //Lihat Berkas Lamaran Masuk
                        System.out.println("Berkas Lamaran Masuk : ");
                        if(perusahaan.getDaftarLowongan() == null){
                            System.out.println("Tidak ada lamaran masuk");
                        }else{
                            int jmlLow = perusahaan.getDaftarLowongan().size();
                            int st = 0;
                            for (int j = 0; j <= jmlLow-1; j++) {
                                if(perusahaan.getDaftarLowongan(j).gertBerkasMasuk() == null){
                                    st++;
                                }else{
                                    int jmlBerkas = perusahaan.getDaftarLowongan(j).gertBerkasMasuk().size();
                                    System.out.println("Ada " + jmlBerkas + " berkas yang masuk");
                                    for (int k = 0; k <= jmlBerkas-1; k++) {
                                        System.out.println("Berkas Masuk ke-" + (k+1));
                                        for (int i = 0; i < Aplikasi.getDaftarPelamar().size(); i++) {
                                            if(Aplikasi.getDaftarPelamar(i).getIdPelamar() == perusahaan.getDaftarLowongan(j).getBerkasMasuk(k).getIdBerkas()){
                                                System.out.println("\t Nama            : "+Aplikasi.getDaftarPelamar(i).getNama());
                                                System.out.println("\t No Telp         : "+Aplikasi.getDaftarPelamar(i).getNoTlp());
                                                System.out.println("\t Jenis Kelamin   : "+Aplikasi.getDaftarPelamar(i).getJk() );
                                                System.out.println("\t TTL             : "+Aplikasi.getDaftarPelamar(i).getTempatLahir()+", "+Aplikasi.getDaftarPelamar(i).getTglLahir());
                                                System.out.println("\tKeahlian         : ");
                                                for (int l = 0; l < Aplikasi.getDaftarPelamar(i).getB().getSkill().size(); l++) {
                                                    System.out.println("\t\t"+(l+1)+". "+Aplikasi.getDaftarPelamar(i).getB().getSkill().get(i));
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            if(st == jmlLow){
                                System.out.println("Tidak ada lamaran masuk.");
                            }
                        }
                        System.out.print("Tekan Enter...");
                        inpt = inpString.nextLine();
                        break;
                    case 6 : //Lihat Berkas Lamaran Di Terima
                        if(perusahaan.getDaftarLowongan() == null){
                            System.out.println("Tidak ada lamaran masuk yang di terima");
                        }else{
                            int jmlLow = perusahaan.getDaftarLowongan().size();
                            int st = 0;
                            for (int j = 0; j <= jmlLow-1; j++) {
                                if(perusahaan.getDaftarLowongan(j).getBerkasDiterima() == null){
                                    st++;
                                }else{
                                    int jmlterima = perusahaan.getDaftarLowongan(j).getBerkasDiterima().size();
                                    System.out.println("Ada " + jmlterima + " berkas yang di terima");
                                    for (int k = 0; k <= jmlterima-1; k++) {
                                        System.out.println("Berkas di Terima ke-" + (k+1));
                                        for (int i = 0; i < Aplikasi.getDaftarPelamar().size(); i++) {
                                            if(Aplikasi.getDaftarPelamar(i).getIdPelamar() == perusahaan.getDaftarLowongan(j).getBerkasDiterima(k).getIdBerkas()){
                                                System.out.println("\t Nama          : "+Aplikasi.getDaftarPelamar(i).getNama());
                                                System.out.println("\t No Telp       : "+Aplikasi.getDaftarPelamar(i).getNoTlp());
                                                System.out.println("\t Jenis Kelamin : "+Aplikasi.getDaftarPelamar(i).getJk() );
                                                System.out.println("\t TTL           : "+Aplikasi.getDaftarPelamar(i).getTempatLahir()+", "+Aplikasi.getDaftarPelamar(i).getTglLahir());
                                                System.out.println("\tKeahlian : ");
                                                for (int l = 0; l < Aplikasi.getDaftarPelamar(i).getB().getSkill().size(); l++) {
                                                    System.out.println("\t\t"+(l+1)+". "+Aplikasi.getDaftarPelamar(i).getB().getSkill().get(i));
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            if(st == jmlLow){
                                System.out.println("Tidak ada lamaran masuk yang di terima.");
                            }
                        }
                        System.out.print("Tekan Enter...");
                        inpt = inpString.nextLine();
                        break;
                    default : 
                        System.out.println("Perintah tidak tersedia. Tekan Enter...");
                        inpt = inpString.nextLine();
                        break;
                }
            }catch(Exception e7){
                System.out.println("Kesalahan input. Tekan Enter...");
                String inpt = inpString.nextLine();
            }
        } while (keluar == false);
    }
    
    void MenuPelamar(){
        boolean keluar = false;
        do {
            Aplikasi.PelamarMenu();
            try{
                int pilihan = Integer.parseInt(inpString.nextLine());
                switch(pilihan){
                    case 0 : // Kembali
                        keluar = true;
                        break;
                    case 1 : // Login
                        System.out.println("Silahkan masukkan kredensial login Anda di bawah ini.");
                        System.out.println("=====================================================");
                        System.out.print("Email      : ");
                        String email = inpString.nextLine();
                        System.out.print("Password : ");
                        String pass = inpString.nextLine();
                        // search
                        Pelamar pelamar = Aplikasi.LoginPelamar(email, pass);
                        if(pelamar!=null){
                            PelamarMainMenu(pelamar);
                        }else{
                            System.out.println("Masukkan field dengan benar");
                        }
                        break;
                    case 2 : // Daftar Akun Pelamar
                        DaftarPelamar();
                        break;
                    default :
                        System.out.println("Perintah tidak tersedia. Tekan Enter");
                        String inpt = inpString.nextLine();
                        break;
                }
            }catch(Exception e6){
                System.out.println("Kesalahan input. Tekan Enter");
                String inpt = inpString.nextLine();
            }
            
        } while (keluar = false);
    }
    
    void DaftarPelamar(){
        System.out.println("Silahkan Mendaftar.");
        System.out.println("===================");
        System.out.print("Nama              : ");
        String nama = inpString.nextLine();
        System.out.print("Email             : ");
        String email = inpString.nextLine();
        System.out.print("Password        : ");
        String pass = inpString.nextLine();
        // create
        if(Aplikasi.getDaftarPelamar()==null){
            Aplikasi.addPelamar(new Pelamar(0,nama, email, pass));
        }else{
            Aplikasi.addPelamar(new Pelamar(Aplikasi.getDaftarPelamar().size(),nama, email, pass));
        }
        System.out.println("Berhasil. Silahkan Login! Tekan Enter...");
        String inpt = inpString.nextLine();
    }
    
    void PelamarMainMenu(Pelamar pelamar){
        int count = 0;
        System.out.println("Selamat Datang " + pelamar.getNama());
        System.out.println("=================================");
        boolean keluar = false;
        do {
            Aplikasi.PelamarMainMenu();
            try{
                int pil = Integer.parseInt(inpString.nextLine());
                switch(pil){
                    case 0 : // Keluar
                        System.out.println("Apakah anda yakin akan keluar?");
                        System.out.print("Pilihan (Ya/Tidak) : ");
                        String inpt = inpString.nextLine();
                        if(inpt.equals("Ya") || inpt.equals("ya")){
                            keluar = true;
                        }else{
                            inpt = inpString.nextLine();
                        }
                        break;
                    case 1 : // Daftar Lamaran dan Lowongan
                        LihatDaftarLowongan();
                        List<Perusahaan> p = Aplikasi.getDaftarPerusahaan();
                        System.out.println("Daftar yang di Lamaran : ");
                        int jml = p.size();
                        boolean sts = false;
                        for (int i = 0; i < jml; i++) {
                            int jmlL = p.get(i).getDaftarLowongan().size();
                            for (int j = 0; j < jmlL; j++) {
                                if(p.get(i).getDaftarLowongan(j).gertBerkasMasuk() != null){
                                   int jmlB = p.get(i).getDaftarLowongan(j).gertBerkasMasuk().size();
                                    for (int k = 0; k < jmlB; k++) {
                                        if(p.get(i).getDaftarLowongan(j).getBerkasMasuk(k).getIdBerkas()==(pelamar.getB().getIdBerkas())){
                                            System.out.println("Nama Perusahaan yang anda lamar : "+p.get(i).getNmPerusahaan());
                                            sts = true;
                                        }
                                    } 
                                }
                            }
                        }
                        if(sts == false){
                            System.out.println("Tidak ada perusahaan yang anda lamar");
                        }
                        sts = false;
                        inpt = inpString.nextLine();
                        System.out.println("Daftar Lamaran di Terima : ");
                        for (int i = 0; i < jml; i++) {
                            int jmlL = p.get(i).getDaftarLowongan().size();
                            for (int j = 0; j < jmlL; j++) {
                                if(p.get(i).getDaftarLowongan(j).getBerkasDiterima()!= null){
                                   int jmlB = p.get(i).getDaftarLowongan(j).getBerkasDiterima().size();
                                    for (int k = 0; k < jmlB; k++) {
                                        if(p.get(i).getDaftarLowongan(j).getBerkasDiterima(k).getIdBerkas()==(pelamar.getB().getIdBerkas())){
                                            System.out.println("Anda di terima di Perusahaan : "+p.get(i).getNmPerusahaan());
                                            sts = true;
                                        }
                                    } 
                                }
                            }
                        }
                        if(sts == false){
                            System.out.println("Belum ada berkas lamaran yang di terima");
                        }
                        inpt = inpString.nextLine();
                        System.out.println("Apakah anda akan melamar pekerjaan?");
                        System.out.print("Masukkan pilihan (Ya/Tidak) : ");
                        inpt = inpString.nextLine();
                        if(inpt.equals("Ya") || inpt.equals("ya")){
                            System.out.print("Masukkan Nama Perusahaan yang Akan Anda Lamar : ");
                            inpt = inpString.nextLine();
                            // search
                            int jmlP = Aplikasi.getDaftarPerusahaan().size();
                            boolean status = false;
                            for (int j = 0; j <= jmlP-1; j++) {
                                if(p.get(j).getNmPerusahaan().equals(inpt)){
                                    int jmlL = p.get(j).getDaftarLowongan().size();
                                    for (int k = 0; k <= jmlL-1; k++) {
                                        if(p.get(j).getDaftarLowongan(k).getIdLowongan()== p.get(j).getId()){
                                            System.out.println("Lowongan ke-" + (k+1));
                                            System.out.println("\t Deadline : " + dateFormat.format(p.get(j).getDaftarLowongan(k).getDeadline()) + "\n");
                                            status = true;
                                        }
                                    }
                                    if(status == true){
                                        System.out.print("Masukkan pilihan (1 - " + jmlP + ") : ");
                                        int pilihan = Integer.parseInt(inpString.nextLine());
                                        if((pilihan > jmlP)||(pilihan < 0)){
                                            System.out.println("Perintah tdk tersedia");
                                        }else{
                                            p.get(j).getDaftarLowongan(pilihan-1).addBerkas(pelamar.getB());
                                            Aplikasi.addBerkasMasuk(pelamar);
                                            System.out.println("Anda berhasil melamar"); 
                                        }
                                    }else{
                                        System.out.println("Data tidak ditemukan"); 
                                    }
                                }
                            }
                        }
                        break;
                    case 2 : // Profil Pelamar memunculkan detail (editable)
                        boolean kluar = false;
                        do{
                            Aplikasi.pelamarProfil();
                            pil = Integer.parseInt(inpString.nextLine());
                            switch(pil){
                                case 0 :
                                    kluar = true;
                                    break;
                                case 1 : // Skill
                                    System.out.print("Banyak Keahlian : ");
                                    try{
                                        int n = Integer.parseInt(inpString.nextLine());
                                        for (int j = 0; j < n; j++) {
                                            System.out.print("Keahlian ke-"+(j+1)+" = ");
                                            String nmKeahlian = inpString.nextLine();
                                            Aplikasi.addSkill(nmKeahlian);
                                            System.out.print("Berhasil. Tekan Enter...");
                                        }
                                    }catch(Exception e1){
                                        System.out.print("Perintah tdk tersedia. Tekan Enter...");
                                String inp = inpString.nextLine();
                                    }
                                String inp = inpString.nextLine();
                                    break;

                                case 2 :
                                    System.out.println("Pengaturan / Profil");
                                    System.out.println("Nama          : "+((pelamar.getNama() == null) ? "N/A" : pelamar.getNama()));
                                    System.out.println("Email         : "+((pelamar.getEmail() == null) ? "N/A" : pelamar.getEmail()));
                                    System.out.println("Jenis Kelamin : "+((pelamar.getJk()== null) ? "N/A" : pelamar.getJk()));
                                    System.out.println("Tempat Lahir  : "+((pelamar.getTempatLahir()== null) ? "N/A" : pelamar.getTempatLahir()));
                                    System.out.println("Tanggal Lahir : "+((pelamar.getTglLahir()== null) ? "N/A" : dateFormat.format(pelamar.getTglLahir())));
                                    System.out.println("No Telp       : "+((pelamar.getNoTlp()== null) ? "N/A" : pelamar.getNoTlp()));
                                    System.out.println("Apakah anda akan mengubah ?");
                                    System.out.println("Pilihan (Ya/Tidak) : ");
                                    inpt = inpString.nextLine();
                                    if(inpt.equals("Ya") || inpt.equals("ya")){
                                        System.out.println("Isi data secara lengkap!");
                                        System.out.println("Pengaturan / Profil");
                                        System.out.print("Nama          : ");
                                        String nama = inpString.nextLine();
                                        System.out.print("Email         : ");
                                        String email = inpString.nextLine();
                                        System.out.print("Jenis Kelamin : ");
                                        String jk = inpString.nextLine();
                                        System.out.print("Tempat Lahir  : ");
                                        String tmpt = inpString.nextLine();
                                        System.out.print("Tanggal Lahir : ");
                                        String tggl = inpString.nextLine();
                                        try {
                                            tgl = dateFormat.parse(tggl);
                                        } catch (ParseException pars) {
                                            pars.printStackTrace();
                                        }
                                        System.out.print("No Telp       : ");
                                        String notelp = inpString.nextLine();
                                        Aplikasi.ubahProfilPelamar(pelamar, nama, email, jk, tmpt, tgl, notelp);
                                        System.out.println("Data berhasil di ubah! Tekan Enter");
                                    }
                                    inp = inpString.nextLine();
                                    break;
                                case 3 : //Buat berkas
                                    berkas berkas1 = Aplikasi.lihatBerkas(pelamar);
                                    if(Aplikasi.getSkill()==null){
                                        System.out.println("Isi gelar, bahasa, keahlian dan pengalaman secara lengkap!");
                                    }else if(berkas1.getIdBerkas()==pelamar.getIdPelamar()){
                                        pelamar.getB().getSkill().clear();
                                        try{
                                            Aplikasi.createBerkas(pelamar,Aplikasi.getSkill());
                                            System.out.print("Berhasil. Tekan Enter");
                                        }catch(Exception excep){
                                            System.out.print("Berkas tidak dapat di buat. Tekan Enter");
                                            excep.printStackTrace();
                                        }
                                    }else{
                                        try{
                                            Aplikasi.createBerkas(pelamar,Aplikasi.getSkill());
                                            System.out.print("Berhasil. Tekan Enter");
                                        }catch(Exception kc){
                                            System.out.print("Berkas tidak dapat di buat. Tekan Enter");
                                        }
                                    }
                                    inp = inpString.nextLine();
                                    break;
                            }
                        }while(kluar == false);
                        break;
                    case 3 : // Setting Akun Pelamar memunculkan nama dan email (editable)
                        System.out.println("Pengaturan / Setting");
                        System.out.println("Nama          : "+((pelamar.getNama() == null) ? "N/A" : pelamar.getNama()));
                        System.out.println("Email         : "+((pelamar.getEmail() == null) ? "N/A" : pelamar.getEmail()));
                        System.out.println("Apakah anda akan mengubah ?");
                        System.out.println("Pilihan (Ya/Tidak) : ");
                        inpt = inpString.nextLine();
                        if(inpt.equals("Ya") || inpt.equals("ya")){
                            System.out.println("Isi data secara lengkap!");
                            System.out.println("Pengaturan / Setting");
                            System.out.print("Nama         : ");
                            String nama = inpString.nextLine();
                            System.out.print("Alamat Email : ");
                            String email = inpString.nextLine();
                            Aplikasi.ubahSetPelamar(pelamar, nama, email);
                            System.out.print("Data berhasil diubah. Tekan Enter");
                        }
                        inpt = inpString.nextLine();
                        break;
                    case 4 : // Lihat Berkas
                        System.out.println("Berkas anda");
                        berkas berkas1 = Aplikasi.lihatBerkas(pelamar);
                        if(berkas1.getSkill() == null){
                            System.out.println("Anda belum selesai mengisi berkas");
                        }else{
                            System.out.println("Keahlian");
                            System.out.println("========");
                            for (int j = 0; j < berkas1.getSkill().size(); j++) {
                                System.out.println("\t "+berkas1.getSkill().get(j));
                            }
                        }
                        System.out.print("Tekan Enter...");
                        inpt = inpString.nextLine();
                        break;
                    default :
                        System.out.print("Perintah tidak tersedia. Tekan Enter...");
                        inpt = inpString.nextLine();
                        break;
                } 
            }catch(Exception e4){
                System.out.print("Kesalahan input. Tekan Enter...");
                String inpt = inpString.nextLine();
            }
        } while (keluar==false);
    }
    
    boolean DaftarAkun(boolean exit){
        System.out.println("Silahkan Pilih Jenis Pendaftaran.");
        System.out.println("1. Perusahaan");
        System.out.println("2. Pencari Kerja / Pelamar");
        System.out.println("0. Kembali");
        System.out.print("Masukkan pilihan : ");
        try{
            int pil = Integer.parseInt(inpString.nextLine());
            switch(pil){
                case 0 :
                    exit = true;
                    break;
                case 1 :
                    DaftarPerusahaan();
                    break;
                case 2 :
                    DaftarPelamar();
                    break;
                default :
                    System.out.println("Perintah tidak tersedia. Tekan Enter...");
                    String inpt = inpString.nextLine();
                    break;
            }
        }catch(Exception e5){
            System.out.println("Kesalah input. Tekan Enter...");
            String inpt = inpString.nextLine();
        }
        return exit;
    }
}