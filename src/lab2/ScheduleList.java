/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author PC
 */
public class ScheduleList extends ArrayList<Schedule> {

    DateFormat dateFormat = new SimpleDateFormat("HH:mm-dd/MM/yyyy");
    FlightList fl = new FlightList();
    ArrayList<Staff> staffList = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public ScheduleList(FlightList flightList) {
        this.fl = flightList;
    }

    public void addStaff() {
        staffList.add(new Staff("PL0001", "Anh", "Pilot"));
        staffList.add(new Staff("PL0002", "Binh", "Pilot"));
        staffList.add(new Staff("PL0003", "Tuan", "Pilot"));
        staffList.add(new Staff("PL0004", "Nhan", "Pilot"));
        staffList.add(new Staff("PL0005", "Phuoc", "Pilot"));
        staffList.add(new Staff("FA0001", "Ngan", "Flight Attendant"));
        staffList.add(new Staff("FA0002", "Hoa", "Flight Attendant"));
        staffList.add(new Staff("FA0003", "Nhu", "Flight Attendant"));
        staffList.add(new Staff("FA0004", "Ngoc", "Flight Attendant"));
        staffList.add(new Staff("FA0005", "Thoa", "Flight Attendant"));
        staffList.add(new Staff("GS0001", "Tien", "Ground Staff"));
        staffList.add(new Staff("GS0002", "Minh", "Ground Staff"));
        staffList.add(new Staff("GS0003", "Hung", "Ground Staff"));
        staffList.add(new Staff("GS0004", "Thanh", "Ground Staff"));
        staffList.add(new Staff("GS0005", "Trung", "Ground Staff"));
    }

