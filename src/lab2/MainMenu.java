/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.util.Scanner;

/**
 *
 * @author PC
 */
public class MainMenu {

    public void Menu1() {
        System.out.println();
        System.out.println("============ Flight Management System ============");
        System.out.println("| 1. Flight schedule management                  |");
        System.out.println("| 2. Passenger reservation and booking           |");
        System.out.println("| 3. Passenger check-in and seat allocation      |");
        System.out.println("| 4. Crew management and Administrator access    |");
        System.out.println("| 5. Data storage for flight details,reservations|\n| and aggignments\t\t\t\t |");
        System.out.println("| 6. Print all lists from file                   |");
        System.out.println("| 7. Quit                                        |");
        System.out.println("==================================================");
        System.out.print("Your choice: ");

    }

    public void Menu4_2() {
        String userName;
        String password;
        Scanner sc = new Scanner(System.in);
        System.out.println("===ADMINISTRATOR ACCESS===");
        do {
            System.out.println("UserName: ");
            userName = sc.nextLine();
            System.out.println("Password: ");
            password = sc.nextLine();
            if ((!userName.equals("root")) ||(!password.equals("12345"))|| (userName.isEmpty()) || (password.isEmpty())) {
                System.out.println("UserName or password is not correct! Try again");
            }
        } while ((!userName.equals("root")) ||(!password.equals("12345")) || (userName.isEmpty()) || (password.isEmpty()));
    }
}
