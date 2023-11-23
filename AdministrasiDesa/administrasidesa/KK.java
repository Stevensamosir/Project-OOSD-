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
public class KK <T> extends Surat{
    private T nikAyah, nikIbu, nikAnak;

    public KK(T nikAyah, T nikIbu, T nikAnak, StatusRequest sr, T requester) {
        super.setSr(sr);
        super.setRequester(requester);
        this.nikAyah = nikAyah;
        this.nikIbu = nikIbu;
        this.nikAnak = nikAnak;
    }

    @Override
    public String toString() {
        return "NIK Ayah: " + nikAyah 
                + ", NIK Ibu: " + nikIbu 
                + ", NIK Anak:" + nikAnak 
                + ", Status: " + super.getSr()
                + ", Request by: " + super.getRequester();
    }
    
    
}