    // CASE 4.1
    public void addSchedule() {
        String fligID;
        String choice, choice2;
        boolean valid = false;
        boolean busyFlag = false;
        do {
            do {
                busyFlag = false;
                Schedule schedule = new Schedule();
                ArrayList<Staff> temp1 = new ArrayList<>();  //Chua ds Pilot tam
                ArrayList<Staff> temp2 = new ArrayList<>(); //Chua ds FliAttend tam
                ArrayList<Staff> temp3 = new ArrayList<>(); //Chua ds GroStaff tam
                System.out.println("List of Flight");
                if (fl.isEmpty()) {
                    System.out.println("Empty FLight List");
                    return;
                }
                for (Flight f : fl) {
                    System.out.println(f.toString());
                }
                System.out.println("==================================");
                System.out.println("======== LIST OF STAFF(S) ========");
                System.out.println("==================================");

                System.out.println("LIST OF PILOT(S)");
                for (Staff staff : staffList) {
                    if (staff.getStaffRole().equals("Pilot")) {
                        System.out.println(staff.toString());
                    }
                }
                do {
                    String plID = null;
                    valid = false;
                    do {
                        do {
                            System.out.println("Enter pilot ID: ");
                            plID = sc.nextLine().toUpperCase();
                            if (plID.matches("^PL\\d{4}$")) {
                                valid = true;
                                //
                                for (Staff x : temp1) {
                                    if (x.getStaffId().equals(plID)) {
                                        System.out.println("Already choosed");
                                        valid = false;
                                    }
                                }
                                //
                            } else {
                                System.out.println("Invalid code");
                                valid = false;
                            }
                        } while (valid == false);
                        valid = false;
                        for (Staff staff : staffList) {
                            if (staff.getStaffRole().equals("Pilot") && staff.getStaffId().equals(plID)) {
                                temp1.add(staff);
                                valid = true;
                                break;
                            }
                        }
                        if (valid == false) {
                            System.out.println("No suitable pilot");
                        }
                    } while (valid == false);
                    do {
                        System.out.print("Add more pilot (Y/N):");
                        choice = sc.nextLine().toUpperCase();
                    } while (!(choice.equals("Y") || choice.equals("N")));
                    if (choice.equals("N")) {
                        schedule.setPilots(temp1);
                        break;
                    }
                } while (choice.equals("Y"));

                System.out.println("=================================");
                System.out.println("LIST OF FLIGHT ATTENDANT(S)");
                for (Staff staff : staffList) {
                    if (staff.getStaffRole().equals("Flight Attendant")) {
                        System.out.println(staff.toString());
                    }
                }
                do {
                    String flAttend = null;
                    valid = false;
                    do {
                        do {
                            System.out.println("Enter Flight Attendant ID: ");
                            flAttend = sc.nextLine().toUpperCase();
                            if (flAttend.matches("^FA\\d{4}$")) {
                                valid = true;
                                //
                                for (Staff x : temp2) {
                                    if (x.getStaffId().equals(flAttend)) {
                                        System.out.println("Already choosed");
                                        valid = false;
                                    }
                                }
                                //
                            } else {
                                System.out.println("Invalid code");
                                valid = false;
                            }
                        } while (valid == false);
                        valid = false;
                        for (Staff staff : staffList) {
                            if (staff.getStaffRole().equals("Flight Attendant") && staff.getStaffId().equals(flAttend)) {
                                temp2.add(staff);
                                valid = true;
                                break;
                            }
                        }
                        if (valid == false) {
                            System.out.println("No suitable Flight Attendant");
                        }
                    } while (valid == false);
                    do {
                        System.out.print("Add more Flight Attendant (Y/N):");
                        choice = sc.nextLine().toUpperCase();
                    } while (!(choice.equals("Y") || choice.equals("N")));
                    if (choice.equals("N")) {
                        schedule.setFlightAttendants(temp2);
                    }
                } while (choice.equals("Y"));

                System.out.println("=================================");
                System.out.println("LIST OF GROUND STAFF(S)");
                for (Staff staff : staffList) {
                    if (staff.getStaffRole().equals("Ground Staff")) {
                        System.out.println(staff.toString());
                    }
                }
                System.out.println("==================================");

                do {
                    String grouStaff = null;
                    valid = false;
                    do {
                        do {
                            System.out.println("Enter Ground Staff ID: ");
                            grouStaff = sc.nextLine().toUpperCase();
                            if (grouStaff.matches("^GS\\d{4}$")) {
                                valid = true;
                                //
                                for (Staff x : temp3) {
                                    if (x.getStaffId().equals(grouStaff)) {
                                        System.out.println("Already choosed");
                                        valid = false;
                                    }
                                }
                                //
                            } else {
                                System.out.println("Invalid code");
                                valid = false;
                            }
                        } while (valid == false);
                        valid = false;
                        for (Staff staff : staffList) {
                            if (staff.getStaffRole().equals("Ground Staff") && staff.getStaffId().equals(grouStaff)) {
                                temp3.add(staff);
                                valid = true;
                                break;
                            }
                        }
                        if (valid == false) {
                            System.out.println("No suitable ground staff");
                        }
                    } while (valid == false);
                    do {
                        System.out.print("Add more Ground Staff (Y/N):");
                        choice = sc.nextLine().toUpperCase();
                    } while (!(choice.equals("Y") || choice.equals("N")));
                    if (choice.equals("N")) {
                        schedule.setGroundStaffs(temp3);
                    }

                } while (choice.equals("Y"));

                System.out.println("List of Flight");
                if (fl.isEmpty()) {
                    System.out.println("Empty FLight List");
                    return;
                }
                for (Flight f : fl) {
                    System.out.println(f.toString());
                }

                do {
                    System.out.println("Enter the flight ID: ");
                    fligID = sc.nextLine().toUpperCase();

                    if (!fligID.matches("^F\\d{4}")) {
                        System.out.println("Invalid ID");
                        valid = false;
                        continue;
                    }

                    for (Flight f : fl) {
                        if (f.getFlightNumber().equals(fligID)) {
                            valid = true;
                            // CHECK STAFF IS BUSY ?

                            for (Staff s1 : temp1) {
                                if (isBusy(s1, f)) {
                                    busyFlag = true;
                                    break;
                                }
                            }
                            for (Staff s2 : temp2) {
                                if (isBusy(s2, f)) {
                                    busyFlag = true;
                                    break;
                                }
                            }
                            for (Staff s3 : temp3) {
                                if (isBusy(s3, f)) {
                                    busyFlag = true;
                                    break;
                                }
                            }

                            //
                            if (valid == true) {
                                f.setSchdule(schedule);
                                this.add(schedule);
                                break;
                            }
                        } else {
                            valid = false;
                        }
                    }
                    if (valid == false) {
                        System.out.println("No suitable flight");
                        break;
                    }
                    //RESET CAC TEMP NEU BUSYFLAG = true
                    if (busyFlag == true) {
                        temp1.clear();
                        temp2.clear();
                        temp3.clear();

                    }
                } while (valid == false);

            } while (busyFlag == true);

            System.out.println("Add more schedule (Y/N)");
            choice2 = sc.nextLine().toUpperCase();
            if (choice2.equals("N")) {
                System.out.println("\t\t================================");
                System.out.println("\t\t======= CREW ASSIGNMENTS =======");
                System.out.println("\t\t================================");
                for (Flight f : fl) {
                    System.out.println(f.toString());
                    if (!(f.getSchdule() == null)) {
                        System.out.println(f.getSchdule().toString());
                    } else {
                        System.out.println("Null");
                    }
                    System.out.println("==========================================================================");
                }

                return;
            }
        } while (choice2.equals("Y"));
    }

