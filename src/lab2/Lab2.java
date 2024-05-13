/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author PC
 */
public class Lab2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        MainMenu m = new MainMenu();
        Scanner sc = new Scanner(System.in);
        FlightList fl = new FlightList();
        ReservationList rl = new ReservationList(fl);
        ScheduleList scl = new ScheduleList(fl);
        WriteFile wf = new WriteFile(fl, rl, scl);
        scl.addStaff();
        int choice = 0;
        do {
            do {
                m.Menu1();
                try {
                    choice = Integer.parseInt(sc.nextLine());
                } catch (Exception ex) {
                    System.out.println("Invalid choice");
                }
            } while (choice < 1 || choice > 7);

            switch (choice) {
                case 1: {
                    fl.addNewFlight();
                    break;
                }
                case 2: {
                    rl.makeReservation();
                    break;
                }
                case 3: {
                    rl.checkIn();
                    break;
                }
                case 4: {
                    boolean valid = true;
                    do {
                        try {
                            System.out.println("1. Crew Management");
                            System.out.println("2. Administrator Access");
                            System.out.print("Your choice (1/2): ");
                            choice = Integer.parseInt(sc.nextLine());
                            if (!(choice == 1 || choice == 2)) {
                                valid = false;
                                System.out.println("Invalid choice");
                            } else if (choice == 1 || choice == 2) {
                                valid = true;
                            }
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid choice");
                            valid = false;
                        }
                    } while (valid == false);
                    switch (choice) {
                        case 1: {
                            scl.addSchedule();
                            break;
                        }
                        case 2: {
                           m.Menu4_2(); 
                           scl.Admin();
                            break;
                        }
                    }
                    break;
                }
                case 5: {
                    wf.writeToFIle("output.txt");
                    break;
                }
                case 6: {
                    scl.printFromFile("input.txt");
                    break;
                }
                case 7: {
                    System.out.println("\t\tGoodbye");
                    break;
                }
            }

        } while (choice < 7);
    }
}
