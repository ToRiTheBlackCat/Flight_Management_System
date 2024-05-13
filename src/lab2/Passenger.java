/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author PC
 */
public class Passenger {
    private String passId;
    private String passName;
    private Date birthday;
    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    public Passenger() {
    }

    public Passenger(String passId, String passName, Date birthday) {
        this.passId = passId;
        this.passName = passName;
        this.birthday = birthday;
    }
    
    @Override
    public String toString(){
        return passId + "\t" + passName + "\t" + dateFormat.format(birthday) ;
    }

    public String getPassId() {
        return passId;
    }

    public void setPassId(String passId) {
        this.passId = passId;
    }

    public String getPassName() {
        return passName;
    }

    public void setPassName(String passName) {
        this.passName = passName;
    }

    public String getBirthday() {
        return dateFormat.format(birthday);
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

}
