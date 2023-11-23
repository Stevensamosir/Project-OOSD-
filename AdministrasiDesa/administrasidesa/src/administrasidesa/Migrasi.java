/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package administrasidesa;

/**
 *
 * @author ITD_Stu
 */
public class Migrasi <T> extends Surat{
    private T nik, alamat_skrg, alamat_tujuan, jumlah;

    public Migrasi(T nik, T alamat_skrg, T alamat_tujuan, T jumlah, StatusRequest sr, T requester) {
        super.setSr(sr);
        super.setRequester(requester);
        this.nik = nik;
        this.alamat_skrg = alamat_skrg;
        this.alamat_tujuan = alamat_tujuan;
        this.jumlah = jumlah;
    }

    @Override
    public String toString() {
        return "NIK: " + nik                
                + ", Alamat Sekarang: " + alamat_skrg
                + ", Alamat Tujuan: " + alamat_tujuan
                + ", Jumlah: " + jumlah
                + ", Status: " +super.getSr()
                + ", Request by: " +super.getRequester();  
    
    }
    
    public void cetak(){
        System.out.println(""
                + "                                 Surat Keterangan Pindah Penduduk\n" 
                + "                                ==================================\n\n"
                + nik + "\n"
                + "Orang yang namanya tersebut diatas sebelumnya berdomisili di: \n"
                + alamat_skrg
                + "Pindah ke: " + alamat_tujuan +"\n"
                + "Pindah dengan diikuti oleh " + jumlah + " orang"
                + "\n\n"
                + "                                                                                 .....................\n"
                + "                                                                                  Kepala Desa Hutagaol\n\n\n"
                + "                                                                              (..........................)");
    }
}
