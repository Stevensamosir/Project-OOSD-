package administrasidesa;

//impor lib yang dibutuhkan 
import static administrasidesa.cadangan.menuAwal;
import java.io.*; 
import java.util.*;
 
//deklarasi class utama 
public class temp{ 
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
      System.out.println("");
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
  
  
  
 public static void main(String[] args){ 
    //create folder
    File folder = new File("Data SAD");
    folder.mkdir(); //create folder "Data SAD"
    
    //deklarasi untuk masukan user
    BufferedWriter outs; 
    BufferedReader ins; 
    BufferedReader scan = new BufferedReader(new InputStreamReader(System.in)); 
    Scanner input = new Scanner(System.in); //membuat variabel untuk menerima inputan user
    
    //variabel
    int menuAwal, menuUtama, menuTambahan, admin=0, member=0; 
    String usernameAdmin = "admin", passwordAdmin = "admin";
    String usernameMember = "member", passwordMember = "member";
    
    try{
        do{
            menuAwal();
            menuAwal = input.nextInt();

            if(menuAwal == 1){
                System.out.println(""); 
                System.out.print("Masukkan username: "); 
                String username = input.next(); 
                System.out.print("Masukkan password: "); 
                String password = input.next();  

                if(username.equals(usernameAdmin) && password.equals(passwordAdmin)){
                    System.out.println(">>>Berhasil masuk");
                    admin = 1;
                    break;
                }
                else{
                    System.out.println(">>>Gagal masuk");
                    admin = 0;
                } 
            }
            else if(menuAwal == 2){
                System.out.println(""); 
                System.out.print("Masukkan username: "); 
                String username = input.next(); 
                System.out.print("Masukkan password: "); 
                String password = input.next();  

                if(username.equals(usernameMember) && password.equals(passwordMember)){
                    System.out.println(">>>Berhasil masuk");
                    member = 1;
                    break;
                }else{
                    System.out.println(">>>Gagal masuk");
                    member = 0;
                } 
            }
            else if(menuAwal == 3){
                System.out.println(""); 
                System.out.println("Masukkan data diri anda : ");
                System.out.print("Nama: "); 
                String nama = input.next(); 
                System.out.print("Gender: "); 
                String gender = input.next(); 
                System.out.print("Alamat: "); 
                String alamat = input.next(); 
                System.out.print("Username: "); 
                String username = input.next(); 
                System.out.print("Password: "); 
                String password = input.next();

                try{ 
                    File data = new File ("Data SAD/Member.txt"); //membuat file txt didalam folder
                    PrintWriter save = new PrintWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan

                    Member dataMember = new Member(nama, gender, alamat, username, password);

                    save.println(dataMember.toString()); //save data ke txt dalam format toString
                    save.close(); //close I/O
                    System.out.println(">>>Daftar Berhasil");
                }catch(Exception e){ 
                  System.out.println(">>>Maaf, data anda tidak dapat disimpan, coba lagi"); 
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
                        
                    case 2: //Menu untuk mengelola data penduduk
                        ArrayList<Penduduk> listPenduduk = new ArrayList<>(); //List menampung sebelum dimasukkan ke txt file
                        ArrayList<String> listPendudukTxt = new ArrayList<>(); //List menampung dari txt file
                        do{
                            System.out.println("\nMenu Penduduk Lanjutan");
                            menuTambahan();
                            menuTambahan = input.nextInt();
                            
                            switch(menuTambahan){
                                case 1: //create new data
                                    System.out.println("\nMasukkan Data Penduduk: ");
                                    System.out.print("NIK: "); 
                                        String nik = input.next(); 
                                    System.out.print("No. KK: "); 
                                        String no_kk = input.next(); 
                                    System.out.print("Nama: "); 
                                        String nama = input.next(); 
                                    System.out.print("Gender: "); 
                                        String gender = input.next(); 
                                    System.out.print("Tempat Lahir: "); 
                                        String tempat_lahir = input.next(); 
                                    System.out.print("Tanggal Lahir: "); 
                                        String tanggal_lahir = input.next(); 
                                    System.out.print("Golongan Darah: "); 
                                        String gol_darah = input.next(); 
                                    System.out.print("Agama: "); 
                                        String agama = input.next(); 
                                    System.out.print("Pekerjaan: "); 
                                        String pekerjaan = input.next(); 
                                    System.out.print("Nama Ayah: "); 
                                        String nama_ayah = input.next();     
                                    System.out.print("Nama Ibu: "); 
                                        String nama_ibu = input.next();     
                                        
                                    listPenduduk.clear(); //hapus list utk menghindari data bertindih
                                    listPenduduk.add(new Penduduk(nik, no_kk, nama, gender, tempat_lahir, tanggal_lahir, gol_darah, agama, pekerjaan, nama_ayah, nama_ibu));
                                    for (Penduduk list : listPenduduk) {
                                        try{
                                            File data = new File ("Data SAD/Penduduk.txt"); //Objek file yang akan dibuka
                                            PrintWriter save = new PrintWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                            save.println(list.toString()); //save data ke txt dalam format toString
                                            save.close(); //close I/O
                                            System.out.println(">>>Tambah Data Berhasil");
                                        }
                                        catch(IOException e){
                                            System.out.println(">>>Maaf, File Tidak Ditemukan");
                                        }
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
                                                        String nikUpd = input.next(); 
                                                    System.out.print("No. KK: "); 
                                                        String no_kkUpd = input.next(); 
                                                    System.out.print("Nama: "); 
                                                        String namaUpd = input.next(); 
                                                    System.out.print("Gender: "); 
                                                        String genderUpd = input.next(); 
                                                    System.out.print("Tempat Lahir: "); 
                                                        String tempat_lahirUpd = input.next(); 
                                                    System.out.print("Tanggal Lahir: "); 
                                                        String tanggal_lahirUpd = input.next(); 
                                                    System.out.print("Golongan Darah: "); 
                                                        String gol_darahUpd = input.next(); 
                                                    System.out.print("Agama: "); 
                                                        String agamaUpd = input.next(); 
                                                    System.out.print("Pekerjaan: "); 
                                                        String pekerjaanUpd = input.next(); 
                                                    System.out.print("Nama Ayah: "); 
                                                        String nama_ayahUpd = input.next();     
                                                    System.out.print("Nama Ibu: "); 
                                                        String nama_ibuUpd = input.next();
                                                    
                                                    listPenduduk.clear();
                                                    listPenduduk.add( new Penduduk(nikUpd, no_kkUpd, namaUpd, genderUpd, tempat_lahirUpd, tanggal_lahirUpd, gol_darahUpd, agamaUpd, pekerjaanUpd, nama_ayahUpd, nama_ibuUpd));
                                                    
                                                    PrintWriter save = new PrintWriter (new FileWriter(data, false)); //false, berarti data file lama ditindih
                                                    save.close(); //close I/O
                                                    
                                                    for (int j=0; j<size; j++){
                                                        if(j+1 == idUpd){
                                                            for (Penduduk list : listPenduduk){
                                                                PrintWriter saveUpd = new PrintWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                                saveUpd.println(list.toString()); //save data ke txt dalam format toString
                                                                saveUpd.close(); //close I/O
                                                            }
                                                        }else{
                                                            PrintWriter saveDel = new PrintWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                            saveDel.println(listPendudukTxt.get(j)); //save data ke txt dalam format toString
                                                            saveDel.close(); //close I/O
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
                                        System.out.println(">>>Maaf, File Tidak Ditemukan");
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
                                                    PrintWriter save = new PrintWriter (new FileWriter(data, false)); //false, berarti data file lama ditimpa
                                                    save.close(); //close I/O
                                                    
                                                    for (int j=0; j<size; j++){
                                                        if(j+1 == idDelete){

                                                        }else{
                                                            PrintWriter saveDel = new PrintWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                            saveDel.println(listPendudukTxt.get(j)); //save data ke txt dalam format toString
                                                            saveDel.close(); //close I/O
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
                                        System.out.println(">>>Maaf, File Tidak Ditemukan");
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
                                        System.out.println(">>>Maaf, File Tidak Ditemukan");
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
                                        String topik = input.next(); 
                                    System.out.print("Deskripsi Berita: "); 
                                        String deskripsi = input.next(); 
                                    System.out.print("Tanggal Kirim: "); 
                                        String tanggal_kirim = input.next(); 
                                    
                                    listBerita.clear(); //hapus list utk menghindari data bertindih
                                    listBerita.add(new Berita(topik, deskripsi, tanggal_kirim));
                                    for (Berita list : listBerita) {
                                        try{
                                            File data = new File ("Data SAD/Berita.txt"); //Objek file yang akan dibuka
                                            PrintWriter save = new PrintWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                            save.println(list.toString()); //save data ke txt dalam format toString
                                            save.close(); //close I/O
                                            System.out.println(">>>Tambah Data Berhasil");
                                        }
                                        catch(IOException e){
                                            System.out.println(">>>Maaf, File Tidak Ditemukan");
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
                                                        String topikUpd = input.next(); 
                                                    System.out.print("Deskripsi Berita: "); 
                                                        String deskripsiUpd = input.next(); 
                                                    System.out.print("Tanggal Kirim: "); 
                                                        String tanggal_kirimUpd = input.next(); 
                                                    
                                                    listBerita.clear();
                                                    listBerita.add( new Berita(topikUpd, deskripsiUpd, tanggal_kirimUpd));
                                                    
                                                    PrintWriter save = new PrintWriter (new FileWriter(data, false)); //false, berarti data file lama ditindih
                                                    save.close(); //close I/O
                                                    
                                                    for (int j=0; j<size; j++){
                                                        if(j+1 == idUpd){
                                                            for (Berita list : listBerita){
                                                                PrintWriter saveUpd = new PrintWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                                saveUpd.println(list.toString()); //save data ke txt dalam format toString
                                                                saveUpd.close(); //close I/O
                                                            }
                                                        }else{
                                                            PrintWriter saveDel = new PrintWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                            saveDel.println(listBeritaTxt.get(j)); //save data ke txt dalam format toString
                                                            saveDel.close(); //close I/O
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
                                        System.out.println(">>>Maaf, File Tidak Ditemukan");
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
                                                    PrintWriter save = new PrintWriter (new FileWriter(data, false)); //false, berarti data file lama ditimpa
                                                    save.close(); //close I/O
                                                    
                                                    for (int j=0; j<size; j++){
                                                        if(j+1 == idDelete){

                                                        }else{
                                                            PrintWriter saveDel = new PrintWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                            saveDel.println(listBeritaTxt.get(j)); //save data ke txt dalam format toString
                                                            saveDel.close(); //close I/O
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
                                        System.out.println(">>>Maaf, File Tidak Ditemukan");
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
                                        System.out.println(">>>Maaf, File Tidak Ditemukan");
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
                                        String topik = input.next(); 
                                    System.out.print("Deskripsi Saran/Komentar: "); 
                                        String saran = input.next(); 
                                    System.out.print("Tanggal Pembuatan: "); 
                                        String tanggal = input.next(); 
                                    
                                    listSaran.clear(); //hapus list utk menghindari data bertindih
                                    listSaran.add(new Saran(topik, saran, tanggal));
                                    for (Saran list : listSaran) {
                                        try{
                                            File data = new File ("Data SAD/Saran.txt"); //Objek file yang akan dibuka
                                            PrintWriter save = new PrintWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                            save.println(list.toString()); //save data ke txt dalam format toString
                                            save.close(); //close I/O
                                            System.out.println(">>>Tambah Saran Berhasil");
                                        }
                                        catch(IOException e){
                                            System.out.println(">>>Maaf, File Tidak Ditemukan");
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
                                                        String topikUpd = input.next(); 
                                                    System.out.print("Deskripsi Saran/Komentar: "); 
                                                        String saranUpd = input.next();  
                                                    System.out.print("Tanggal Pembuatan: "); 
                                                        String tanggalUpd = input.next();  
                                                    
                                                    listSaran.clear();
                                                    listSaran.add( new Saran(topikUpd, saranUpd, tanggalUpd));
                                                    
                                                    PrintWriter save = new PrintWriter (new FileWriter(data, false)); //false, berarti data file lama ditindih
                                                    save.close(); //close I/O
                                                    
                                                    for (int j=0; j<size; j++){
                                                        if(j+1 == idUpd){
                                                            for (Saran list : listSaran){
                                                                PrintWriter saveUpd = new PrintWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                                saveUpd.println(list.toString()); //save data ke txt dalam format toString
                                                                saveUpd.close(); //close I/O
                                                            }
                                                        }else{
                                                            PrintWriter saveDel = new PrintWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                            saveDel.println(listSaranTxt.get(j)); //save data ke txt dalam format toString
                                                            saveDel.close(); //close I/O
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
                                        System.out.println(">>>Maaf, File Tidak Ditemukan");
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
                                                    PrintWriter save = new PrintWriter (new FileWriter(data, false)); //false, berarti data file lama ditimpa
                                                    save.close(); //close I/O
                                                    
                                                    for (int j=0; j<size; j++){
                                                        if(j+1 == idDelete){

                                                        }else{
                                                            PrintWriter saveDel = new PrintWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                            saveDel.println(listSaranTxt.get(j)); //save data ke txt dalam format toString
                                                            saveDel.close(); //close I/O
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
                                        System.out.println(">>>Maaf, File Tidak Ditemukan");
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
                                        System.out.println(">>>Maaf, File Tidak Ditemukan");
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
                            
                            switch(menuTambahan){
                                case 1: //create new data
                                    System.out.println("\nMasukkan Data Member: ");
                                    System.out.print("Nama: "); 
                                        String nama = input.next(); 
                                    System.out.print("Gender: "); 
                                        String gender = input.next(); 
                                    System.out.print("Alamat: "); 
                                        String alamat = input.next(); 
                                    System.out.print("Username: "); 
                                        String username = input.next(); 
                                    System.out.print("Password: "); 
                                        String password = input.next();
                                    
                                    listMember.clear(); //hapus list utk menghindari data bertindih
                                    listMember.add(new Member(nama, gender, alamat, username, password));
                                    for (Member list : listMember) {
                                        try{
                                            File data = new File ("Data SAD/Member.txt"); //Objek file yang akan dibuka
                                            PrintWriter save = new PrintWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                            save.println(list.toString()); //save data ke txt dalam format toString
                                            save.close(); //close I/O
                                            System.out.println(">>>Tambah Data Berhasil");
                                        }
                                        catch(IOException e){
                                            System.out.println(">>>Maaf, File Tidak Ditemukan");
                                        }
                                    }
                                    listMember.clear();
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
                                                    String namaUpd = input.next(); 
                                                    System.out.print("Gender: "); 
                                                    String genderUpd = input.next(); 
                                                    System.out.print("Alamat: "); 
                                                    String alamatUpd = input.next(); 
                                                    System.out.print("Username: "); 
                                                    String usernameUpd = input.next(); 
                                                    System.out.print("Password: "); 
                                                    String passwordUpd = input.next();
                                                    
                                                    listMember.clear();
                                                    listMember.add( new Member(namaUpd, genderUpd, alamatUpd, usernameUpd, passwordUpd));
                                                    
                                                    PrintWriter save = new PrintWriter (new FileWriter(data, false)); //false, berarti data file lama ditindih
                                                    save.close(); //close I/O
                                                    
                                                    for (int j=0; j<size; j++){
                                                        if(j+1 == idUpd){
                                                            for (Member list : listMember){
                                                                PrintWriter saveUpd = new PrintWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                                saveUpd.println(list.toString()); //save data ke txt dalam format toString
                                                                saveUpd.close(); //close I/O
                                                            }
                                                        }else{
                                                            PrintWriter saveDel = new PrintWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                            saveDel.println(listMemberTxt.get(j)); //save data ke txt dalam format toString
                                                            saveDel.close(); //close I/O
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
                                        System.out.println(">>>Maaf, File Tidak Ditemukan");
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
                                                    PrintWriter save = new PrintWriter (new FileWriter(data, false)); //false, berarti data file lama ditimpa
                                                    save.close(); //close I/O
                                                    
                                                    for (int j=0; j<size; j++){
                                                        if(j+1 == idDelete){

                                                        }else{
                                                            PrintWriter saveDel = new PrintWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan
                                                            saveDel.println(listMemberTxt.get(j)); //save data ke txt dalam format toString
                                                            saveDel.close(); //close I/O
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
                                        System.out.println(">>>Maaf, File Tidak Ditemukan");
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
                                        System.out.println(">>>Maaf, File Tidak Ditemukan");
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
            System.out.println("Login as member");
        }

     
   
     
     
     


    }
    catch(InputMismatchException e){
        System.out.println(">>Maaf, inputan anda salah--");
    } 
    System.out.println(""); 
    System.out.println("---Terimakasih telah datang berkunjung.---"); 
 }
}


