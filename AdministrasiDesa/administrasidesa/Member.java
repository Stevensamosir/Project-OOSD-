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
public class Member <T> extends User {
    private T nama, email, gender, alamat;

    public Member(T nama, T email, T gender, T alamat, T username, T password) {
        super.setUsername(username);
        super.setPassword(password);
        this.nama = nama;
        this.email = email;
        this.gender = gender;
        this.alamat = alamat;
    }

    Member(String nama, String gender, String alamat, String username, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String toString() {
        return "Nama: " + nama 
                + ", Email: " + email
                + ", Gender: " + gender 
                + ", Alamat: " + alamat 
                + ", Username: " + super.getUsername()
                + ", Password: " + super.getUsername();
    }

    
}
