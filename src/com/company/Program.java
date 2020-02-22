package com.company;

import java.sql.*;
import java.util.Scanner;

public class Program {
    public int choice;
    private Connection conn = null;
    private PreparedStatement statement;
    private ResultSet resultSet;
    Scanner scn = new Scanner(System.in);

    public Program() {
        boolean startUserMenu = true;


        while (startUserMenu) {

            System.out.println();
            System.out.println("    .:Welcome Admin to the Holidaymaker:.");
            System.out.println("[1] register a new customer ");
            System.out.println("[2] search for a customer");
            System.out.println("[3] change a room booking");
            System.out.println("[4] show all customers");
            System.out.println("[5] Show all bookings");
            System.out.println("[0] Exit");

            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost/holidaymaker?user=root&password=lIgammoury16R&serverTimezone=UTC");
            } catch (
                    Exception ex) {
                ex.printStackTrace();
            }
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
                registerNewCustomer();
            }
            if (choice == 2) {
                searchForCustomer();
            }
            if (choice == 3) {

            }
            if (choice == 4) {
                showAllCustomers();
            }
            if (choice == 5) {

            }
            if (choice == 0) {
                break;
            }
        }
        System.out.print("Thank you and Goodbye..");
    }

    public void registerNewCustomer() {
        System.out.println("Enter customer's full name:");
        String cusName = scn.nextLine();
        System.out.println("Enter customer's Address:");
        String cusAdd = scn.nextLine();
        System.out.println("Enter customer's Email:");
        String cusEmail = scn.nextLine();
        System.out.println("Enter customer's Mobile:");
        String cusMobile = scn.nextLine();
        try {

            statement = conn.prepareStatement("INSERT INTO guest (guestName, guestAddress, guestEmail, guestMobile)" + " VALUES(?, ?, ?, ?)");
            statement.setString(1, cusName);
            statement.setString(2, cusAdd);
            statement.setString(3, cusEmail);
            statement.setString(4, cusMobile);

             int i = statement.executeUpdate();
            if (i != 0) {
                System.out.println("Registration SUCCESS");
            } else System.out.println("Something were wrong!");
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }


    }

    public void showAllCustomers() {

/*
        try {
            String guestName = null;
            statement = conn.prepareStatement("select guestName from guest like ?");
            statement.setString(1, "*");
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String row = "id: " + resultSet.getString("id")
                        + ", guestName: " + resultSet.getString("guestName");
                System.out.println(row);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }*/
    }

    public void searchForCustomer() {

        System.out.println("Enter customer's full name:");
        String cusName = scn.nextLine();
        try {
            statement = conn.prepareStatement("select * from guest where guestName like ?");
            statement.setString(1, cusName);
            resultSet = statement.executeQuery();
        } catch (
                Exception e) {

            e.printStackTrace();
        }
        try {
            while (resultSet.next()) {
                String row = "id: " + resultSet.getString("id")
                        + ", guest name: " + resultSet.getString("guestName")
                        + ", guestAddress: " + resultSet.getString("guestAddress")
                        + ", guestEmail: " + resultSet.getString("guestEmail")
                        + ", guestMobile: " + resultSet.getString("guestMobile") + ".";
                System.out.println(row);
            }
        } catch (
                Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("customer not registered!");
    }

}

