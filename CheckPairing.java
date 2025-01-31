/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.checkpairing;
import java.io.*;
import java.util.*;
/**
 *
 * @author Albert Robert
 */
public class CheckPairing {
    public static String[][] readParticipantsFile(String filename) {
        String[][] participants = new String[4][4];
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            int row = 0;
            while ((line = br.readLine()) != null && row < 4) {
                participants[row] = line.split(",");
                row++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            return null;
        } catch (IOException e) {
            System.out.println("Error reading the file");
            return null;
        }
        return participants;
    }
    public static String normalizeAddress(String address) {
        return address.toLowerCase().replaceAll("\\s+", "").replaceAll("[^a-z0-9]", "");
    }
    public static boolean checkPairs(String[][] participants) {
        if (participants == null) {
            return false;
        }

        // Extract addresses and genders
        String address1 = normalizeAddress(participants[0][3]);
        String gender1 = participants[0][1];
        String address2 = normalizeAddress(participants[1][3]);
        String gender2 = participants[1][1];
        String address3 = normalizeAddress(participants[2][3]);
        String gender3 = participants[2][1];
        String address4 = normalizeAddress(participants[3][3]);
        String gender4 = participants[3][1];

        // Check if participants form valid pairs
        boolean pair1 = address1.equals(address2) && !gender1.equals(gender2);
        boolean pair2 = address3.equals(address4) && !gender3.equals(gender4);

        return pair1 && pair2;
    }
    public static void assignSeats(String[][] participants) {
        if (participants == null) {
            return;
        }

        String[] seats = {"A", "C", "B", "D"};
        try (PrintWriter writer = new PrintWriter(new FileWriter("grouping.txt"))) {
            for (int i = 0; i < participants.length; i++) {
                writer.printf("Seat %s : %s, %s years old%n", seats[i], participants[i][0], participants[i][2]);
            }
        } catch (IOException e) {
            System.out.println("Error writing to file");
        }
    }
    
    public static void main(String[] args) {
        String filename = "participants.txt";

        // Step 1: Read the participants file
        String[][] participants = readParticipantsFile(filename);
        if (participants == null) {
            return;
        }

        // Step 2: Print the participants array
        System.out.println("Participants:");
        for (String[] row : participants) {
            System.out.println(String.join(" ", row));
        }

        // Step 3: Check if participants form valid pairs
        if (checkPairs(participants)) {
            System.out.println("Participants are in pairs");

            // Step 4: Assign seats and write to grouping.txt
            assignSeats(participants);
        } 
        else {
            System.out.println("Participants are not in pairs, cannot proceed");
        }
    }
    
}
