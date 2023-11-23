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
public class Admin <T> extends User{

    public Admin(T username, T password) {
        super.setUsername(username);
        super.setPassword(password);
    }

    @Override
    public String toString() {
        return "Username: " + super.getUsername()
                + ", Password : " + super.getPassword();
    }
    
}
