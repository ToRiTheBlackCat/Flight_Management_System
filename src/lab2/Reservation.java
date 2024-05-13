/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.util.ArrayList;
//import java.util.Arrays;

/**
 *
 * @author PC
 */
public class Reservation {
    private String resId;
    private Flight selectedFlight;
    ArrayList<Passenger> travellers = new ArrayList<Passenger>();
    private int gate;
    private int status;
    private int quantity;
    private int[] selectedSeat;

    public Reservation() {
    }

    public Reservation(String resId, Flight selectedFlight, int gate, int status,int quantity, int[] selectedSeat) {
        this.resId = resId;
        this.selectedFlight = selectedFlight;
        this.gate = gate;
        this.status = status;
        this.quantity = quantity;
        this.selectedSeat = selectedSeat;
    }
    @Override
    public String toString (){
        return "Reservation ID: " + resId + "\nFlight Info:"+ selectedFlight +  "\nStatus:" + status ;
    }
    public String getResId() {
        return resId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public void setResId(String resId) {
        this.resId = resId;
    }

    public Flight getSelectedFlight() {
        return selectedFlight;
    }

    public void setSelectedFlight(Flight selectedFlight) {
        this.selectedFlight = selectedFlight;
    }

    public ArrayList<Passenger> getTravellers() {
        return travellers;
    }

    public void setTravellers(ArrayList<Passenger> travellers) {
        this.travellers = travellers;
    }

    public int getGate() {
        return gate;
    }

    public void setGate(int gate) {
        this.gate = gate;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int[] getSelectedSeat() {
        return selectedSeat;
    }

    public void setSelectedSeat(int[] selectedSeat) {
        this.selectedSeat = selectedSeat;
    }
    public void addTravellers( Passenger passenger){
        travellers.add(passenger);
    }
}
