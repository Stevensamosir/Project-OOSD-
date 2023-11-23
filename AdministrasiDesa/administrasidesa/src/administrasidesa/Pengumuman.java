package administrasidesa;

//impor lib yang dibutuhkan 
import java.io.*; 
import java.util.*;
 
//deklarasi class utama 
public class Pengumuman{ 
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
    BufferedWriter save, saveUpd, saveDel; 
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
                String username = scan.readLine(); 
                System.out.print("Masukkan password: "); 
                String password = scan.readLine();  

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
            else if(menuAwal == 3){
                System.out.println(""); 
                System.out.println("Masukkan data diri anda : ");
                System.out.print("Nama: "); 
                String nama = scan.readLine(); 
                System.out.print("Gender: "); 
                String gender = scan.readLine(); 
                System.out.print("Alamat: "); 
                String alamat = scan.readLine(); 
                System.out.print("Username: "); 
                String username = scan.readLine(); 
                System.out.print("Password: "); 
                String password = scan.readLine();

                try{ 
                    File data = new File ("Data SAD/abc.txt"); //membuat file txt didalam folder
                    save = new BufferedWriter (new FileWriter(data, true)); //true, berarti data file lama ditambahkan

                    Member dataMember = new Member(nama, gender, alamat, username, password);

                    save.write(dataMember.toString()); //save data ke txt dalam format toString
                    save.newLine();              save.close(); //close I/O
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
                }
            }
            while (menuUtama != 0);
        }
        
    }
    catch(InputMismatchException e){
        System.out.println(">>Maaf, Inputan Anda Salah--");
    } 
    catch(IOException e){
        System.out.println(">>>Maaf, Terjadi Kesalahan  Pada File");
    }
    System.out.println(""); 
    System.out.println("---Terimakasih Telah Datang Berkunjung---"); 
 }
}


