package com.company;

import java.util.Scanner;

public class Program {
    public int choice;

    public Program() {
        boolean startUserMenu = true;
        Scanner scn = new Scanner(System.in);

        while (startUserMenu) {

            System.out.println();
            System.out.println("    .:Welcome to the Holidaymaker:.");
            System.out.println("[1] register new customer ");
            System.out.println("[2] search for a room");
            System.out.println("[3] change a room booking");
            System.out.println("[4] un-book a room");
            System.out.println("[5] find a book by customer");
            System.out.println("[6] Show all bookings");


            System.out.println("[0] Exit");
            try {
                choice = Integer.parseInt(scn.nextLine());
            } catch (NumberFormatException ex) {
                System.err.println("Choose a valid number");
                new Program();
            } catch (Exception e) {
                System.out.println("Not a valid number!!");
                new Program();
            }

            if (choice == 1) {

            }
            if (choice == 2) {

            }
            if (choice == 3) {

            }
            if (choice == 4) {

            }
            if (choice == 5) {

            }
            if (choice == 6) {

            }
            if (choice == 0) {
                break;
            }
        }
        System.out.print("Thank you and Goodbye..");
    }
}