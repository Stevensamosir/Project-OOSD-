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
public class KTP <T> extends Surat{
    private T nik;

    public KTP(T nik, StatusRequest sr, T requester) {
        super.setSr(sr);
        super.setRequester(requester);
        this.nik = nik;
    }

    @Override
    public String toString() {
        return "NIK: " + nik                
                + ", Status: " +super.getSr()
                + ", Request by: " +super.getRequester();
    }
    
    
    public void cetak(){
        System.out.println(""
                + "                                 Surat Keterangan Pengurusan KTP\n" 
                + "                                ================================\n\n"
                + "Yang bertanda tangan dibawah ini, kepala desa Hutagaol, Kecamatan Sigumpar, Kabupaten Toba Samosir.\n"
                + "Dengan ini menerangkan bahwa:\n"
                + nik + "\n"
                + "Orang yang namanya tersebut diatas adalah benar warga kami. Surat keterangan ini dibuat sebagai kelengkapan \n"
                + "dalam pengurusan KTP. \n"
                + "Demikian surat ini dibuat, untuk dapat dipergunakan sebagaimana mestinya.\n\n"
                + "                                                                                 .....................\n"
                + "                                                                                  Kepala Desa Hutagaol\n\n\n"
                + "                                                                              (..........................)");
    }
}