    // CHECK STAFF CO BUSY
    public boolean isBusy(Staff staff, Flight currentFlight) {
        for (Flight flight : fl) {
            if (!(flight.getFlightNumber().equals(currentFlight.getFlightNumber()))) {
                Schedule schedule = flight.getSchdule();
                if (schedule != null && currentFlight.getDepartureTime().after(flight.getDepartureTime()) && currentFlight.getDepartureTime().before(flight.getArrivalTime())) {
                    if (schedule.getPilots().contains(staff)
                            || schedule.getFlightAttendants().contains(staff)
                            || schedule.getGroundStaffs().contains(staff)) {
                        System.out.println(staff.getStaffId() + "\t" + staff.getStaffName() +"\t " + staff.getStaffRole() + ": is busy.\nTRY AGAIN");
                        return true;
                    }
                }
            }
        }
        return false;
    }

    
    // CHECK FOR CASE 6, NEU TRUNG fliNum THI KO ADD
    public int checkCode(String flightNumber) {
        for (Flight f : fl) {
            if (f.getFlightNumber().equals(flightNumber)) {
                return 1;
            }
        }
        return -1;
    }

    // CASE 6
    public void printFromFile(String fileName) {

        Flight flight = new Flight();
        boolean valid = false;
        Date departureTime = null;
        Date arrivalTime = null;
        int gate;
        DateFormat dateFormat = new SimpleDateFormat("HH:mm-dd/MM/yyyy");
        try {
            File f = new File(fileName);
            if (f.exists() && f.isFile()) {
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String details;
                while ((details = br.readLine()) != null) {
                    valid = true;
                    StringTokenizer stk = new StringTokenizer(details, "=");
                    String flightNumber = stk.nextToken().toUpperCase();
                    if (flightNumber.length() > 5) {
                        continue;
                    }
                    if (flightNumber.matches("^F\\d{4}")) {
                        valid = true;
                    } else {
                        System.out.println("Invalid Flight Number!");
                        valid = false;
                    }
                    String departureCity = stk.nextToken();
                    String destinationCity = stk.nextToken();
                    String temp1 = stk.nextToken();
                    try {
                        departureTime = dateFormat.parse(temp1);
                    } catch (ParseException e) {
                        valid = false;
                    }
                    String temp2 = stk.nextToken();
                    try {
                        arrivalTime = dateFormat.parse(temp2);
                        valid = true;
                        if (arrivalTime.before(departureTime)) {
                            valid = false;
                        }

                    } catch (ParseException e) {
                        valid = false;
                    }
                    try {
                        gate = Integer.parseInt(stk.nextToken());
                        if (gate < 1 || gate > 10) {
                            valid = false;
                        }
                    } catch (NumberFormatException ex) {
                        System.out.println("Invalid");
                        continue;
                    }
                    if (checkCode(flightNumber) == -1) {
                        flight = new Flight(flightNumber, departureCity, destinationCity, departureTime, arrivalTime, gate, null);
                        fl.add(flight);

                    } else if (checkCode(flightNumber) == 1) {
                        System.out.println(flightNumber + "(Duplicated Flight Number)");
                        valid = false;
                        continue;
                    }
                }
                br.close();
                fr.close();
            } else {
                return;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        // SORT DATE GIAM DAN
        Collections.sort(fl);
        System.out.println("=========================================================================================");
        for (Flight x : fl) {
            System.out.println(x.toString());
        }
        System.out.println("=========================================================================================");
    }

    // CASE 4.2
    public void Admin() {
        System.out.println("\t\t\t\t  == LIST OF FLIGHT ==");
        for (Flight fli : fl) {
            System.out.println("==============================================================================================");
            System.out.println("Flight Information: " + fli.toString());
            if (!(fli.getSchdule() == null)) {
                System.out.println("Crew Manager: " + fli.getSchdule().toString());
            } else {
                System.out.println("Null");
            }
        }
        update();
    }

    // CASE 4.2
    public void update() {
        String id, choice;
        do {
            System.out.println("Enter flight number: ");
            id = sc.nextLine().toUpperCase();
            if (!id.matches("^F\\d{4}")) {
                System.out.println("Invalid code");
            }
        } while (!id.matches("^F\\d{4}"));
        System.out.println("\t\t\t==== FLIGHT INFORMATION ====");
        for (Flight f : fl) {
            if (f.getFlightNumber().equals(id)) {
                System.out.println(f.toString());
                System.out.println("Gate: " + f.getGate());

                if (!(f.getSchdule() == null)) {
                    System.out.println(f.getSchdule().toString());
                } else {
                    System.out.println("Null");
                }
            }
        }
        String departCity, destiCity;
        Date departureTime = null, arrivalTime;
        int gate = 0;
        boolean valid = false;
        int c = 0;
        do {
            System.out.println("1.Update Flight Schedule");
            System.out.println("2.Update Crew Management");
            do {
                try {
                    System.out.println("Your choice (1/2): ");
                    c = Integer.parseInt(sc.nextLine());
                    valid = true;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid choice");
                    valid = false;
                }
            } while (valid == false);
            if (!(c == 1 || c == 2)) {
                System.out.println("Invalid choice!");
            }

            // UPDATE FLIGHT SCHEDULE
            if (c == 1) {
                for (Flight f : fl) {
                    if (f.getFlightNumber().equals(id)) {
                        System.out.println("Update Departure City: ");
                        departCity = sc.nextLine();
                        f.setDepartureCity(departCity);
                        System.out.println("Update Destination City: ");
                        destiCity = sc.nextLine();
                        f.setDestinationCity(destiCity);
                        System.out.print("Enter the update Departure time(Hour:Minute/Day/Month/Year): ");
                        do {
                            try {
                                departureTime = dateFormat.parse(sc.nextLine());
                                valid = true;
                            } catch (ParseException ex) {
                                System.out.println("Invalid Time!");
                                valid = false;
                            }
                        } while (valid == false);
                        f.setDepartureTime(departureTime);
                        int hour = 0, minute = 0;
                        System.out.println("DURATION");
                        do {
                            try {
                                System.out.print("Enter update hour: ");
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
                                System.out.print("Enter update minute: ");
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
                        arrivalTime = calen.getTime();
                        System.out.println("Arrival Time: " + arrivalTime);
                        f.setArrivalTime(arrivalTime);
                        do {
                            try {
                                System.out.print("Enter update gate (1-10): ");
                                gate = Integer.parseInt(sc.nextLine());
                                f.setGate(gate);
                                valid = true;
                            } catch (NumberFormatException e) {
                                System.out.println("Invalid. Try again");
                                valid = false;
                            }
                        } while (valid == false || gate < 1 || gate > 10);
                        System.out.println("\t\t\t UPDATE FLIGHT");
                        System.out.println(f.toString());
                        System.out.println("Gate: " + f.getGate());
                    }
                }
            }

            // UPDATE CREW MANAGEMENT
            if (c == 2) {
                for (Flight f : fl) {
                    if (f.getFlightNumber().equals(id)) {
                        System.out.println(f.toString());
                        System.out.println("Crew Management");
                        if (!(f.getSchdule() == null)) {
                            System.out.println(f.getSchdule().toString());
                            
                            Schedule schedule = new Schedule();
                            ArrayList<Staff> temp1 = new ArrayList<>();  //Chua ds Pilot tam
                            ArrayList<Staff> temp2 = new ArrayList<>(); //Chua ds FliAttend tam
                            ArrayList<Staff> temp3 = new ArrayList<>(); //Chua ds GroStaff tam

                            System.out.println("==================================");
                            System.out.println("======== LIST OF STAFF(S) ========");
                            System.out.println("==================================");

                            System.out.println("LIST OF PILOT(S)");
                            for (Staff staff : staffList) {
                                if (staff.getStaffRole().equals("Pilot")) {
                                    System.out.println(staff.toString());
                                }
                            }
                            do {
                                String plID = null;
                                valid = false;
                                do {
                                    do {
                                        System.out.println("Enter pilot ID: ");
                                        plID = sc.nextLine().toUpperCase();
                                        if (plID.matches("^PL\\d{4}$")) {
                                            valid = true;
                                            //
                                            for (Staff x : temp1) {
                                                if (x.getStaffId().equals(plID)) {
                                                    System.out.println("Already choosed");
                                                    valid = false;
                                                }
                                            }
                                            //
                                        } else {
                                            System.out.println("Invalid code");
                                            valid = false;
                                        }
                                    } while (valid == false);
                                    valid = false;
                                    for (Staff staff : staffList) {
                                        if (staff.getStaffRole().equals("Pilot") && staff.getStaffId().equals(plID)) {
                                            temp1.add(staff);
                                            valid = true;
                                            break;
                                        }
                                    }
                                    if (valid == false) {
                                        System.out.println("No suitable pilot");
                                    }
                                } while (valid == false);
                                do {
                                    System.out.print("Add more pilot (Y/N):");
                                    choice = sc.nextLine().toUpperCase();
                                } while (!(choice.equals("Y") || choice.equals("N")));
                                if (choice.equals("N")) {
                                    schedule.setPilots(temp1);
                                    break;
                                }
                            } while (choice.equals("Y"));

                            System.out.println("=================================");
                            System.out.println("LIST OF FLIGHT ATTENDANT(S)");
                            for (Staff staff : staffList) {
                                if (staff.getStaffRole().equals("Flight Attendant")) {
                                    System.out.println(staff.toString());
                                }
                            }
                            do {
                                String flAttend = null;
                                valid = false;
                                do {
                                    do {
                                        System.out.println("Enter Flight Attendant ID: ");
                                        flAttend = sc.nextLine().toUpperCase();
                                        if (flAttend.matches("^FA\\d{4}$")) {
                                            valid = true;
                                            //
                                            for (Staff x : temp2) {
                                                if (x.getStaffId().equals(flAttend)) {
                                                    System.out.println("Already choosed");
                                                    valid = false;
                                                }
                                            }
                                            //
                                        } else {
                                            System.out.println("Invalid code");
                                            valid = false;
                                        }
                                    } while (valid == false);
                                    valid = false;
                                    for (Staff staff : staffList) {
                                        if (staff.getStaffRole().equals("Flight Attendant") && staff.getStaffId().equals(flAttend)) {
                                            temp2.add(staff);
                                            valid = true;
                                            break;
                                        }
                                    }
                                    if (valid == false) {
                                        System.out.println("No suitable Flight Attendant");
                                    }
                                } while (valid == false);
                                do {
                                    System.out.print("Add more Flight Attendant (Y/N):");
                                    choice = sc.nextLine().toUpperCase();
                                } while (!(choice.equals("Y") || choice.equals("N")));
                                if (choice.equals("N")) {
                                    schedule.setFlightAttendants(temp2);
                                }
                            } while (choice.equals("Y"));

                            System.out.println("=================================");
                            System.out.println("LIST OF GROUND STAFF(S)");
                            for (Staff staff : staffList) {
                                if (staff.getStaffRole().equals("Ground Staff")) {
                                    System.out.println(staff.toString());
                                }
                            }
                            System.out.println("==================================");

                            do {
                                String grouStaff = null;
                                valid = false;
                                do {
                                    do {
                                        System.out.println("Enter Ground Staff ID: ");
                                        grouStaff = sc.nextLine().toUpperCase();
                                        if (grouStaff.matches("^GS\\d{4}$")) {
                                            valid = true;
                                            //
                                            for (Staff x : temp3) {
                                                if (x.getStaffId().equals(grouStaff)) {
                                                    System.out.println("Already choosed");
                                                    valid = false;
                                                }
                                            }
                                            //
                                        } else {
                                            System.out.println("Invalid code");
                                            valid = false;
                                        }
                                    } while (valid == false);
                                    valid = false;
                                    for (Staff staff : staffList) {
                                        if (staff.getStaffRole().equals("Ground Staff") && staff.getStaffId().equals(grouStaff)) {
                                            temp3.add(staff);
                                            valid = true;
                                            break;
                                        }
                                    }
                                    if (valid == false) {
                                        System.out.println("No suitable ground staff");
                                    }
                                } while (valid == false);
                                do {
                                    System.out.print("Add more Ground Staff (Y/N):");
                                    choice = sc.nextLine().toUpperCase();
                                } while (!(choice.equals("Y") || choice.equals("N")));
                                if (choice.equals("N")) {
                                    schedule.setGroundStaffs(temp3);
                                }

                            } while (choice.equals("Y"));
                            f.setSchdule(schedule);
                            System.out.println(f.toString());
                            System.out.println(f.getSchdule().toString());

                        } else {
                            System.out.println("Empty crew management");
                        }
                    }
                }

            }

        } while (!(c == 1 || c == 2));
    }
}
