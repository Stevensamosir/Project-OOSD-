package administrasidesa;

//impor lib yang dibutuhkan 

import java.io.*; 
import java.util.*;
 
//deklarasi class utama 
public class Main{ 
  public static void menuAwal(){
      System.out.println("\n-- SELAMAT DATANG --");
      System.out.println("1. Login Sebagai Admin");
      System.out.println("2. Login Sebagai Member");
      System.out.println("3. Daftar");
      System.out.println("0. Berhenti");
      System.out.println(">>>Masukkan pilihan anda : ");
  }    
  public static void menuUtamaAdmin(){
      System.out.println("\n=== SELAMAT DATANG DI SISTEM INFORMASI ADMINISTRASI DESA ===");
      System.out.println("1. Data Surat");
      System.out.println("2. Data Penduduk");
      System.out.println("3. Berita");
      System.out.println("4. Saran/Komentar");
      System.out.println("5. Data Member");
      System.out.println("0. Keluar");
      System.out.println(">>>Masukkan pilihan anda : ");
  }  
  public static void menuUtamaMember(){
      System.out.println("\n=== SELAMAT DATANG DI SISTEM INFORMASI ADMINISTRASI DESA ===");
      System.out.println("1. Layanan Surat");
      System.out.println("2. Berita");
      System.out.println("3. Saran/Komentar");
      System.out.println("0. Keluar");
      System.out.println(">>>Masukkan pilihan anda : ");
  }  
  public static void layananSurat(){
      System.out.println("1. Surat Pengantar Pengurusan KK");
      System.out.println("2. Surat Pengantar Pengurusan KTP");
      System.out.println("3. Surat Keterangan Domisili");
      System.out.println("4. Surat Keterangan Tidak Mampu");
      System.out.println("5. Surat Keterangan Pindah");
      System.out.println("0. Kembali");
      System.out.println(">>>Masukkan pilihan anda : ");
  }
  public static void menuTambahan(){
      System.out.println("1. Tambah Data");
      System.out.println("2. Ubah Data");
      System.out.println("3. Hapus Data");
      System.out.println("4. Lihat Semua Data");
      System.out.println("0. Kembali");
      System.out.println(">>>Masukkan pilihan anda : ");
  }
  public static void menuSurat(){
      System.out.println("1. Request Surat");
      System.out.println("2. Riwayat Surat Anda");
      System.out.println("0. Kembali");
      System.out.println(">>>Masukkan pilihan anda : ");
  }
  public static void menuSuratAdmin(){
      System.out.println("1. Konfirmasi Surat Satu Persatu");
      System.out.println("2. Konfirmasi Semua Surat Sekaligus");
      System.out.println("3. Daftar Surat");
      System.out.println("0. Kembali");
      System.out.println(">>>Masukkan pilihan anda : ");
  }
  public static void konfirmasi(){
        System.out.println("\nPilih Jenis Konfirmasi: \n"
            + "1. Terima\n"
            + "2. Tolak\n" );
  }
  
  
 public static void main(String[] args){ 
    //create folder
    File folder = new File("Data SAD");
    folder.mkdir(); //create folder "Data SAD"
    
    //deklarasi untuk masukan user
    BufferedWriter save, saveUpd, saveDel; 
    BufferedReader scan = new BufferedReader(new InputStreamReader(System.in)); 
    Scanner input = new Scanner(System.in); //membuat variabel untuk menerima inputan user
    
    //variabel
    int menuAwal, menuUtama, menuTambahan, layananSurat, admin=0, member=0; 
    String usernameAdmin = "admin", passwordAdmin = "admin";
    String memberTemp, memberNow="";
    
    try{
        do{
            menuAwal();
            menuAwal = input.nextInt();

            if(menuAwal == 1){
                System.out.println(""); 
                System.out.print("Masukkan username: "); 
                String username = scan.readLine(); 
                System.out.print("Masukkan password: "); 
                String password = scan.readLine();  
                
                ArrayList<String> listAdminTxt = new ArrayList<>(); //List menampung dari txt file
                try{
                    File data = new File ("Data SAD/Admin.txt"); //Objek file yang akan dibuka
                    Scanner getData = new Scanner(data); //Untuk membaca data dari file 

                    listAdminTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                    while(getData.hasNextLine()) { //membaca seluruh isi file
                        listAdminTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                    }
                    
                    //mencetak data 
                    for (int i=0; i<listAdminTxt.size(); i++){
                        if(listAdminTxt.get(i).split(",")[0].split(": ")[1].equals(username) && listAdminTxt.get(i).split(",")[1].split(": ")[1].equals(password)){
                            admin = 1;
                            break;
                        }
                    }
                    listAdminTxt.clear(); 
                    
                    if(admin == 1){
                        System.out.println(">>>Berhasil masuk");
                        break;
                    } 
                    else{
                        System.out.println(">>>Gagal masuk"); 
                    }
                }
                catch(IOException e){
                } 
            }
            
            else if(menuAwal == 2){
                System.out.print("\nMasukkan username: "); 
                String username = input.next();
                System.out.print("Masukkan password: "); 
                String password = scan.readLine();  
              
                ArrayList<String> listMemberTxt = new ArrayList<>(); //List menampung dari txt file
                try{
                    File data = new File ("Data SAD/Member.txt"); //Objek file yang akan dibuka
                    Scanner getData = new Scanner(data); //Untuk membaca data dari file 

                    listMemberTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                    while(getData.hasNextLine()) { //membaca seluruh isi file
                        listMemberTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                    }
                    
                    //mencetak data 
                    for (int i=0; i<listMemberTxt.size(); i++){
                        if(listMemberTxt.get(i).split(",")[4].split(": ")[1].equals(username) && listMemberTxt.get(i).split(",")[5].split(": ")[1].equals(password)){
                            member = 1;
                            memberTemp = listMemberTxt.get(i).split(",")[4];
                            memberNow = memberTemp.split(": ")[1];
                            break;
                        }
                    }
                    listMemberTxt.clear(); 
                    
                    if(member == 1){
                        System.out.println(">>>Berhasil masuk");
                        break;
                    } 
                    else{
                        System.out.println(">>>Gagal masuk"); 
                    }
                }
                catch(IOException e){
                } 
            }
            
            else if(menuAwal == 3){
                System.out.println(""); 
                System.out.println("Masukkan data diri anda : ");
                System.out.print("Nama: "); 
                String nama = scan.readLine(); 
                System.out.print("Email: "); 
                String email = scan.readLine(); 
                System.out.print("Gender: "); 
                String gender = scan.readLine(); 
                System.out.print("Alamat: "); 
                String alamat = scan.readLine(); 
                System.out.print("Username: "); 
                String username = scan.readLine(); 
                System.out.print("Password: "); 
                String password = scan.readLine();
                
                ArrayList<String> listMemberTxt = new ArrayList<>(); //List menampung dari txt file
                try{
                    File data = new File ("Data SAD/Member.txt"); //Objek file yang akan dibuka
                    Scanner getData = new Scanner(data); //Untuk membaca data dari file 

                    listMemberTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                    while(getData.hasNextLine()) { //membaca seluruh isi file
                        listMemberTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                    }

                    //cek apakah inputan sama dengan yang terdaftar
                    int temp=0;
                    for (int i=0; i<listMemberTxt.size(); i++){
                        if(listMemberTxt.get(i).split(",")[4].split(": ")[1].equals(username) || listMemberTxt.get(i).split(",")[1].split(": ").equals(password)){
                            temp = 1;
                        }
                    }
                    listMemberTxt.clear(); 
                    
                    if(temp == 1){
                        System.out.println(">>>Maaf, Username/Email Sudah Pernah Terdaftar");
                        break;
                    }
                    
                    save = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan

                    Member dataMember = new Member(nama, email, gender, alamat, username, password);

                    save.write(dataMember.toString()); //save data ke txt dalam format toString
                    save.newLine(); 
                    save.close(); //close I/O
                    System.out.println(">>>Daftar Berhasil");
                }catch(IOException e){ 
                } 
            } 
        }
        while(menuAwal != 0);
        
    
    
    
        //Menu Lanjutan setelah berhasil login ke sistem
        if(admin == 1){      
            do{
                menuUtamaAdmin();
                menuUtama = input.nextInt();
                switch(menuUtama){
                    case 1:
                        do{
                            System.out.println("\nMenu Lanjutan Layanan Surat");
                            layananSurat();
                            layananSurat = input.nextInt();
                            int menuSuratAdmin=0;
                            
                            switch(layananSurat){
                                case 1: //surat kk
                                    ArrayList<String> listKKTxt = new ArrayList<>(); //List menampung dari txt file
                                    
                                    do{
                                        System.out.println("\nMenu Tambahan:");
                                        menuSuratAdmin();
                                        menuSuratAdmin = input.nextInt();
                                        
                                        switch(menuSuratAdmin){
                                            case 1: //konfirmasi satu per satu
                                                System.out.println("\nMasukkan Baris dari Data Untuk di Konfirmasi: ");
                                                int baris = input.nextInt();
                                                
                                                try{
                                                    File data = new File ("Data SAD/KK.txt"); //Objek file yang akan dibuka
                                                    Scanner getData = new Scanner(data); //Untuk membaca data dari file 

                                                    listKKTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                                                    while(getData.hasNextLine()) { //membaca seluruh isi file
                                                        listKKTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                                    }

                                                    //mencetak daftar surat yang pernah di request oleh user yang login
                                                    for (int i=0; i<listKKTxt.size(); i++){
                                                        if(i+1 == baris){
                                                            System.out.println(listKKTxt.get(i));
                                                            konfirmasi();
                                                            int konfirmasi = input.nextInt();
                                                            
                                                            String sebelum = listKKTxt.get(i).split(",")[3].split(": ")[1];
                                                            String sesudah = "";
                                                            if(sebelum.equals("Diterima") || sebelum.equals("Ditolak") ){
                                                                System.out.println(">>>Maaf, Surat Ini Sudah Pernah di Konfirmasi");
                                                            }
                                                            else{
                                                                if(konfirmasi == 1){
                                                                    sesudah = "Diterima";
                                                                }
                                                                else if(konfirmasi == 2){
                                                                    sesudah = "Ditolak";
                                                                }
                                                                
                                                                save = new BufferedWriter (new FileWriter(data, false)); //false, berarti data file lama ditindih
                                                                save.close(); //close I/O

                                                                for (int j=0; j<listKKTxt.size(); j++){
                                                                    if(j+1 == baris){
                                                                        saveUpd = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                                        saveUpd.write(listKKTxt.get(i).replace(sebelum, sesudah)); //save data ke txt dalam format toString
                                                                        saveUpd.newLine(); saveUpd.close(); //close I/O
                                                                    }else{
                                                                        saveUpd = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                                        saveUpd.write(listKKTxt.get(j)); //save data ke txt dalam format toString
                                                                        saveUpd.newLine(); saveUpd.close(); //close I/O
                                                                    }
                                                                } 
                                                                System.out.println(">>>Surat Berhasil di Konfirmasi");
                                                            }
                                                        }
                                                    }
                                                    listKKTxt.clear(); 
                                                }
                                                catch(IOException e){
                                                } 
                                                break;
                                                
                                            case 2: //konfirmasi semua sekaligus
                                                konfirmasi();
                                                int konfirmasi = input.nextInt();
                                                String sesudah = "";
                                                if(konfirmasi == 1){
                                                    sesudah = "Diterima";
                                                } else if(konfirmasi == 2){
                                                    sesudah = "Ditolak";
                                                } 
                                                
                                                try{
                                                    File data = new File ("Data SAD/KK.txt"); //Objek file yang akan dibuka
                                                    Scanner getData = new Scanner(data); //Untuk membaca data dari file 

                                                    listKKTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                                                    while(getData.hasNextLine()) { //membaca seluruh isi file
                                                        listKKTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                                    }

                                                    //melakukan konfirmasi sekaligus
                                                    save = new BufferedWriter (new FileWriter(data, false)); //false, berarti data file lama ditindih
                                                    save.close(); //close I/O
                                                        
                                                    for (int i=0; i<listKKTxt.size(); i++){
                                                        String sebelum = listKKTxt.get(i).split(",")[3].split(": ")[1];
                                                        if(sebelum.equals("Diminta")){
                                                            listKKTxt.get(i).replace(sebelum, sesudah);
                                                            
                                                            saveUpd = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                            saveUpd.write(listKKTxt.get(i).replace(sebelum, sesudah)); //save data ke txt dalam format toString
                                                            saveUpd.newLine(); saveUpd.close(); //close I/O
                                                        }
                                                        else{
                                                            saveUpd = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                            saveUpd.write(listKKTxt.get(i)); //save data ke txt dalam format toString
                                                            saveUpd.newLine(); saveUpd.close(); //close I/O
                                                        }
                                                    }
                                                    System.out.println(">>>Surat Selesai di Konfirmasi");
                                                    listKKTxt.clear(); 
                                                }
                                                catch(IOException e){
                                                } 
                                                break;
                                                
                                            case 3: //lihat daftar surat
                                                try{
                                                    File data = new File ("Data SAD/KK.txt"); //Objek file yang akan dibuka
                                                    Scanner getData = new Scanner(data); //Untuk membaca data dari file 

                                                    listKKTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                                                    while(getData.hasNextLine()) { //membaca seluruh isi file
                                                        listKKTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                                    }

                                                    //mencetak daftar surat yang pernah di request oleh user yang login
                                                    System.out.println("\nDaftar Surat KK");
                                                    for (int i=0; i<listKKTxt.size(); i++){
                                                        System.out.println(listKKTxt.get(i));
                                                    }
                                                    listKKTxt.clear(); 
                                                }
                                                catch(IOException e){
                                                } 
                                                break;
                                        }
                                    }while(menuSuratAdmin != 0);
                                    break;
                                    
                                case 2: //surat ktp
                                    ArrayList<String> listKtpTxt = new ArrayList<>(); //List menampung dari txt file
                               
                                    do{
                                        System.out.println("\nMenu Tambahan:");
                                        menuSuratAdmin();
                                        menuSuratAdmin = input.nextInt();
                                        
                                        switch(menuSuratAdmin){
                                            case 1: //konfirmasi satu per satu
                                                System.out.println("\nMasukkan Baris dari Data Untuk di Konfirmasi: ");
                                                int baris = input.nextInt();
                                                
                                                try{
                                                    File data = new File ("Data SAD/KTP.txt"); //Objek file yang akan dibuka
                                                    Scanner getData = new Scanner(data); //Untuk membaca data dari file 

                                                    listKtpTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                                                    while(getData.hasNextLine()) { //membaca seluruh isi file
                                                        listKtpTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                                    }

                                                    //mencetak daftar surat yang pernah di request oleh user yang login
                                                    for (int i=0; i<listKtpTxt.size(); i++){
                                                        if(i+1 == baris){
                                                            System.out.println(listKtpTxt.get(i));
                                                            konfirmasi();
                                                            int konfirmasi = input.nextInt();
                                                            
                                                            String sebelum = listKtpTxt.get(i).split(",")[1].split(": ")[1];
                                                            String sesudah = "";
                                                            if(sebelum.equals("Diterima") || sebelum.equals("Ditolak") ){
                                                                System.out.println(">>>Maaf, Surat Ini Sudah Pernah di Konfirmasi");
                                                            }
                                                            else{
                                                                if(konfirmasi == 1){
                                                                    sesudah = "Diterima";
                                                                }
                                                                else if(konfirmasi == 2){
                                                                    sesudah = "Ditolak";
                                                                }
                                                                
                                                                save = new BufferedWriter (new FileWriter(data, false)); //false, berarti data file lama ditindih
                                                                save.close(); //close I/O

                                                                for (int j=0; j<listKtpTxt.size(); j++){
                                                                    if(j+1 == baris){
                                                                        saveUpd = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                                        saveUpd.write(listKtpTxt.get(i).replace(sebelum, sesudah)); //save data ke txt dalam format toString
                                                                        saveUpd.newLine(); saveUpd.close(); //close I/O
                                                                    }else{
                                                                        saveUpd = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                                        saveUpd.write(listKtpTxt.get(j)); //save data ke txt dalam format toString
                                                                        saveUpd.newLine(); saveUpd.close(); //close I/O
                                                                    }
                                                                } 
                                                                System.out.println(">>>Surat Berhasil di Konfirmasi");
                                                            }
                                                        }
                                                    }
                                                    listKtpTxt.clear(); 
                                                }
                                                catch(IOException e){
                                                } 
                                                break;
                                                
                                            case 2: //konfirmasi semua sekaligus
                                                konfirmasi();
                                                int konfirmasi = input.nextInt();
                                                String sesudah = "";
                                                if(konfirmasi == 1){
                                                    sesudah = "Diterima";
                                                } else if(konfirmasi == 2){
                                                    sesudah = "Ditolak";
                                                } 
                                                
                                                try{
                                                    File data = new File ("Data SAD/KTP.txt"); //Objek file yang akan dibuka
                                                    Scanner getData = new Scanner(data); //Untuk membaca data dari file 

                                                    listKtpTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                                                    while(getData.hasNextLine()) { //membaca seluruh isi file
                                                        listKtpTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                                    }

                                                    //melakukan konfirmasi sekaligus
                                                    save = new BufferedWriter (new FileWriter(data, false)); //false, berarti data file lama ditindih
                                                    save.close(); //close I/O
                                                        
                                                    for (int i=0; i<listKtpTxt.size(); i++){
                                                        String sebelum = listKtpTxt.get(i).split(",")[1].split(": ")[1];
                                                        if(sebelum.equals("Diminta")){
                                                            listKtpTxt.get(i).replace(sebelum, sesudah);
                                                            
                                                            saveUpd = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                            saveUpd.write(listKtpTxt.get(i).replace(sebelum, sesudah)); //save data ke txt dalam format toString
                                                            saveUpd.newLine(); saveUpd.close(); //close I/O
                                                        }
                                                        else{
                                                            saveUpd = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                            saveUpd.write(listKtpTxt.get(i)); //save data ke txt dalam format toString
                                                            saveUpd.newLine(); saveUpd.close(); //close I/O
                                                        }
                                                    }
                                                    System.out.println(">>>Surat Selesai di Konfirmasi");
                                                    listKtpTxt.clear(); 
                                                }
                                                catch(IOException e){
                                                } 
                                                break;
                                                
                                            case 3: //lihat daftar surat
                                                try{
                                                    File data = new File ("Data SAD/KTP.txt"); //Objek file yang akan dibuka
                                                    Scanner getData = new Scanner(data); //Untuk membaca data dari file 

                                                    listKtpTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                                                    while(getData.hasNextLine()) { //membaca seluruh isi file
                                                        listKtpTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                                    }

                                                    //mencetak daftar surat yang pernah di request oleh user yang login
                                                    System.out.println("\nDaftar Surat KTP");
                                                    for (int i=0; i<listKtpTxt.size(); i++){
                                                        System.out.println(listKtpTxt.get(i));
                                                    }
                                                    listKtpTxt.clear(); 
                                                }
                                                catch(IOException e){
                                                } 
                                                break;
                                        }
                                    }while(menuSuratAdmin != 0);
                                    break;
                                        
                                case 3: //surat domisili
                                    ArrayList<String> listDomisiliTxt = new ArrayList<>(); //List menampung dari txt file
                               
                                    do{
                                        System.out.println("\nMenu Tambahan:");
                                        menuSuratAdmin();
                                        menuSuratAdmin = input.nextInt();
                                        
                                        switch(menuSuratAdmin){
                                            case 1: //konfirmasi satu per satu
                                                System.out.println("\nMasukkan Baris dari Data Untuk di Konfirmasi: ");
                                                int baris = input.nextInt();
                                                
                                                try{
                                                    File data = new File ("Data SAD/Domisili.txt"); //Objek file yang akan dibuka
                                                    Scanner getData = new Scanner(data); //Untuk membaca data dari file 

                                                    listDomisiliTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                                                    while(getData.hasNextLine()) { //membaca seluruh isi file
                                                        listDomisiliTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                                    }

                                                    //mencetak daftar surat yang pernah di request oleh user yang login
                                                    for (int i=0; i<listDomisiliTxt.size(); i++){
                                                        if(i+1 == baris){
                                                            System.out.println(listDomisiliTxt.get(i));
                                                            konfirmasi();
                                                            int konfirmasi = input.nextInt();
                                                            
                                                            String sebelum = listDomisiliTxt.get(i).split(",")[2].split(": ")[1];
                                                            String sesudah = "";
                                                            if(sebelum.equals("Diterima") || sebelum.equals("Ditolak") ){
                                                                System.out.println(">>>Maaf, Surat Ini Sudah Pernah di Konfirmasi");
                                                            }
                                                            else{
                                                                if(konfirmasi == 1){
                                                                    sesudah = "Diterima";
                                                                }
                                                                else if(konfirmasi == 2){
                                                                    sesudah = "Ditolak";
                                                                }
                                                                
                                                                save = new BufferedWriter (new FileWriter(data, false)); //false, berarti data file lama ditindih
                                                                save.close(); //close I/O

                                                                for (int j=0; j<listDomisiliTxt.size(); j++){
                                                                    if(j+1 == baris){
                                                                        saveUpd = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                                        saveUpd.write(listDomisiliTxt.get(i).replace(sebelum, sesudah)); //save data ke txt dalam format toString
                                                                        saveUpd.newLine(); saveUpd.close(); //close I/O
                                                                    }else{
                                                                        saveUpd = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                                        saveUpd.write(listDomisiliTxt.get(j)); //save data ke txt dalam format toString
                                                                        saveUpd.newLine(); saveUpd.close(); //close I/O
                                                                    }
                                                                } 
                                                                System.out.println(">>>Surat Berhasil di Konfirmasi");
                                                            }
                                                        }
                                                    }
                                                    listDomisiliTxt.clear(); 
                                                }
                                                catch(IOException e){
                                                } 
                                                break;
                                                
                                            case 2: //konfirmasi semua sekaligus
                                                konfirmasi();
                                                int konfirmasi = input.nextInt();
                                                String sesudah = "";
                                                if(konfirmasi == 1){
                                                    sesudah = "Diterima";
                                                } else if(konfirmasi == 2){
                                                    sesudah = "Ditolak";
                                                } 
                                                
                                                try{
                                                    File data = new File ("Data SAD/Domisili.txt"); //Objek file yang akan dibuka
                                                    Scanner getData = new Scanner(data); //Untuk membaca data dari file 

                                                    listDomisiliTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                                                    while(getData.hasNextLine()) { //membaca seluruh isi file
                                                        listDomisiliTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                                    }

                                                    //melakukan konfirmasi sekaligus
                                                    save = new BufferedWriter (new FileWriter(data, false)); //false, berarti data file lama ditindih
                                                    save.close(); //close I/O
                                                        
                                                    for (int i=0; i<listDomisiliTxt.size(); i++){
                                                        String sebelum = listDomisiliTxt.get(i).split(",")[2].split(": ")[1];
                                                        if(sebelum.equals("Diminta")){
                                                            listDomisiliTxt.get(i).replace(sebelum, sesudah);
                                                            
                                                            saveUpd = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                            saveUpd.write(listDomisiliTxt.get(i).replace(sebelum, sesudah)); //save data ke txt dalam format toString
                                                            saveUpd.newLine(); saveUpd.close(); //close I/O
                                                        }
                                                        else{
                                                            saveUpd = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                            saveUpd.write(listDomisiliTxt.get(i)); //save data ke txt dalam format toString
                                                            saveUpd.newLine(); saveUpd.close(); //close I/O
                                                        }
                                                    }
                                                    System.out.println(">>>Surat Selesai di Konfirmasi");
                                                    listDomisiliTxt.clear(); 
                                                }
                                                catch(IOException e){
                                                } 
                                                break;
                                                
                                            case 3: //lihat daftar surat
                                                try{
                                                    File data = new File ("Data SAD/Domisili.txt"); //Objek file yang akan dibuka
                                                    Scanner getData = new Scanner(data); //Untuk membaca data dari file 

                                                    listDomisiliTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                                                    while(getData.hasNextLine()) { //membaca seluruh isi file
                                                        listDomisiliTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                                    }

                                                    //mencetak daftar surat yang pernah di request oleh user yang login
                                                    System.out.println("\nDaftar Surat Domisili");
                                                    for (int i=0; i<listDomisiliTxt.size(); i++){
                                                        System.out.println(listDomisiliTxt.get(i));
                                                    }
                                                    listDomisiliTxt.clear(); 
                                                }
                                                catch(IOException e){
                                                } 
                                                break;
                                        }
                                    }while(menuSuratAdmin != 0);
                                    break;
                                    
                                case 4: //surat tidak mampu
                                    ArrayList<String> listTidakMampuTxt = new ArrayList<>(); //List menampung dari txt file
                               
                                    do{
                                        System.out.println("\nMenu Tambahan:");
                                        menuSuratAdmin();
                                        menuSuratAdmin = input.nextInt();
                                        
                                        switch(menuSuratAdmin){
                                            case 1: //konfirmasi satu per satu
                                                System.out.println("\nMasukkan Baris dari Data Untuk di Konfirmasi: ");
                                                int baris = input.nextInt();
                                                
                                                try{
                                                    File data = new File ("Data SAD/TidakMampu.txt"); //Objek file yang akan dibuka
                                                    Scanner getData = new Scanner(data); //Untuk membaca data dari file 

                                                    listTidakMampuTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                                                    while(getData.hasNextLine()) { //membaca seluruh isi file
                                                        listTidakMampuTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                                    }

                                                    //mencetak daftar surat yang pernah di request oleh user yang login
                                                    for (int i=0; i<listTidakMampuTxt.size(); i++){
                                                        if(i+1 == baris){
                                                            System.out.println(listTidakMampuTxt.get(i));
                                                            konfirmasi();
                                                            int konfirmasi = input.nextInt();
                                                            
                                                            String sebelum = listTidakMampuTxt.get(i).split(",")[2].split(": ")[1];
                                                            String sesudah = "";
                                                            if(sebelum.equals("Diterima") || sebelum.equals("Ditolak") ){
                                                                System.out.println(">>>Maaf, Surat Ini Sudah Pernah di Konfirmasi");
                                                            }
                                                            else{
                                                                if(konfirmasi == 1){
                                                                    sesudah = "Diterima";
                                                                }
                                                                else if(konfirmasi == 2){
                                                                    sesudah = "Ditolak";
                                                                }
                                                                
                                                                save = new BufferedWriter (new FileWriter(data, false)); //false, berarti data file lama ditindih
                                                                save.close(); //close I/O

                                                                for (int j=0; j<listTidakMampuTxt.size(); j++){
                                                                    if(j+1 == baris){
                                                                        saveUpd = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                                        saveUpd.write(listTidakMampuTxt.get(i).replace(sebelum, sesudah)); //save data ke txt dalam format toString
                                                                        saveUpd.newLine(); saveUpd.close(); //close I/O
                                                                    }else{
                                                                        saveUpd = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                                        saveUpd.write(listTidakMampuTxt.get(j)); //save data ke txt dalam format toString
                                                                        saveUpd.newLine(); saveUpd.close(); //close I/O
                                                                    }
                                                                } 
                                                                System.out.println(">>>Surat Berhasil di Konfirmasi");
                                                            }
                                                        }
                                                    }
                                                    listTidakMampuTxt.clear(); 
                                                }
                                                catch(IOException e){
                                                } 
                                                break;
                                                
                                            case 2: //konfirmasi semua sekaligus
                                                konfirmasi();
                                                int konfirmasi = input.nextInt();
                                                String sesudah = "";
                                                if(konfirmasi == 1){
                                                    sesudah = "Diterima";
                                                } else if(konfirmasi == 2){
                                                    sesudah = "Ditolak";
                                                } 
                                                
                                                try{
                                                    File data = new File ("Data SAD/TidakMampu.txt"); //Objek file yang akan dibuka
                                                    Scanner getData = new Scanner(data); //Untuk membaca data dari file 

                                                    listTidakMampuTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                                                    while(getData.hasNextLine()) { //membaca seluruh isi file
                                                        listTidakMampuTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                                    }

                                                    //melakukan konfirmasi sekaligus
                                                    save = new BufferedWriter (new FileWriter(data, false)); //false, berarti data file lama ditindih
                                                    save.close(); //close I/O
                                                        
                                                    for (int i=0; i<listTidakMampuTxt.size(); i++){
                                                        String sebelum = listTidakMampuTxt.get(i).split(",")[2].split(": ")[1];
                                                        if(sebelum.equals("Diminta")){
                                                            listTidakMampuTxt.get(i).replace(sebelum, sesudah);
                                                            
                                                            saveUpd = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                            saveUpd.write(listTidakMampuTxt.get(i).replace(sebelum, sesudah)); //save data ke txt dalam format toString
                                                            saveUpd.newLine(); saveUpd.close(); //close I/O
                                                        }
                                                        else{
                                                            saveUpd = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                            saveUpd.write(listTidakMampuTxt.get(i)); //save data ke txt dalam format toString
                                                            saveUpd.newLine(); saveUpd.close(); //close I/O
                                                        }
                                                    }
                                                    System.out.println(">>>Surat Selesai di Konfirmasi");
                                                    listTidakMampuTxt.clear(); 
                                                }
                                                catch(IOException e){
                                                } 
                                                break;
                                                
                                            case 3: //lihat daftar surat
                                                try{
                                                    File data = new File ("Data SAD/TidakMampu.txt"); //Objek file yang akan dibuka
                                                    Scanner getData = new Scanner(data); //Untuk membaca data dari file 

                                                    listTidakMampuTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                                                    while(getData.hasNextLine()) { //membaca seluruh isi file
                                                        listTidakMampuTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                                    }

                                                    //mencetak daftar surat yang pernah di request oleh user yang login
                                                    System.out.println("\nDaftar Surat Tidak Mampu");
                                                    for (int i=0; i<listTidakMampuTxt.size(); i++){
                                                        System.out.println(listTidakMampuTxt.get(i));
                                                    }
                                                    listTidakMampuTxt.clear(); 
                                                }
                                                catch(IOException e){
                                                } 
                                                break;
                                        }
                                    }while(menuSuratAdmin != 0);
                                    break;
                                    
                                case 5: //surat migrasi
                                    ArrayList<String> listMigrasiTxt = new ArrayList<>(); //List menampung dari txt file
                               
                                    do{
                                        System.out.println("\nMenu Tambahan:");
                                        menuSuratAdmin();
                                        menuSuratAdmin = input.nextInt();
                                        
                                        switch(menuSuratAdmin){
                                            case 1: //konfirmasi satu per satu
                                                System.out.println("\nMasukkan Baris dari Data Untuk di Konfirmasi: ");
                                                int baris = input.nextInt();
                                                
                                                try{
                                                    File data = new File ("Data SAD/Migrasi.txt"); //Objek file yang akan dibuka
                                                    Scanner getData = new Scanner(data); //Untuk membaca data dari file 

                                                    listMigrasiTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                                                    while(getData.hasNextLine()) { //membaca seluruh isi file
                                                        listMigrasiTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                                    }

                                                    //mencetak daftar surat yang pernah di request oleh user yang login
                                                    for (int i=0; i<listMigrasiTxt.size(); i++){
                                                        if(i+1 == baris){
                                                            System.out.println(listMigrasiTxt.get(i));
                                                            konfirmasi();
                                                            int konfirmasi = input.nextInt();
                                                            
                                                            String sebelum = listMigrasiTxt.get(i).split(",")[4].split(": ")[1];
                                                            String sesudah = "";
                                                            if(sebelum.equals("Diterima") || sebelum.equals("Ditolak") ){
                                                                System.out.println(">>>Maaf, Surat Ini Sudah Pernah di Konfirmasi");
                                                            }
                                                            else{
                                                                if(konfirmasi == 1){
                                                                    sesudah = "Diterima";
                                                                }
                                                                else if(konfirmasi == 2){
                                                                    sesudah = "Ditolak";
                                                                }
                                                                
                                                                save = new BufferedWriter (new FileWriter(data, false)); //false, berarti data file lama ditindih
                                                                save.close(); //close I/O

                                                                for (int j=0; j<listMigrasiTxt.size(); j++){
                                                                    if(j+1 == baris){
                                                                        saveUpd = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                                        saveUpd.write(listMigrasiTxt.get(i).replace(sebelum, sesudah)); //save data ke txt dalam format toString
                                                                        saveUpd.newLine(); saveUpd.close(); //close I/O
                                                                    }else{
                                                                        saveUpd = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                                        saveUpd.write(listMigrasiTxt.get(j)); //save data ke txt dalam format toString
                                                                        saveUpd.newLine(); saveUpd.close(); //close I/O
                                                                    }
                                                                } 
                                                                System.out.println(">>>Surat Berhasil di Konfirmasi");
                                                            }
                                                        }
                                                    }
                                                    listMigrasiTxt.clear(); 
                                                }
                                                catch(IOException e){
                                                } 
                                                break;
                                                
                                            case 2: //konfirmasi semua sekaligus
                                                konfirmasi();
                                                int konfirmasi = input.nextInt();
                                                String sesudah = "";
                                                if(konfirmasi == 1){
                                                    sesudah = "Diterima";
                                                } else if(konfirmasi == 2){
                                                    sesudah = "Ditolak";
                                                } 
                                                
                                                try{
                                                    File data = new File ("Data SAD/Migrasi.txt"); //Objek file yang akan dibuka
                                                    Scanner getData = new Scanner(data); //Untuk membaca data dari file 

                                                    listMigrasiTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                                                    while(getData.hasNextLine()) { //membaca seluruh isi file
                                                        listMigrasiTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                                    }

                                                    //melakukan konfirmasi sekaligus
                                                    save = new BufferedWriter (new FileWriter(data, false)); //false, berarti data file lama ditindih
                                                    save.close(); //close I/O
                                                        
                                                    for (int i=0; i<listMigrasiTxt.size(); i++){
                                                        String sebelum = listMigrasiTxt.get(i).split(",")[4].split(": ")[1];
                                                        if(sebelum.equals("Diminta")){
                                                            listMigrasiTxt.get(i).replace(sebelum, sesudah);
                                                            
                                                            saveUpd = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                            saveUpd.write(listMigrasiTxt.get(i).replace(sebelum, sesudah)); //save data ke txt dalam format toString
                                                            saveUpd.newLine(); saveUpd.close(); //close I/O
                                                        }
                                                        else{
                                                            saveUpd = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                            saveUpd.write(listMigrasiTxt.get(i)); //save data ke txt dalam format toString
                                                            saveUpd.newLine(); saveUpd.close(); //close I/O
                                                        }
                                                    }
                                                    System.out.println(">>>Surat Selesai di Konfirmasi");
                                                    listMigrasiTxt.clear(); 
                                                }
                                                catch(IOException e){
                                                } 
                                                break;
                                                
                                            case 3: //lihat daftar surat
                                                try{
                                                    File data = new File ("Data SAD/Migrasi.txt"); //Objek file yang akan dibuka
                                                    Scanner getData = new Scanner(data); //Untuk membaca data dari file 

                                                    listMigrasiTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                                                    while(getData.hasNextLine()) { //membaca seluruh isi file
                                                        listMigrasiTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                                    }

                                                    //mencetak daftar surat yang pernah di request oleh user yang login
                                                    System.out.println("\nDaftar Surat Migrasi");
                                                    for (int i=0; i<listMigrasiTxt.size(); i++){
                                                        System.out.println(listMigrasiTxt.get(i));
                                                    }
                                                    listMigrasiTxt.clear(); 
                                                }
                                                catch(IOException e){
                                                } 
                                                break;
                                        }
                                    }while(menuSuratAdmin != 0);
                                    break;
                                    
                            }
                        }while(layananSurat != 0);
                        break;
                        
                    case 2: //Menu untuk mengelola data penduduk
                        ArrayList<Penduduk> listPenduduk = new ArrayList<>(); //List menampung sebelum dimasukkan ke txt file
                        ArrayList<String> listPendudukTxt = new ArrayList<>(); //List menampung dari txt file
                        do{
                            System.out.println("\nMenu Penduduk Lanjutan");
                            menuTambahan();
                            menuTambahan = input.nextInt();
                            
                            switch(menuTambahan){
                                case 1: //create new data
                                    try{
                                        System.out.println("\nMasukkan Data Penduduk: ");
                                        System.out.print("NIK: "); 
                                            String nik = scan.readLine(); 
                                        System.out.print("No. KK: "); 
                                            String no_kk = scan.readLine(); 
                                        System.out.print("Nama: "); 
                                            String nama = scan.readLine(); 
                                        System.out.print("Gender: "); 
                                            String gender = scan.readLine(); 
                                        System.out.print("Tempat Lahir: "); 
                                            String tempat_lahir = scan.readLine(); 
                                        System.out.print("Tanggal Lahir: "); 
                                            String tanggal_lahir = scan.readLine(); 
                                        System.out.print("Golongan Darah: "); 
                                            String gol_darah = scan.readLine(); 
                                        System.out.print("Agama: "); 
                                            String agama = scan.readLine(); 
                                        System.out.print("Pekerjaan: "); 
                                            String pekerjaan = scan.readLine(); 
                                        System.out.print("Nama Ayah: "); 
                                            String nama_ayah = scan.readLine();     
                                        System.out.print("Nama Ibu: "); 
                                            String nama_ibu = scan.readLine();     
                                    
                                        listPenduduk.clear(); //hapus list utk menghindari data bertindih
                                        listPenduduk.add(new Penduduk(nik, no_kk, nama, gender, tempat_lahir, tanggal_lahir, gol_darah, agama, pekerjaan, nama_ayah, nama_ibu));
                                        for (Penduduk list : listPenduduk) {
                                            try{
                                                File data = new File ("Data SAD/Penduduk.txt"); //Objek file yang akan dibuka
                                                save = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                save.write(list.toString()); //save data ke txt dalam format toString
                                                save.newLine();
                                                save.close(); //close I/O
                                                System.out.println(">>>Tambah Data Berhasil");
                                            }
                                            catch(IOException e){
                                            }
                                        }
                                    }
                                    catch(IOException e){
                                    }
                                    listPenduduk.clear();
                                    break;
                                    
                                case 2: //update data 
                                    System.out.println(">>>Masukkan Baris Data Yang Akan Diubah: ");
                                    int idUpd = input.nextInt(), opsi=0;
                                    
                                    try{
                                        File data = new File ("Data SAD/Penduduk.txt"); //Objek file yang akan dibuka
                                        Scanner getData = new Scanner(data); //Untuk membaca data dari file 
                                        
                                        listPendudukTxt.clear();//hapus data, agar data tidak bertindih
                                        while(getData.hasNextLine()) { //membaca seluruh isi file
                                            listPendudukTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                        }

                                        int size = listPendudukTxt.size(); //mendapatkan ukuran data yang sudah ada
                                        //mengetahui data yang akan diupdate dan meminta update data
                                        for (int i=0; i<size; i++){
                                            if(i+1 == idUpd){
                                                System.out.println(listPendudukTxt.get(i));
                                                System.out.println(">>Yakin Mengubah Data? [1. Lanjut, 0. Batal]");
                                                
                                                opsi = input.nextInt();
                                                if(opsi == 1){ //setuju utk update data
                                                    System.out.println(""); 
                                                    System.out.println("Masukkan Data Baru Penduduk: ");
                                                    System.out.print("NIK: "); 
                                                        String nikUpd = scan.readLine(); 
                                                    System.out.print("No. KK: "); 
                                                        String no_kkUpd = scan.readLine(); 
                                                    System.out.print("Nama: "); 
                                                        String namaUpd = scan.readLine(); 
                                                    System.out.print("Gender: "); 
                                                        String genderUpd = scan.readLine(); 
                                                    System.out.print("Tempat Lahir: "); 
                                                        String tempat_lahirUpd = scan.readLine(); 
                                                    System.out.print("Tanggal Lahir: "); 
                                                        String tanggal_lahirUpd = scan.readLine(); 
                                                    System.out.print("Golongan Darah: "); 
                                                        String gol_darahUpd = scan.readLine(); 
                                                    System.out.print("Agama: "); 
                                                        String agamaUpd = scan.readLine(); 
                                                    System.out.print("Pekerjaan: "); 
                                                        String pekerjaanUpd = scan.readLine(); 
                                                    System.out.print("Nama Ayah: "); 
                                                        String nama_ayahUpd = scan.readLine();     
                                                    System.out.print("Nama Ibu: "); 
                                                        String nama_ibuUpd = scan.readLine();
                                                    
                                                    listPenduduk.clear();
                                                    listPenduduk.add( new Penduduk(nikUpd, no_kkUpd, namaUpd, genderUpd, tempat_lahirUpd, tanggal_lahirUpd, gol_darahUpd, agamaUpd, pekerjaanUpd, nama_ayahUpd, nama_ibuUpd));
                                                    
                                                    save = new BufferedWriter (new FileWriter(data, false)); //false, berarti data file lama ditindih
                                                    save.close(); //close I/O
                                                    
                                                    for (int j=0; j<size; j++){
                                                        if(j+1 == idUpd){
                                                            for (Penduduk list : listPenduduk){
                                                                saveUpd = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                                saveUpd.write(list.toString()); //save data ke txt dalam format toString
                                                                saveUpd.newLine(); saveUpd.close(); //close I/O
                                                            }
                                                        }else{
                                                            saveUpd = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                            saveUpd.write(listPendudukTxt.get(j)); //save data ke txt dalam format toString
                                                            saveUpd.newLine(); saveUpd.close(); //close I/O
                                                        }
                                                    } 
                                                    System.out.println(">>>Berhasil Ubah Data");
                                                    break;
                                                }else if(opsi == 0){ //batal untuk update data
                                                    break;
                                                }
                                                else{ //data tidak tersedia
                                                    System.out.println(">>>Inputan Tidak Tersedia");
                                                } 
                                            }
                                        }
                                        listPendudukTxt.clear();
                                    }
                                    catch(IOException e){
                                    }
                                    break;
                                    
                                case 3: //delete data
                                    System.out.println(">>>Masukkan Baris Data Yang Akan Dihapus: ");
                                    int idDelete = input.nextInt();
                                    
                                    try{
                                        File data = new File ("Data SAD/Penduduk.txt"); //Objek file yang akan dibuka
                                        Scanner getData = new Scanner(data); //Untuk membaca data dari file 
                                        
                                        listPendudukTxt.clear(); //hapus list agar data tidak bertimpa
                                        while(getData.hasNextLine()) { //membaca seluruh isi file
                                            listPendudukTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                        }

                                        int size = listPendudukTxt.size(); //mendapatkan ukuran data yang sudah ada
                                        //mengetahui data yang akan dihapus 
                                        for (int i=0; i<size; i++){
                                            if(i+1 == idDelete){
                                                System.out.println(listPendudukTxt.get(i));
                                                System.out.println(">>>Yakin Menghapus Data? [1. Lanjut, 0. Batal]");
                                                
                                                int opsiDel = input.nextInt();
                                                if(opsiDel == 1){ //setuju untuk hapus data
                                                    save = new BufferedWriter (new FileWriter(data, false)); //false, berarti data file lama ditimpa
                                                    save.close(); //close I/O
                                                    
                                                    for (int j=0; j<size; j++){
                                                        if(j+1 == idDelete){

                                                        }else{
                                                            saveDel = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                            saveDel.write(listPendudukTxt.get(j)); //save data ke txt dalam format toString
                                                            saveDel.newLine(); saveDel.close(); //close I/O
                                                        }
                                                    } 
                                                    System.out.println(">>>Berhasil Hapus Data");
                                                    break;
                                                }else if(opsiDel == 0){ //batal untuk hapus data
                                                    break;
                                                }
                                                else{ //data tidak tersedia
                                                    System.out.println(">>>Inputan Tidak Tersedia");
                                                    break;
                                                }
                                            }
                                        } 
                                        listPendudukTxt.clear();
                                    }
                                    catch(IOException e){
                                    }break;

                                case 4: //view data
                                    try{
                                        File data = new File ("Data SAD/Penduduk.txt"); //Objek file yang akan dibuka
                                        Scanner getData = new Scanner(data); //Untuk membaca data dari file 
                                        
                                        listPendudukTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                                        while(getData.hasNextLine()) { //membaca seluruh isi file
                                            listPendudukTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                        }

                                        //mencetak data
                                        System.out.println("\nData Penduduk:");
                                        for (int i=0; i<listPendudukTxt.size(); i++){
                                            System.out.println(listPendudukTxt.get(i));
                                        }
                                        listPendudukTxt.clear(); 
                                    }
                                    catch(IOException e){
                                    }
                                    break;
                            }
                        }
                        while(menuTambahan != 0);
                        break;
                        
                        
                        
                    case 3://Menu untuk mengelola data berita
                        ArrayList<Berita> listBerita = new ArrayList<>(); //List menampung sebelum dimasukkan ke txt file
                        ArrayList<String> listBeritaTxt = new ArrayList<>(); //List menampung dari txt file
                        do{
                            System.out.println("\nMenu Berita Lanjutan");
                            menuTambahan();
                            menuTambahan = input.nextInt();
                            
                            switch(menuTambahan){
                                case 1: //create new data
                                    System.out.println("\nMasukkan Data Berita: ");
                                    System.out.print("Topik Berita: "); 
                                        String topik = scan.readLine(); 
                                    System.out.print("Deskripsi Berita: "); 
                                        String deskripsi = scan.readLine(); 
                                    System.out.print("Tanggal Kirim: "); 
                                        String tanggal_kirim = scan.readLine(); 
                                    
                                    listBerita.clear(); //hapus list utk menghindari data bertindih
                                    listBerita.add(new Berita(topik, deskripsi, tanggal_kirim));
                                    for (Berita list : listBerita) {
                                        try{
                                            File data = new File ("Data SAD/Berita.txt"); //Objek file yang akan dibuka
                                            save = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                            save.write(list.toString()); //save data ke txt dalam format toString
                                            save.newLine();              save.close(); //close I/O
                                            System.out.println(">>>Tambah Data Berhasil");
                                        }
                                        catch(IOException e){
                                        }
                                    }
                                    listBerita.clear();
                                    break;
                                    
                                case 2: //update data 
                                    System.out.println(">>>Masukkan Baris Data Yang Akan Diubah: ");
                                    int idUpd = input.nextInt(), opsi=0;
                                    
                                    try{
                                        File data = new File ("Data SAD/Berita.txt"); //Objek file yang akan dibuka
                                        Scanner getData = new Scanner(data); //Untuk membaca data dari file 
                                        
                                        listBeritaTxt.clear();//hapus data, agar data tidak bertindih
                                        while(getData.hasNextLine()) { //membaca seluruh isi file
                                            listBeritaTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                        }

                                        int size = listBeritaTxt.size(); //mendapatkan ukuran data yang sudah ada
                                        //mengetahui data yang akan diupdate dan meminta update data
                                        for (int i=0; i<size; i++){
                                            if(i+1 == idUpd){
                                                System.out.println(listBeritaTxt.get(i));
                                                System.out.println(">>Yakin Mengubah Data? [1. Lanjut, 0. Batal]");
                                                
                                                opsi = input.nextInt();
                                                if(opsi == 1){ //setuju utk update data
                                                    System.out.println(""); 
                                                    System.out.println("Masukkan Data Baru Berita: ");
                                                    System.out.print("Topik Berita: "); 
                                                        String topikUpd = scan.readLine(); 
                                                    System.out.print("Deskripsi Berita: "); 
                                                        String deskripsiUpd = scan.readLine(); 
                                                    System.out.print("Tanggal Kirim: "); 
                                                        String tanggal_kirimUpd = scan.readLine(); 
                                                    
                                                    listBerita.clear();
                                                    listBerita.add( new Berita(topikUpd, deskripsiUpd, tanggal_kirimUpd));
                                                    
                                                    save = new BufferedWriter (new FileWriter(data, false)); //false, berarti data file lama ditindih
                                                    save.close(); //close I/O
                                                    
                                                    for (int j=0; j<size; j++){
                                                        if(j+1 == idUpd){
                                                            for (Berita list : listBerita){
                                                                saveUpd = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                                saveUpd.write(list.toString()); //save data ke txt dalam format toString
                                                                saveUpd.newLine(); saveUpd.close(); //close I/O
                                                            }
                                                        }else{
                                                            saveUpd = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                            saveUpd.write(listBeritaTxt.get(j)); //save data ke txt dalam format toString
                                                            saveUpd.newLine(); saveUpd.close(); //close I/O
                                                        }
                                                    } 
                                                    System.out.println(">>>Berhasil Ubah Data");
                                                    break;
                                                }else if(opsi == 0){ //batal untuk update data
                                                    break;
                                                }
                                                else{ //data tidak tersedia
                                                    System.out.println(">>>Inputan Tidak Tersedia");
                                                } 
                                            }
                                        }
                                        listBeritaTxt.clear();
                                    }
                                    catch(IOException e){
                                    }
                                    break;
                                    
                                case 3: //delete data
                                    System.out.println(">>>Masukkan Baris Data Yang Akan Dihapus: ");
                                    int idDelete = input.nextInt();
                                    
                                    try{
                                        File data = new File ("Data SAD/Berita.txt"); //Objek file yang akan dibuka
                                        Scanner getData = new Scanner(data); //Untuk membaca data dari file 
                                        
                                        listBeritaTxt.clear(); //hapus list agar data tidak bertimpa
                                        while(getData.hasNextLine()) { //membaca seluruh isi file
                                            listBeritaTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                        }

                                        int size = listBeritaTxt.size(); //mendapatkan ukuran data yang sudah ada
                                        //mengetahui data yang akan dihapus 
                                        for (int i=0; i<size; i++){
                                            if(i+1 == idDelete){
                                                System.out.println(listBeritaTxt.get(i));
                                                System.out.println(">>>Yakin Menghapus Data? [1. Lanjut, 0. Batal]");
                                                
                                                int opsiDel = input.nextInt();
                                                if(opsiDel == 1){ //setuju untuk hapus data
                                                    save = new BufferedWriter (new FileWriter(data, false)); //false, berarti data file lama ditimpa
                                                    save.close(); //close I/O
                                                    
                                                    for (int j=0; j<size; j++){
                                                        if(j+1 == idDelete){

                                                        }else{
                                                            saveDel = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                            saveDel.write(listBeritaTxt.get(j)); //save data ke txt dalam format toString
                                                            saveDel.newLine(); saveDel.close(); //close I/O
                                                        }
                                                    } 
                                                    System.out.println(">>>Berhasil Hapus Data");
                                                    break;
                                                }else if(opsiDel == 0){ //batal untuk hapus data
                                                    break;
                                                }
                                                else{ //data tidak tersedia
                                                    System.out.println(">>>Inputan Tidak Tersedia");
                                                    break;
                                                }
                                            }
                                        } 
                                        listBeritaTxt.clear();
                                    }
                                    catch(IOException e){
                                    }break;

                                case 4: //view data
                                    try{
                                        File data = new File ("Data SAD/Berita.txt"); //Objek file yang akan dibuka
                                        Scanner getData = new Scanner(data); //Untuk membaca data dari file 
                                        
                                        listBeritaTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                                        while(getData.hasNextLine()) { //membaca seluruh isi file
                                            listBeritaTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                        }

                                        //mencetak data
                                        System.out.println("\nData Berita:");
                                        for (int i=0; i<listBeritaTxt.size(); i++){
                                            System.out.println(listBeritaTxt.get(i));
                                        }
                                        listBeritaTxt.clear(); 
                                    }
                                    catch(IOException e){
                                    }
                                    break;
                            }
                        }
                        while(menuTambahan != 0);
                        break;
                        
                        
                    
                    case 4://Menu untuk mengelola data saran/komentar
                        ArrayList<Saran> listSaran = new ArrayList<>(); //List menampung sebelum dimasukkan ke txt file
                        ArrayList<String> listSaranTxt = new ArrayList<>(); //List menampung dari txt file
                        do{
                            System.out.println("\nMenu Saran Lanjutan");
                            menuTambahan();
                            menuTambahan = input.nextInt();
                            
                            switch(menuTambahan){
                                case 1: //create new data
                                    System.out.println("\nMasukkan Saran/Komentar Baru: ");
                                    System.out.print("Topik Saran/Komentar: "); 
                                        String topik = scan.readLine(); 
                                    System.out.print("Deskripsi Saran/Komentar: "); 
                                        String saran = scan.readLine(); 
                                    System.out.print("Tanggal Pembuatan: "); 
                                        String tanggal = scan.readLine(); 
                                    
                                    listSaran.clear(); //hapus list utk menghindari data bertindih
                                    listSaran.add(new Saran(topik, saran, tanggal));
                                    for (Saran list : listSaran) {
                                        try{
                                            File data = new File ("Data SAD/Saran.txt"); //Objek file yang akan dibuka
                                            save = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                            save.write(list.toString()); //save data ke txt dalam format toString
                                            save.newLine();              save.close(); //close I/O
                                            System.out.println(">>>Tambah Saran Berhasil");
                                        }
                                        catch(IOException e){
                                        }
                                    }
                                    listSaran.clear();
                                    break;
                                    
                                case 2: //update data 
                                    System.out.println(">>>Masukkan Baris Saran Yang Akan Diubah: ");
                                    int idUpd = input.nextInt(), opsi=0;
                                    
                                    try{
                                        File data = new File ("Data SAD/Saran.txt"); //Objek file yang akan dibuka
                                        Scanner getData = new Scanner(data); //Untuk membaca data dari file 
                                        
                                        listSaranTxt.clear();//hapus data, agar data tidak bertindih
                                        while(getData.hasNextLine()) { //membaca seluruh isi file
                                            listSaranTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                        }

                                        int size = listSaranTxt.size(); //mendapatkan ukuran data yang sudah ada
                                        //mengetahui data yang akan diupdate dan meminta update data
                                        for (int i=0; i<size; i++){
                                            if(i+1 == idUpd){
                                                System.out.println(listSaranTxt.get(i));
                                                System.out.println(">>Yakin Mengubah Saran? [1. Lanjut, 0. Batal]");
                                                
                                                opsi = input.nextInt();
                                                if(opsi == 1){ //setuju utk update data
                                                    System.out.println(""); 
                                                    System.out.println("Masukkan Saran Baru: ");
                                                    System.out.print("Topik Saran/Komentar: "); 
                                                        String topikUpd = scan.readLine(); 
                                                    System.out.print("Deskripsi Saran/Komentar: "); 
                                                        String saranUpd = scan.readLine();  
                                                    System.out.print("Tanggal Pembuatan: "); 
                                                        String tanggalUpd = scan.readLine();  
                                                    
                                                    listSaran.clear();
                                                    listSaran.add( new Saran(topikUpd, saranUpd, tanggalUpd));
                                                    
                                                    save = new BufferedWriter (new FileWriter(data, false)); //false, berarti data file lama ditindih
                                                    save.close(); //close I/O
                                                    
                                                    for (int j=0; j<size; j++){
                                                        if(j+1 == idUpd){
                                                            for (Saran list : listSaran){
                                                                saveUpd = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                                saveUpd.write(list.toString()); //save data ke txt dalam format toString
                                                                saveUpd.newLine(); saveUpd.close(); //close I/O
                                                            }
                                                        }else{
                                                            saveUpd = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                            saveUpd.write(listSaranTxt.get(j)); //save data ke txt dalam format toString
                                                            saveUpd.newLine(); saveUpd.close(); //close I/O
                                                        }
                                                    } 
                                                    System.out.println(">>>Berhasil Ubah Saran");
                                                    break;
                                                }else if(opsi == 0){ //batal untuk update data
                                                    break;
                                                }
                                                else{ //data tidak tersedia
                                                    System.out.println(">>>Inputan Tidak Tersedia");
                                                } 
                                            }
                                        }
                                        listSaranTxt.clear();
                                    }
                                    catch(IOException e){
                                    }
                                    break;
                                    
                                case 3: //delete data
                                    System.out.println(">>>Masukkan Baris Saran Yang Akan Dihapus: ");
                                    int idDelete = input.nextInt();
                                    
                                    try{
                                        File data = new File ("Data SAD/Saran.txt"); //Objek file yang akan dibuka
                                        Scanner getData = new Scanner(data); //Untuk membaca data dari file 
                                        
                                        listSaranTxt.clear(); //hapus list agar data tidak bertimpa
                                        while(getData.hasNextLine()) { //membaca seluruh isi file
                                            listSaranTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                        }

                                        int size = listSaranTxt.size(); //mendapatkan ukuran data yang sudah ada
                                        //mengetahui data yang akan dihapus 
                                        for (int i=0; i<size; i++){
                                            if(i+1 == idDelete){
                                                System.out.println(listSaranTxt.get(i));
                                                System.out.println(">>>Yakin Menghapus Data? [1. Lanjut, 0. Batal]");
                                                
                                                int opsiDel = input.nextInt();
                                                if(opsiDel == 1){ //setuju untuk hapus data
                                                    save = new BufferedWriter (new FileWriter(data, false)); //false, berarti data file lama ditimpa
                                                    save.close(); //close I/O
                                                    
                                                    for (int j=0; j<size; j++){
                                                        if(j+1 == idDelete){

                                                        }else{
                                                            saveDel = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                            saveDel.write(listSaranTxt.get(j)); //save data ke txt dalam format toString
                                                            saveDel.newLine(); saveDel.close(); //close I/O
                                                        }
                                                    } 
                                                    System.out.println(">>>Berhasil Hapus Saran");
                                                    break;
                                                }else if(opsiDel == 0){ //batal untuk hapus data
                                                    break;
                                                }
                                                else{ //data tidak tersedia
                                                    System.out.println(">>>Inputan Tidak Tersedia");
                                                    break;
                                                }
                                            }
                                        } 
                                        listSaranTxt.clear();
                                    }
                                    catch(IOException e){
                                    }break;

                                case 4: //view data
                                    try{
                                        File data = new File ("Data SAD/Saran.txt"); //Objek file yang akan dibuka
                                        Scanner getData = new Scanner(data); //Untuk membaca data dari file 
                                        
                                        listSaranTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                                        while(getData.hasNextLine()) { //membaca seluruh isi file
                                            listSaranTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                        }

                                        //mencetak data
                                        System.out.println("\nData Saran/Komentar:");
                                        for (int i=0; i<listSaranTxt.size(); i++){
                                            System.out.println(listSaranTxt.get(i));
                                        }
                                        listSaranTxt.clear(); 
                                    }
                                    catch(IOException e){
                                    }
                                    break;
                            }
                        }
                        while(menuTambahan != 0);
                        break;
                        
                        

                    case 5: //Menu untuk mengelola data member
                        ArrayList<Member> listMember = new ArrayList<>(); //List menampung sebelum dimasukkan ke txt file
                        ArrayList<String> listMemberTxt = new ArrayList<>(); //List menampung dari txt file
                        do{
                            System.out.println("\nMenu Member Lanjutan");
                            menuTambahan();
                            menuTambahan = input.nextInt();
                            int temp=0;
                            
                            switch(menuTambahan){
                                case 1: //create new data
                                    System.out.println("\nMasukkan Data Member: ");
                                    System.out.print("Nama: "); 
                                        String nama = scan.readLine(); 
                                    System.out.print("Email: "); 
                                        String email = scan.readLine(); 
                                    System.out.print("Gender: "); 
                                        String gender = scan.readLine(); 
                                    System.out.print("Alamat: "); 
                                        String alamat = scan.readLine(); 
                                    System.out.print("Username: "); 
                                        String username = scan.readLine(); 
                                    System.out.print("Password: "); 
                                        String password = scan.readLine();
                                    
                                    try{
                                        File data = new File ("Data SAD/Member.txt"); //Objek file yang akan dibuka
                                        Scanner getData = new Scanner(data); //Untuk membaca data dari file 

                                        listMemberTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                                        while(getData.hasNextLine()) { //membaca seluruh isi file
                                            listMemberTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                        }

                                        //cek apakah inputan sama dengan yang terdaftar
                                        for (int i=0; i<listMemberTxt.size(); i++){
                                            if(listMemberTxt.get(i).split(",")[4].split(": ")[1].equals(username) || listMemberTxt.get(i).split(",")[1].split(": ").equals(password)){
                                                temp = 1;
                                            }
                                        }
                                        listMemberTxt.clear(); 

                                        if(temp == 1){
                                            System.out.println(">>>Maaf, Username/Email Sudah Pernah Terdaftar");
                                            break;
                                        }
  
                                        Member dataMember = new Member(nama, email, gender, alamat, username, password);
                                        save = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                        save.write(dataMember.toString()); //save data ke txt dalam format toString
                                        save.newLine(); 
                                        save.close(); //close I/O
                                        System.out.println(">>>Daftar Berhasil");
                                    }catch(IOException e){ 
                                    } 
                                    break;
                                    
                                case 2: //update data 
                                    System.out.println(">>>Masukkan Baris Data Yang Akan Diubah: ");
                                    int idUpd = input.nextInt(), opsi=0;
                                    
                                    try{
                                        File data = new File ("Data SAD/Member.txt"); //Objek file yang akan dibuka
                                        Scanner getData = new Scanner(data); //Untuk membaca data dari file 
                                        
                                        listMemberTxt.clear();//hapus data, agar data tidak bertindih
                                        while(getData.hasNextLine()) { //membaca seluruh isi file
                                            listMemberTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                        }

                                        int size = listMemberTxt.size(); //mendapatkan ukuran data yang sudah ada
                                        //mengetahui data yang akan diupdate dan meminta update data
                                        for (int i=0; i<size; i++){
                                            if(i+1 == idUpd){
                                                System.out.println(listMemberTxt.get(i));
                                                System.out.println(">>Yakin Mengubah Data? [1. Lanjut, 0. Batal]");
                                                
                                                opsi = input.nextInt();
                                                if(opsi == 1){ //setuju utk update data
                                                    System.out.println(""); 
                                                    System.out.println("Masukkan Data Baru Member: ");
                                                    System.out.print("Nama: "); 
                                                    String namaUpd = scan.readLine(); 
                                                    System.out.print("Email: "); 
                                                    String emailUpd = scan.readLine(); 
                                                    System.out.print("Gender: "); 
                                                    String genderUpd = scan.readLine(); 
                                                    System.out.print("Alamat: "); 
                                                    String alamatUpd = scan.readLine(); 
                                                    System.out.print("Username: "); 
                                                    String usernameUpd = scan.readLine(); 
                                                    System.out.print("Password: "); 
                                                    String passwordUpd = scan.readLine();
                                                    
                                                    listMember.clear();
                                                    listMember.add( new Member(namaUpd, emailUpd, genderUpd, alamatUpd, usernameUpd, passwordUpd));
                                                    
                                                    save = new BufferedWriter (new FileWriter(data, false)); //false, berarti data file lama ditindih
                                                    save.close(); //close I/O
                                                    
                                                    for (int j=0; j<size; j++){
                                                        if(j+1 == idUpd){
                                                            for (Member list : listMember){
                                                                saveUpd = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                                saveUpd.write(list.toString()); //save data ke txt dalam format toString
                                                                saveUpd.newLine(); saveUpd.close(); //close I/O
                                                            }
                                                        }else{
                                                            saveUpd = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                            saveUpd.write(listMemberTxt.get(j)); //save data ke txt dalam format toString
                                                            saveUpd.newLine(); saveUpd.close(); //close I/O
                                                        }
                                                    } 
                                                    System.out.println(">>>Berhasil Ubah Data");
                                                    break;
                                                }else if(opsi == 0){ //batal untuk update data
                                                    break;
                                                }
                                                else{ //data tidak tersedia
                                                    System.out.println(">>>Inputan Tidak Tersedia");
                                                } 
                                            }
                                        }
                                        listMemberTxt.clear();
                                    }
                                    catch(IOException e){
                                    }
                                    break;
                                    
                                case 3: //delete data
                                    System.out.println(">>>Masukkan Baris Data Yang Akan Dihapus: ");
                                    int idDelete = input.nextInt();
                                    
                                    try{
                                        File data = new File ("Data SAD/Member.txt"); //Objek file yang akan dibuka
                                        Scanner getData = new Scanner(data); //Untuk membaca data dari file 
                                        
                                        listMemberTxt.clear(); //hapus list agar data tidak bertimpa
                                        while(getData.hasNextLine()) { //membaca seluruh isi file
                                            listMemberTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                        }

                                        int size = listMemberTxt.size(); //mendapatkan ukuran data yang sudah ada
                                        //mengetahui data yang akan dihapus 
                                        for (int i=0; i<size; i++){
                                            if(i+1 == idDelete){
                                                System.out.println(listMemberTxt.get(i));
                                                System.out.println(">>>Yakin Menghapus Data? [1. Lanjut, 0. Batal]");
                                                
                                                int opsiDel = input.nextInt();
                                                if(opsiDel == 1){ //setuju untuk hapus data
                                                    save = new BufferedWriter (new FileWriter(data, false)); //false, berarti data file lama ditimpa
                                                    save.close(); //close I/O
                                                    
                                                    for (int j=0; j<size; j++){
                                                        if(j+1 == idDelete){

                                                        }else{
                                                            saveDel = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                            saveDel.write(listMemberTxt.get(j)); //save data ke txt dalam format toString
                                                            saveDel.newLine(); saveDel.close(); //close I/O
                                                        }
                                                    } 
                                                    System.out.println(">>>Berhasil Hapus Data");
                                                    break;
                                                }else if(opsiDel == 0){ //batal untuk hapus data
                                                    break;
                                                }
                                                else{ //data tidak tersedia
                                                    System.out.println(">>>Inputan Tidak Tersedia");
                                                    break;
                                                }
                                            }
                                        } 
                                        listMemberTxt.clear();
                                    }
                                    catch(IOException e){
                                    }break;

                                case 4: //view data
                                    try{
                                        File data = new File ("Data SAD/Member.txt"); //Objek file yang akan dibuka
                                        Scanner getData = new Scanner(data); //Untuk membaca data dari file 
                                        
                                        listMemberTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                                        while(getData.hasNextLine()) { //membaca seluruh isi file
                                            listMemberTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                        }

                                        //mencetak data
                                        System.out.println("\nData Member:");
                                        for (int i=0; i<listMemberTxt.size(); i++){
                                            System.out.println(listMemberTxt.get(i));
                                        }
                                        listMemberTxt.clear(); 
                                    }
                                    catch(IOException e){
                                    }
                                    break;
                            }
                        }
                        while(menuTambahan != 0);
                        break;
                
                
                
                }
            }
            while (menuUtama != 0);
        
        }
        
        
        
        else if(member == 1){
            do{
                menuUtamaMember();
                menuUtama = input.nextInt();
                
                switch(menuUtama){
                    case 1: //menu layanan surat lanjutan
                        int menuSurat, temp=0;
                        ArrayList<String> listPendudukTxt = new ArrayList<>(); //List menampung dari txt file 
                        do{
                            System.out.println("\nMenu Lanjutan Layanan Surat");
                            layananSurat();
                            layananSurat = input.nextInt();
                            
                            switch(layananSurat){
                                case 1: //surat ket KK
                                    ArrayList<String> listKKTxt = new ArrayList<>(); //List menampung dari txt file
                                    do{
                                        System.out.println("\nMenu Tambahan:");
                                        menuSurat();
                                        menuSurat = input.nextInt();
                                        switch(menuSurat){
                                            case 1://request
                                                System.out.println("\nMasukkan NIK Ayah:");
                                                    String nikAyah = scan.readLine(); 
                                                System.out.println("Masukkan NIK Ibu:");
                                                    String nikIbu = scan.readLine(); 
                                                System.out.println("Masukkan NIK Anak: [Pisahkan dengan tanda '_']");
                                                    String nikAnak = scan.readLine();
                                                    
                                                try{
                                                    File data = new File ("Data SAD/KK.txt"); //Objek file yang akan dibuka
                                                    save = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan ke surat
                                                    
                                                    File data2 = new File ("Data SAD/Penduduk.txt"); //Objek file yang akan dibuka
                                                    Scanner getData = new Scanner(data2); //Untuk membaca data dari file penduduk
                                                    
                                                    listPendudukTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                                                    while(getData.hasNextLine()) { //membaca seluruh isi file
                                                        listPendudukTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                                    }

                                                    //mencek apakah nik yang direquest terdaftar
                                                    for (int i=0; i<listPendudukTxt.size(); i++){
                                                        if(listPendudukTxt.get(i).split(",")[0].split(": ")[1].equals(nikAyah) || listPendudukTxt.get(i).split(",")[0].split(": ")[1].equals(nikIbu)){
                                                            KK kk = new KK( nikAyah,  nikIbu, nikAnak, StatusRequest.Diminta, memberNow); 
                                                            save.write(kk.toString()); //save data ke txt dalam format toString
                                                            save.newLine();
                                                            save.close(); //close I/O
                                                            System.out.println(">>>Request Surat Pengantar KK Berhasil");
                                                            temp = 1;
                                                            break;
                                                        }
                                                    }
                                                    
                                                    if(temp == 0){
                                                        System.out.println(">>>Request Surat Gagal. NIK Orang Tua belum terdaftar dalam sistem");
                                                    }
                                                    listPendudukTxt.clear(); 
                                                }
                                                catch(IOException e){
                                                } 
                                                break;
                                                
                                            case 2: //riwayat request
                                                try{
                                                    File data = new File ("Data SAD/KK.txt"); //Objek file yang akan dibuka
                                                    Scanner getData = new Scanner(data); //Untuk membaca data dari file 

                                                    listKKTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                                                    while(getData.hasNextLine()) { //membaca seluruh isi file
                                                        listKKTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                                    }

                                                    //mencetak daftar surat yang pernah di request oleh user yang login
                                                    System.out.println("\nRiwayat Surat Pengurusan KK oleh Member : " + memberNow );
                                                    for (int i=0; i<listKKTxt.size(); i++){
                                                        if(listKKTxt.get(i).split(",")[4].split(": ")[1].equals(memberNow)){
                                                            System.out.println(listKKTxt.get(i).split(",")[0] + "," 
                                                               + listKKTxt.get(i).split(",")[1] + "," 
                                                               + listKKTxt.get(i).split(",")[2] + "," 
                                                               + listKKTxt.get(i).split(",")[3] 
                                                            );
                                                        }
                                                    }
                                                    listKKTxt.clear(); 
                                                }
                                                catch(IOException e){
                                                } 
                                        }
                                    }while(menuSurat != 0);
                                    break;
                                    
                                case 2: //surat ket KTP
                                    ArrayList<String> listKtpTxt = new ArrayList<>(); //List menampung dari txt file
                                    do{
                                        System.out.println("\nMenu Tambahan:");
                                        menuSurat();
                                        menuSurat = input.nextInt();
                                        switch(menuSurat){
                                            case 1://request
                                                System.out.println("\nMasukkan NIK Penduduk Bersangkutan:");
                                                    String nik = scan.readLine(); 
                                                try{
                                                    File data = new File ("Data SAD/KTP.txt"); //Objek file yang akan dibuka
                                                    save = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan ke surat
                                                    
                                                    File data2 = new File ("Data SAD/Penduduk.txt"); //Objek file yang akan dibuka
                                                    Scanner getData = new Scanner(data2); //Untuk membaca data dari file penduduk
                                                    
                                                    listPendudukTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                                                    while(getData.hasNextLine()) { //membaca seluruh isi file
                                                        listPendudukTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                                    }

                                                    //mencek apakah nik yang direquest terdaftar
                                                    for (int i=0; i<listPendudukTxt.size(); i++){
                                                        if(listPendudukTxt.get(i).split(",")[0].split(": ")[1].equals(nik)){
                                                            KTP ktp = new KTP( nik, StatusRequest.Diminta, memberNow); 
                                                            save.write(ktp.toString()); //save data ke txt dalam format toString
                                                            save.newLine();
                                                            save.close(); //close I/O
                                                            System.out.println(">>>Request Surat Pengantar KTP Berhasil");
                                                            temp = 1;
                                                            break;
                                                        }
                                                    }
                                                    
                                                    if(temp == 0){
                                                        System.out.println(">>>Request Surat Gagal. NIK belum terdaftar dalam sistem");
                                                    }
                                                    listPendudukTxt.clear(); 
                                                }
                                                catch(IOException e){
                                                } 
                                                break;
                                                
                                            case 2: //riwayat request
                                                try{
                                                    File data = new File ("Data SAD/KTP.txt"); //Objek file yang akan dibuka
                                                    Scanner getData = new Scanner(data); //Untuk membaca data dari file 

                                                    listKtpTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                                                    while(getData.hasNextLine()) { //membaca seluruh isi file
                                                        listKtpTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                                    }

                                                    //mencetak daftar surat yang pernah di request oleh user yang login
                                                    System.out.println("\nRiwayat Surat Pengurusan KTP oleh Member : " + memberNow );
                                                    for (int i=0; i<listKtpTxt.size(); i++){
                                                        if(listKtpTxt.get(i).split(",")[2].split(": ")[1].equals(memberNow)){
                                                            System.out.println(listKtpTxt.get(i).split(",")[0] + "," 
                                                               + listKtpTxt.get(i).split(",")[1] 
                                                            );
                                                        }
                                                    }
                                                    listKtpTxt.clear(); 
                                                }
                                                catch(IOException e){
                                                } 
                                        }
                                    }while(menuSurat != 0);
                                    break;
                                    
                                case 3: //surat ket Domisili
                                    ArrayList<String> listDomisiliTxt = new ArrayList<>(); //List menampung dari txt file
                                    do{
                                        System.out.println("\nMenu Tambahan:");
                                        menuSurat();
                                        menuSurat = input.nextInt();
                                        switch(menuSurat){
                                            case 1://request
                                                System.out.println("\nMasukkan NIK Penduduk Bersangkutan:");
                                                    String nik = scan.readLine(); 
                                                System.out.println("Masukkan Tujuan Pengurusan Surat:");
                                                    String tujuan = scan.readLine(); 
                                                
                                                try{
                                                    File data = new File ("Data SAD/Domisili.txt"); //Objek file yang akan dibuka
                                                    save = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan ke surat
                                                    
                                                    File data2 = new File ("Data SAD/Penduduk.txt"); //Objek file yang akan dibuka
                                                    Scanner getData = new Scanner(data2); //Untuk membaca data dari file penduduk
                                                    
                                                    listPendudukTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                                                    while(getData.hasNextLine()) { //membaca seluruh isi file
                                                        listPendudukTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                                    }

                                                    //mencek apakah nik yang direquest terdaftar
                                                    for (int i=0; i<listPendudukTxt.size(); i++){
                                                        if(listPendudukTxt.get(i).split(",")[0].split(": ")[1].equals(nik)){
                                                            Domisili dom = new Domisili(tujuan, nik, StatusRequest.Diminta, memberNow); 
                                                            save.write(dom.toString()); //save data ke txt dalam format toString
                                                            save.newLine();
                                                            save.close(); //close I/O
                                                            System.out.println(">>>Request Surat Domisili Berhasil");
                                                            temp = 1;
                                                            break;
                                                        }
                                                    }
                                                    
                                                    if(temp == 0){
                                                        System.out.println(">>>Request Surat Gagal. NIK belum terdaftar dalam sistem");
                                                    }
                                                    listPendudukTxt.clear(); 
                                                }
                                                catch(IOException e){
                                                } 
                                                break;
                                                
                                            case 2: //riwayat request
                                                try{
                                                    File data = new File ("Data SAD/Domisili.txt"); //Objek file yang akan dibuka
                                                    Scanner getData = new Scanner(data); //Untuk membaca data dari file 

                                                    listDomisiliTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                                                    while(getData.hasNextLine()) { //membaca seluruh isi file
                                                        listDomisiliTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                                    }

                                                    //mencetak daftar surat yang pernah di request oleh user yang login
                                                    System.out.println("\nRiwayat Surat Domisili oleh Member : " + memberNow );
                                                    for (int i=0; i<listDomisiliTxt.size(); i++){
                                                        if(listDomisiliTxt.get(i).split(",")[3].split(": ")[1].equals(memberNow)){
                                                            System.out.println(listDomisiliTxt.get(i).split(",")[0] + "," 
                                                               + listDomisiliTxt.get(i).split(",")[1] + "," 
                                                               + listDomisiliTxt.get(i).split(",")[2] 
                                                            );
                                                        }
                                                    }
                                                    listDomisiliTxt.clear(); 
                                                }
                                                catch(IOException e){
                                                } 
                                        }
                                    }while(menuSurat != 0);
                                    break;
                                    
                                case 4: //surat ket Tidak Mampu
                                    ArrayList<String> listTidakMampuTxt = new ArrayList<>(); //List menampung dari txt file
                                    do{
                                        System.out.println("\nMenu Tambahan:");
                                        menuSurat();
                                        menuSurat = input.nextInt();
                                        switch(menuSurat){
                                            case 1://request
                                                System.out.println("\nMasukkan NIK Penduduk Bersangkutan:");
                                                    String nik = scan.readLine(); 
                                                System.out.println("Masukkan Tujuan Pengurusan Surat:");
                                                    String tujuan = scan.readLine(); 
                                                
                                                try{
                                                    File data = new File ("Data SAD/TidakMampu.txt"); //Objek file yang akan dibuka
                                                    save = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan ke surat
                                                    
                                                    File data2 = new File ("Data SAD/Penduduk.txt"); //Objek file yang akan dibuka
                                                    Scanner getData = new Scanner(data2); //Untuk membaca data dari file penduduk
                                                    
                                                    listPendudukTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                                                    while(getData.hasNextLine()) { //membaca seluruh isi file
                                                        listPendudukTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                                    }

                                                    //mencek apakah nik yang direquest terdaftar
                                                    for (int i=0; i<listPendudukTxt.size(); i++){
                                                        if(listPendudukTxt.get(i).split(",")[0].split(": ")[1].equals(nik)){
                                                            Domisili dom = new Domisili(tujuan, nik, StatusRequest.Diminta, memberNow); 
                                                            save.write(dom.toString()); //save data ke txt dalam format toString
                                                            save.newLine();
                                                            save.close(); //close I/O
                                                            System.out.println(">>>Request Surat Ket. Tidak Mampu Berhasil");
                                                            temp = 1;
                                                            break;
                                                        }
                                                    }
                                                    
                                                    if(temp == 0){
                                                        System.out.println(">>>Request Surat Gagal. NIK belum terdaftar dalam sistem");
                                                    }
                                                    listPendudukTxt.clear(); 
                                                }
                                                catch(IOException e){
                                                } 
                                                break;
                                                
                                            case 2: //riwayat request
                                                try{
                                                    File data = new File ("Data SAD/TidakMampu.txt"); //Objek file yang akan dibuka
                                                    Scanner getData = new Scanner(data); //Untuk membaca data dari file 

                                                    listTidakMampuTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                                                    while(getData.hasNextLine()) { //membaca seluruh isi file
                                                        listTidakMampuTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                                    }

                                                    //mencetak daftar surat yang pernah di request oleh user yang login
                                                    System.out.println("\nRiwayat Surat Ket. Tidak Mampu oleh Member : " + memberNow );
                                                    for (int i=0; i<listTidakMampuTxt.size(); i++){
                                                        if(listTidakMampuTxt.get(i).split(",")[3].split(": ")[1].equals(memberNow)){
                                                            System.out.println(listTidakMampuTxt.get(i).split(",")[0] + "," 
                                                               + listTidakMampuTxt.get(i).split(",")[1] + "," 
                                                               + listTidakMampuTxt.get(i).split(",")[2] 
                                                            );
                                                        }
                                                    }
                                                    listTidakMampuTxt.clear(); 
                                                }
                                                catch(IOException e){
                                                } 
                                        }
                                    }while(menuSurat != 0);
                                    break;
                                    
                                case 5: //surat ket Pindah
                                    ArrayList<String> listMigrasiTxt = new ArrayList<>(); //List menampung dari txt file
                                    do{
                                        System.out.println("\nMenu Tambahan:");
                                        menuSurat();
                                        menuSurat = input.nextInt();
                                        switch(menuSurat){
                                            case 1://request
                                                System.out.println("\nMasukkan NIK Penduduk Bersangkutan:");
                                                    String nik = scan.readLine(); 
                                                System.out.println("Masukkan Alamat Sekarang Penduduk:");
                                                    String alamat_skrg = scan.readLine(); 
                                                System.out.println("Masukkan Alamat Tujuan Penduduk:");
                                                    String alamat_tujuan = scan.readLine(); 
                                                System.out.println("Masukkan Jumlah Orang yang Ikut Pindah:");
                                                    int jumlah = input.nextInt();
                                                
                                                try{
                                                    File data = new File ("Data SAD/Migrasi.txt"); //Objek file yang akan dibuka
                                                    save = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan ke surat
                                                    
                                                    File data2 = new File ("Data SAD/Penduduk.txt"); //Objek file yang akan dibuka
                                                    Scanner getData = new Scanner(data2); //Untuk membaca data dari file penduduk
                                                    
                                                    listPendudukTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                                                    while(getData.hasNextLine()) { //membaca seluruh isi file
                                                        listPendudukTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                                    }

                                                    //mencek apakah nik yang direquest terdaftar
                                                    for (int i=0; i<listPendudukTxt.size(); i++){
                                                        if(listPendudukTxt.get(i).split(",")[0].split(": ")[1].equals(nik)){
                                                            Migrasi migr = new Migrasi(nik, alamat_skrg, alamat_tujuan, jumlah, StatusRequest.Diminta, memberNow); 
                                                            save.write(migr.toString()); //save data ke txt dalam format toString
                                                            save.newLine();
                                                            save.close(); //close I/O
                                                            System.out.println(">>>Request Surat Pindah Penduduk Berhasil");
                                                            temp = 1;
                                                            break;
                                                        }
                                                    }
                                                    
                                                    if(temp == 0){
                                                        System.out.println(">>>Request Surat Gagal. NIK belum terdaftar dalam sistem");
                                                    }
                                                    listPendudukTxt.clear(); 
                                                }
                                                catch(IOException e){
                                                } 
                                                break;
                                                
                                            case 2: //riwayat request
                                                try{
                                                    File data = new File ("Data SAD/Migrasi.txt"); //Objek file yang akan dibuka
                                                    Scanner getData = new Scanner(data); //Untuk membaca data dari file 

                                                    listMigrasiTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                                                    while(getData.hasNextLine()) { //membaca seluruh isi file
                                                        listMigrasiTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                                    }

                                                    //mencetak daftar surat yang pernah di request oleh user yang login
                                                    System.out.println("\nRiwayat Surat Pindah Penduduk oleh Member : " + memberNow );
                                                    for (int i=0; i<listMigrasiTxt.size(); i++){
                                                        if(listMigrasiTxt.get(i).split(",")[5].split(": ")[1].equals(memberNow)){
                                                            System.out.println(listMigrasiTxt.get(i).split(",")[0] + "," 
                                                               + listMigrasiTxt.get(i).split(",")[1] + "," 
                                                               + listMigrasiTxt.get(i).split(",")[2] + "," 
                                                               + listMigrasiTxt.get(i).split(",")[3] + "," 
                                                               + listMigrasiTxt.get(i).split(",")[4] 
                                                            );
                                                        }
                                                    }
                                                    listMigrasiTxt.clear(); 
                                                }
                                                catch(IOException e){
                                                } 
                                        }
                                    }while(menuSurat != 0);
                                    break;
                            }
                        }while(layananSurat != 0);
                        break;
                        
                    case 2: //menu berita lanjutan
                        ArrayList<String> listBeritaTxt = new ArrayList<>(); //List menampung dari txt file
                        try{
                            File data = new File ("Data SAD/Berita.txt"); //Objek file yang akan dibuka
                            Scanner getData = new Scanner(data); //Untuk membaca data dari file 

                            listBeritaTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                            while(getData.hasNextLine()) { //membaca seluruh isi file
                                listBeritaTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                            }

                            //mencetak data
                            System.out.println("\nDaftar Berita Saat Ini:");
                            for (int i=0; i<listBeritaTxt.size(); i++){
                                System.out.println(listBeritaTxt.get(i));
                            }
                            listBeritaTxt.clear(); 
                        }
                        catch(IOException e){
                        }
                        break;
                        
                    case 3: //menu saran/komentar lanjutan
                        int opsi=1;
                        ArrayList<Saran> listSaran = new ArrayList<>(); //List menampung sebelum disimpan ke txt file
                        ArrayList<String> listSaranTxt = new ArrayList<>(); //List menampung dari txt file
                        
                        do{
                            try{
                                File data = new File ("Data SAD/Saran.txt"); //Objek file yang akan dibuka
                                Scanner getData = new Scanner(data); //Untuk membaca data dari file 

                                listSaranTxt.clear();//menghapus list, agar ketika list dipanggil ulang, element tidak bertindih
                                while(getData.hasNextLine()) { //membaca seluruh isi file
                                    listSaranTxt.add(getData.nextLine()); //save data dari txt file ke arraylist
                                }

                                //mencetak data
                                System.out.println("\nDaftar Saran/Komentar Saat Ini:");
                                for (int i=0; i<listSaranTxt.size(); i++){
                                    System.out.println(listSaranTxt.get(i));
                                }

                                System.out.println("\n>>>Mau Menambah Saran/Komentar Baru? [Tekan 1. Untuk Menambahkan, Lainnya Untuk Keluar]");
                                opsi = input.nextInt();
                                if(opsi == 1){
                                    System.out.println("\nMasukkan Saran/Komentar Baru: ");
                                    System.out.print("Topik Saran/Komentar: "); 
                                        String topik = scan.readLine(); 
                                    System.out.print("Deskripsi Saran/Komentar: "); 
                                        String saran = scan.readLine(); 
                                    System.out.print("Tanggal Pembuatan: "); 
                                        String tanggal = scan.readLine(); 

                                    listSaran.clear(); //hapus list utk menghindari data bertindih
                                    listSaran.add(new Saran(topik, saran, tanggal));
                                    for (Saran list : listSaran) {
                                        try{
                                            File dataSaran = new File ("Data SAD/Saran.txt"); //Objek file yang akan dibuka
                                            save = new BufferedWriter (new FileWriter(dataSaran, true)); //true, berarti data file lama ditambahkan
                                            save.write(list.toString()); //save data ke txt dalam format toString
                                            save.newLine();
                                            save.close(); //close I/O
                                            System.out.println(">>>Tambah Saran Berhasil");
                                        }
                                        catch(IOException e){
                                        }
                                    }
                                    listSaran.clear();
                                }
                                listSaranTxt.clear(); 
                            }
                            catch(IOException e){
                            }
                        }while (opsi == 1);
                        break;
                        
                        
                }
            }while (menuUtama!=0);
        }

     
   
     
     
     


    }
    catch(InputMismatchException e){
        System.out.println(">>Maaf, Inputan Anda Salah--");
    } 
    catch(IOException e){
        System.out.println(">>>Maaf, Terjadi Kesalahan  Pada File");
    }
    catch(ArrayIndexOutOfBoundsException e){
        System.out.println(">>>Data yang Hendak ditampilkan diluar Batas");
    }
    System.out.println(""); 
    System.out.println("---Terimakasih Telah Datang Berkunjung---"); 
 }
}


