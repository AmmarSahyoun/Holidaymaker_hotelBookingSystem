package com.company;

import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Program {
    private ArrayList<Hotel> hotels = new ArrayList<>();
    private ArrayList<Rooms> rooms = new ArrayList<>();
    private ArrayList<Guest> guests = new ArrayList<>();
    private ArrayList<Rooms> searchResult = new ArrayList<>();
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
            System.out.println("[2] search for available room");
            System.out.println("[3] change a room booking");
            System.out.println("[4] cancel a room booking");
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

                searchForRoom(Rooms room);
            }
            if (choice == 3) {

            }
            if (choice == 4) {

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

    public void searchForRoom(Date checkIn, Date checkOut, boolean pool, boolean restaurant, boolean childrenActivities, boolean entertainment) {
        String sqlStat = "select * from rooms inner join hotel inner join facility inner join review inner join  room_type  where 1 = 1";

        if (checkIn != null) {  // date null?
            sqlStat = sqlStat + "checkIn = 1";
        }
        if (checkOut != null) {
            sqlStat = sqlStat + "checkOut = 1";
        }
        if (pool != Boolean.parseBoolean(null)) {
            sqlStat = sqlStat + "pool = 1";
        }
        if (restaurant != Boolean.parseBoolean(null)) {
            sqlStat = sqlStat + "restaurant = 1";
        }
        if (childrenActivities != Boolean.parseBoolean(null)) {
            sqlStat = sqlStat + "childrenActivities = 1";
        }
        if (entertainment != Boolean.parseBoolean(null)) {
            sqlStat = sqlStat + "entertainment = 1";
        }
        System.out.println("Enter check in date(yyyy-mm-dd):");
        checkIn = Date.valueOf(scn.nextLine());
        System.out.println("Enter check out date(yyyy-mm-dd):");
        checkOut = Date.valueOf(scn.nextLine());
        System.out.println("choose your hotel facilities:");
        System.out.println("[1] with pool  [0] without pool");
        pool = Boolean.parseBoolean(scn.nextLine());
        System.out.println("[1] with restaurant  [0] without restaurant");
        restaurant = Boolean.parseBoolean(scn.nextLine());
        System.out.println("[1] with children activities  [0] without children activities");
        childrenActivities = Boolean.parseBoolean(scn.nextLine());
        System.out.println("[1] with entertainment  [0] without entertainment");
        entertainment = Boolean.parseBoolean(scn.nextLine());

        try {
            statement = conn.prepareStatement(sqlStat);
            resultSet = statement.executeQuery();
        } catch (
                Exception e) {

            e.printStackTrace();
        }
        try {
            while (resultSet.next()) {
                String row = "id: " + resultSet.getString("id")
                        + ", checkIn: " + resultSet.getString("checkIn")
                        + ", checkOut: " + resultSet.getString("checkOut")
                        + ", pool: " + resultSet.getString("pool")
                        + ", restaurant: " + resultSet.getString("restaurant")
                        + ", childrenActivities: " + resultSet.getString("childrenActivities")
                        + ", entertainment: " + resultSet.getString("entertainment")

                        + ".";
                System.out.println(row);
            }
        } catch (
                Exception ex) {
            ex.printStackTrace();
        }
        System.out.println("customer not registered!");

        Rooms rooms = new Rooms();
        searchResult.add(rooms);

    }





    /*

           1- Register Guest

           2- Search For available room(s)
                2.a show available room (Array<Room>)
                2.b Let the Customer select any room Info
                2.c Select a room from the Array to Book
                2.d Book the selected room

           3- booking

           4-active booking

     */

            public void searchForCustomer () {

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

    }
}