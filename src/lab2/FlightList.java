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
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class FlightList extends ArrayList<Flight> {

    Scanner sc = new Scanner(System.in);
    DateFormat dateFormat = new SimpleDateFormat("HH:mm-dd/MM/yyyy");
    // CHECK FLIGHT CODE CO TRUNG?
    public int checkDupliCode(String code) {
        for (Flight x : this) {
            if (x.getFlightNumber().equals(code)) {
                return 1;
            }
        }
        return -1;
    }

    // Case 1
    public void addNewFlight() {
        String flightNumber;
        String departureCity;
        String destinationCity;
        Date departureTime = null;
        Date arrivalTime = null;
        int gate = 0;
        boolean valid = false;
        String choice;
        System.out.println("\t=== New Flight ===");
        do {
            // FlightNumber
            do {
                System.out.print("Enter the flight code (F0000): ");
                flightNumber = sc.nextLine().toUpperCase();
                valid = true;
                if (flightNumber.matches("^F\\d{4}")) {
                    if (checkDupliCode(flightNumber) == 1) {
                        System.out.println("This code already exist!");
                        valid = false;
                    }
                } else {
                    System.out.println("Invalid code! Try again");
                    valid = false;
                }
            } while (checkDupliCode(flightNumber) == 1 || valid == false);

            // DepartureCity
            System.out.print("Enter the departure city: ");
            departureCity = sc.nextLine().toUpperCase();

            // DesinationCity
            System.out.print("Enter the destination city: ");
            destinationCity = sc.nextLine().toUpperCase();

            // DepartureTime
            System.out.print("Enter the departure time(Hour:Minute/Day/Month/Year): ");
            do {
                try {
                    departureTime = dateFormat.parse(sc.nextLine());
                    valid = true;
                } catch (ParseException ex) {
                    System.out.println("Invalid Time!");
                    valid = false;
                }
            } while (valid == false);

            // DURATION
            int hour = 0, minute = 0;
            System.out.println("DURATION");
            do {
                try {
                    System.out.print("Enter hour: ");
                    hour = Integer.parseInt(sc.nextLine());
                    valid = true;
                    if (hour < 1 || hour > 24) {
                        valid = false;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid");
                    valid = false;
                }
            } while (valid == false);
            do {
                try {
                    System.out.print("Enter minute: ");
                    minute = Integer.parseInt(sc.nextLine());
                    valid = true;
                    if (minute < 0 || minute > 59) {
                        valid = false;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid");
                    valid = false;
                }
            } while (valid == false);
            Calendar calen = Calendar.getInstance();
            calen.setTime(departureTime);
            calen.add(Calendar.HOUR, hour);
            calen.add(Calendar.MINUTE, minute);
            // ARRIVALTIME
            arrivalTime = calen.getTime();
            System.out.println("Arrival Time: " + arrivalTime);
            //GATE
            do {
                try {
                    System.out.print("Enter gate (1-10): ");
                    gate = Integer.parseInt(sc.nextLine());
                    valid = true;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid. Try again");
                    valid = false;
                }
            } while (valid == false || gate < 1 || gate > 10);
            
            Flight f = new Flight(flightNumber, departureCity, destinationCity, departureTime, arrivalTime, gate,null);
            this.add(f);
            System.out.println(f.toString());
            
            do {
                System.out.print("Add more flight? (Y/N): ");
                choice = sc.nextLine().toUpperCase();
                if (choice.matches("Y") || choice.matches("N")) {
                    valid = true;
                } else {
                    System.out.println("Invalid choice!");
                    valid = false;
                }
            } while (valid == false);
        } while (choice.equals("Y"));
    }

    // Case 2
    public void searchFlight() {
        String deparLoca = null;
        String ArriLoca = null;
        String c;
        boolean valid = false;
        Date date = null;
        do {
            do {
                try {
                    System.out.print("Enter the Departure Location: ");
                    deparLoca = sc.nextLine().toUpperCase();
                    valid = true;
                } catch (Exception e) {
                    System.out.println("Invalid");
                    valid = false;
                }
            } while (valid == false);
            do {
                try {
                    System.out.print("Enter the Arrival Location: ");
                    ArriLoca = sc.nextLine().toUpperCase();
                    valid = true;
                } catch (Exception e) {
                    System.out.println("Invalid");
                    valid = false;
                }
            } while (valid == false);
            System.out.println("===============");
            do {
                System.out.println("1. Search flight by date");
                System.out.println("2. Search flight without date");
                System.out.print("Your choice(1/2): ");
                c = sc.nextLine();
                System.out.println("===============");
            } while (!(c.equals("1") || c.equals("2")));

            if (c.equals("1")) {

                System.out.print("Enter the Date(Hour:Minute-Day/Month/Year): ");
                try {
                    date = dateFormat.parse(sc.nextLine());
                    valid = true;
                } catch (ParseException e) {
                    System.out.println("Invalid");
                    valid = false;
                }

                if (valid == true) {
                    System.out.println("== Flight found ==");
                    valid = false;
                    for (Flight f : this) {
                        if ((f.getDepartureCity().equals(deparLoca)) && (f.getDestinationCity().equals(ArriLoca))) {
                            if (f.getDepartureTime().compareTo(date) == 0) {
                                System.out.println(f.toString());
                                valid = true;
                            } else {
                                valid = false;
                            }
                        }
                    }
                    if (valid == false) {
                        System.out.println("No flight found");
                    }
                }
            } else if (c.equals("2")) {
                System.out.println("Similar flight");
                valid = false;
                for (Flight f : this) {
                    if ((f.getDepartureCity().equals(deparLoca)) && (f.getDestinationCity().equals(ArriLoca))) {
                        System.out.println(f.toString());
                        valid = true;
                    }
                }
                if (valid == false) {
                    System.out.println("No flight found");
                }
            }
        } while (valid == false);
    }
    
    
  
}
