/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class Schedule{

    private ArrayList<Staff> pilots;
    private ArrayList<Staff> flightAttendants;
    private ArrayList<Staff> groundStaffs;
    public Schedule() {
    }

    public Schedule(ArrayList<Staff> pilots, ArrayList<Staff> flightAttendants, ArrayList<Staff> groundStaffs) {
        this.pilots = pilots;
        this.flightAttendants = flightAttendants;
        this.groundStaffs = groundStaffs;
    }
    
    public String toString(){
        return pilots +"\n" + flightAttendants +"\n" + groundStaffs +"\n" ;
    }
   
    public ArrayList<Staff> getPilots() {
        return pilots;
    }

    public ArrayList<Staff> getFlightAttendants() {
        return flightAttendants;
    }


    public ArrayList<Staff> getGroundStaffs() {
        return groundStaffs;
    }

    public void setPilots(ArrayList<Staff> pilots) {
        this.pilots = pilots;
    }

    public void setFlightAttendants(ArrayList<Staff> flightAttendants) {
        this.flightAttendants = flightAttendants;
    }

    public void setGroundStaffs(ArrayList<Staff> groundStaffs) {
        this.groundStaffs = groundStaffs;
    }
    
}
