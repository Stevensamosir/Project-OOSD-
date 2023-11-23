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
public abstract class Surat <T>{
    private T tujuan, requester;
    private StatusRequest sr;

    public T getTujuan() {
        return tujuan;
    }

    public void setTujuan(T tujuan) {
        this.tujuan = tujuan;
    }

    public T getRequester() {
        return requester;
    }

    public void setRequester(T requester) {
        this.requester = requester;
    }

    public StatusRequest getSr() {
        return sr;
    }

    public void setSr(StatusRequest sr) {
        this.sr = sr;
    }
    
    
}
