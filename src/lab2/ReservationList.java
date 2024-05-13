/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class ReservationList extends ArrayList<Reservation> {

    DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    FlightList fl = new FlightList();
    Reservation res;
    Scanner sc = new Scanner(System.in);
    Flight passengerFlight;

    public ReservationList(FlightList flightList) {
        this.fl = flightList;
    }

    // CASE 2
    public void makeReservation() {
        String Passname, Passid;
        Date birthday = null;
        boolean valid = false;
        int quantity = 0;

        fl.searchFlight();
        System.out.print("Enter the flight number you want: ");
        do {
            String fligCode = sc.nextLine().toUpperCase();
            System.out.println("\t\t\t======= FLIGHT FOUND =======");
            for (Flight f : fl) {
                if (f.getFlightNumber().equals(fligCode)) {
                    System.out.println(f.toString());
                    passengerFlight = f;
                    valid = true;
                    break;
                }
            }
            if (valid == false) {
                System.out.println("No suitable flight. Try again: ");

            }
        } while (valid == false);
        //NUM OF PASSENGER
        do {
            System.out.print("Number of passenger: ");
            try {
                quantity = Integer.parseInt(sc.nextLine());
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid. Try again");
                valid = false;
            }
        } while (valid == false);

        
        for( int i=0; i<quantity; i++){
            birthday = null;
        System.out.println("\t\t\t=== Passenger Information ===");
        //ID
        System.out.print("Enter your ID: ");
        Passid = sc.nextLine();
        //NAME
        System.out.print("Enter your name: ");
        Passname = sc.nextLine().toUpperCase();
        //BIRTHDAY
        do {
            System.out.print("Enter your birthday: ");
            try {
                birthday = dateFormat.parse(sc.nextLine());
                valid = true;
            } catch (ParseException ex) {
                System.out.println("Invalid date");
                valid = false;
            }
        } while (valid == false);
       
        Passenger p = new Passenger(Passid, Passname, birthday);
        System.out.println(p.toString());
        
        //RESERVATION
        String resID;
        Random random = new Random();
        System.out.println("\t\t\t===== RESERVATION =====");
        do {
            resID = "RE" + random.nextInt(1000);
            valid = true;
            for (Reservation re : this) {
                if (re.getResId().equals(resID)) {
                    valid = false;
                }
            }
        } while (valid == false);
        res = new Reservation(resID, passengerFlight, passengerFlight.getGate(), 0, quantity, null);
        //ADD PASSENGER TO RES
        res.addTravellers(p);
        
        this.add(res);
        System.out.println(res.toString());
        System.out.println(res.getTravellers());
        }
    }

    // CASE 3
    public void checkIn() {
        String resID;
        boolean valid = false;

        System.out.print("Enter your Reservation ID: ");
        resID = sc.nextLine().toUpperCase();
        for (Reservation x : this) {
            if (x.getResId().equals(resID)) {
                x.setStatus(1);
                System.out.println("RESERVATION INFORMATION ");
                System.out.println(x.toString());
                System.out.println(x.getTravellers());

                // BOOK SEATS
                //De chua seats tam cua passenger
                int[] temp = new int[1]; 
                int seat = 0;
                //Duyet Num Of Passenger
                    do {
                        System.out.println();
                        System.out.println(x.getSelectedFlight().AvailableSeat());
                        do {
                            System.out.print("Choose your seat(1-50):");
                            try {
                                seat = Integer.parseInt(sc.nextLine());
                                valid = true;
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid. Try again");
                                valid = false;
                            }
                        } while (valid == false);
                        if (seat >= 1 && seat <= 50 && x.getSelectedFlight().bookedSeat(seat) == true) {
                            temp[0] = seat;
                            valid = true;
                        } else {
                            System.out.println("This seat has already booked! Try again");
                            valid = false;
                        }
                    } while (valid == false);
                x.setSelectedSeat(temp);
                valid = true;
                break;
            }
        }
        if (valid == false) {
            System.out.println("No reservation suitable");
            return;
        }
        // MAKE BOARDING PASSES
        System.out.println("=== BOARDING PASSES ===");
        for (Reservation x : this) {
            if (x.getResId().equals(resID)) {
                System.out.print("Passenger Information: " + x.getTravellers());
                System.out.print("\nFlight Information: " + x.getSelectedFlight());
                System.out.print("\nGate: " + passengerFlight.getGate());
                System.out.print("\nNumber of passenger: " + x.getQuantity());
                System.out.print("\nBooked seat(s): " + Arrays.toString(x.getSelectedSeat()));
            }
        }
    }

}
