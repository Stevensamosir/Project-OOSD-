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
public class Domisili <T> extends Surat{
    private T nik;

    public Domisili(T tujuan, T nik, StatusRequest sr, T requester) {
        super.setTujuan(tujuan);
        super.setSr(sr);
        super.setRequester(requester);
        this.nik = nik;
    }

    public T getNik() {
        return nik;
    }
    
    @Override
    public String toString() {
        return "NIK: " + nik                
                + ", Tujuan: " +super.getTujuan()
                + ", Status: " +super.getSr()
                + ", Request by: " +super.getRequester();
    }
    
    
    public void cetak(){
        System.out.println(""
                + "                                   Surat Keterangan Domisili\n" 
                + "                                ===============================\n\n"
                + "Yang bertanda tangan dibawah ini, kepala desa Hutagaol, Kecamatan Sigumpar, Kabupaten Toba Samosir.\n"
                + "Dengan ini menerangkan bahwa:\n"
                + nik + "\n"
                + "Orang yang namanya tersebut diatas adalah benar warga kami dan berdomisili di Desa Hutagaol, Kecamatan\n"
                + "Sigumpar, Kabupaten Toba Samosir. Surat keterangan ini dibuat sebagai kelengkapan dalam pengurusan: \n"
                + super.getTujuan()+ "\n"
                + "Demikian surat ini dibuat, untuk dapat dipergunakan sebagaimana mestinya.\n\n"
                + "                                                                                 .....................\n"
                + "                                                                                  Kepala Desa Hutagaol\n\n\n"
                + "                                                                              (..........................)");
    }
}
