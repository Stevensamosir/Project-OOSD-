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
public class Penduduk <T>{
    private T nik, no_kk, nama, gender, tempat_lahir, tanggal_lahir, gol_darah, agama, pekerjaan, nama_ayah, nama_ibu;

    public Penduduk(T nik, T no_kk, T nama, T gender, T tempat_lahir, T tanggal_lahir, T gol_darah, T agama, T pekerjaan, T nama_ayah, T nama_ibu) {
        this.nik = nik;
        this.no_kk = no_kk;
        this.nama = nama;
        this.gender = gender;
        this.tempat_lahir = tempat_lahir;
        this.tanggal_lahir = tanggal_lahir;
        this.gol_darah = gol_darah;
        this.agama = agama;
        this.pekerjaan = pekerjaan;
        this.nama_ayah = nama_ayah;
        this.nama_ibu = nama_ibu;
    }

    @Override
    public String toString() {
        return "NIK: " + nik 
                + ", No. KK: " + no_kk 
                + ", Nama: " + nama 
                + ", Gender: " + gender 
                + ", Tempat Lahir: " + tempat_lahir 
                + ", Tanggal Lahir: " + tanggal_lahir 
                + ", Golongan Darah: " + gol_darah 
                + ", Agama: " + agama 
                + ", Pekerjaan: " + pekerjaan 
                + ", Nama Ayah: " + nama_ayah 
                + ", Nama Ibu: " + nama_ibu ;
    }
    
    
}
