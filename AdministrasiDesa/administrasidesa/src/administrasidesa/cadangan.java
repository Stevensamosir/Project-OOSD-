package administrasidesa;

//impor lib yang dibutuhkan 
import java.io.*; 
import java.util.Scanner; 
 
//deklarasi class utama 
public class cadangan{ 
  public static void menuAwal(){
      System.out.println("-- SELAMAT DATANG --");
      System.out.println("1. Login Sebagai Admin");
      System.out.println("2. Login Sebagai Member");
      System.out.println("3. Daftar");
      System.out.println("0. Berhenti");
  }    
  public static void menuUtamaAdmin(){
      System.out.println("=== SELAMAT DATANG DI SISTEM INFORMASI ADMINISTRASI DESA ===");
      System.out.println("1. Data Surat");
      System.out.println("2. Data Penduduk");
      System.out.println("3. Berita");
      System.out.println("4. Saran/Komentar");
      System.out.println("5. Data Member");
      System.out.println("0. Keluar");
      
      System.out.println("Masukkan pilihan anda : ");
  }  
  public static void menuUtamaMember(){
      System.out.println("=== SELAMAT DATANG DI SISTEM INFORMASI ADMINISTRASI DESA ===");
      System.out.println("1. Layanan Surat");
      System.out.println("2. Berita");
      System.out.println("3. Saran/Komentar");
      System.out.println("0. Keluar");
  }  
  public static void layananSurat(){
      System.out.println("");
      System.out.println("1. Surat Pengantar Pengurusan KK");
      System.out.println("2. Surat Pengantar Pengurusan KTP");
      System.out.println("3. Surat Keterangan Domisili");
      System.out.println("4. Surat Keterangan Tidak Mampu");
      System.out.println("5. Surat Keterangan Pindah");
      System.out.println("0. Kembali");
  }  
  
 public static void main(String[] args){ 
    //deklarasi variablel 
    int menuAwal, menuUtama; 
    int choice; 
    String read; 
    choice = 0; 

    String usernameAdmin = "admin", passwordAdmin = "admin";
    String usernameMember = "member", passwordMember = "member";

    BufferedWriter outs; 
    BufferedReader ins; 
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
    Scanner input = new Scanner(System.in); 



    //masuk diwal
    menuAwal();
    menuAwal = input.nextInt();

    while(menuAwal!=0){
        if(menuAwal == 1){
            System.out.println(""); 
            System.out.print("Masukkan username: "); 
            String username = input.next(); 
            System.out.print("Masukkan password: "); 
            String password = input.next();  

            if(username.equals(usernameAdmin) && password.equals(passwordAdmin)){
                System.out.println("Berhasil masuk");
                int admin = 1;
                break;
            }
            else{
                System.out.println("Gagal masuk");
                int admin = 0;
            } 
        }
        else if(menuAwal == 2){
            System.out.println(""); 
            System.out.print("Masukkan username: "); 
            String username = input.next(); 
            System.out.print("Masukkan password: "); 
            String password = input.next();  

            if(username.equals(usernameMember) && password.equals(passwordMember)){
                System.out.println("Berhasil masuk");
                int member = 1;
                break;
            }
            else{
                System.out.println("Gagal masuk");
                int member = 0;
            } 
        }
        else if(menuAwal == 3){

            try{ 
                System.out.println(""); 
                System.out.println("Masukkan data diri anda : ");
                System.out.print("Nama: "); 
                String nama = br.readLine(); 
                System.out.print("Gender: "); 
                String gender = br.readLine(); 
                System.out.print("Alamat: "); 
                String alamat = br.readLine(); 
                System.out.print("Username: "); 
                String username = br.readLine(); 
                System.out.print("Password: "); 
                String password = br.readLine();

                try{ 
                    outs = new BufferedWriter(new FileWriter("E:\\IT Del\\KULIAH\\Sem 3\\"
                            + "IF421312 OOSD\\PROYEK OOSD\\"
                            + "AdministrasiDesa\\src\\administrasidesa\\Member.txt",true)); 

                    Member m1 = new Member(nama, gender, alamat, username, password);

                    outs.write(m1.toString()); 
                    outs.newLine(); 
                    outs.close(); 
                }catch(IOException e){ 
                  System.out.println("There was a problem found:  " + e); 
                } 
            }
            catch(IOException e){ 
                System.out.println("Terjadi sebuah kesalahan : " + e); 
            } 

        } 
    }








     
    }
  
 }


