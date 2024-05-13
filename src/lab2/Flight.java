/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.util.Date;

/**
 *
 * @author PC
 */
public class Flight implements Comparable {

    private String flightNumber;
    private String departureCity;
    private String destinationCity;
    private Date departureTime;
    private Date arrivalTime;
    private int gate;
    private int[] seat;
    Schedule schdule;
    public Flight() {

    }

    public Flight(String flightNumber, String departureCity, String destinationCity, Date departureTime, Date arrivalTime, int gate, int[] seat) {
        this.flightNumber = flightNumber;
        this.departureCity = departureCity;
        this.destinationCity = destinationCity;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.gate = gate;
        
        seat = new int[50];
        for (int i = 0; i < 50; i++) {
            seat[i] = -1;

        }
        this.seat = seat;
    }


    @Override
    public String toString() {
        return (getFlightNumber() + "\t" + getDepartureCity() + "\t" + getDestinationCity() + "\t" + getDepartureTime() + "\t" + getArrivalTime() );

    }

    public int getGate() {
        return gate;
    }

    public void setGate(int gate) {
        this.gate = gate;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Date departureTime) {
        this.departureTime = departureTime;
    }

    public Date getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(Date arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public Schedule getSchdule() {
        return schdule;
    }

    public void setSchdule(Schedule schdule) {
        this.schdule = schdule;
    }
    
    public int[] getSeat() {
        return seat;
    }

    public void setSeat(int[] seat) {
        this.seat = seat;
    }
// IN RA TRANG THAI CUA SEAT
public String AvailableSeat(){
    StringBuilder avail = new StringBuilder();
    int count=0;
    for( int i=0; i<seat.length; i++){
        if(count == 2){
            avail.append("\n");
            count = 0;
        }
        count++;
        if(seat[i] == -1){
            avail.append(i+1).append("(Available) |");
        } else {
            avail.append(i+1).append("(Booked)  |");
        }
    }
    return avail.toString();
}
// SET TRANG THAI CUA SEAT
    public boolean bookedSeat(int n) {
        if (n >= 1 && n < seat.length && seat[n - 1] == -1) {
            seat[n - 1] = 1;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public int compareTo(Object o) {
        if( this.getDepartureTime().after(((Flight)o).getDepartureTime())){
            return -1;
        } else {
        return 1;
    }
    }
}
