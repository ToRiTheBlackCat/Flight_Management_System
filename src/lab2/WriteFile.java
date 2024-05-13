/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

/**
 *
 * @author PC
 */
// CASE 5
public class WriteFile {

    FlightList fl;
    ReservationList rl;
    ScheduleList sl;

    public WriteFile(FlightList fl, ReservationList rl, ScheduleList sl) {
        this.fl = fl;
        this.rl = rl;
        this.sl = sl;
    }

    public void writeToFIle(String fileName) throws IOException {
        if (fl.isEmpty() || rl.isEmpty() || sl.isEmpty()) {
            System.out.println("\t\tEmpty list");
            return;
        }
        try {
            File f = new File(fileName);
            FileWriter fw = new FileWriter(f);
            PrintWriter pw = new PrintWriter(fw);
            pw.println("\t\t\t\t  == LIST OF FLIGHT ==");
            for (Flight fli : fl) {
                pw.println("Flight Information: " + fli.toString());
                pw.println("CREW MANAGEMENT: \n" + fli.getSchdule());

                for (Reservation re : rl) {
                    if (re.getSelectedFlight().getFlightNumber().equals(fli.getFlightNumber())) {
                        pw.println("Reservation ID: " + re.getResId());
                        pw.println("Status: " + re.getStatus());
                        pw.println("Gate: " + re.getGate());
                        pw.println("Passenger Information: " + re.travellers);
                        pw.println("Selected Seat(s): " + Arrays.toString(re.getSelectedSeat()));
                        pw.println("============================================");

                    }
                }
                pw.println("==================================================================================================================================");
            }

            System.out.println("Save succesfully");
            pw.close();
            fw.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
