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
            System.out.println("[2] search for available room and Book");
            System.out.println("[3] change a room booking");
            System.out.println("[4] cancel a room booking");
            System.out.println("[5] search for customer");
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
                Date checkIn;
                Date checkOut;
                boolean pool;
                boolean restaurant;
                boolean childrenActivities;
                boolean entertainment;

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

                searchForRoom(checkIn, checkOut, pool, restaurant, childrenActivities, entertainment);

                int guestID = 0;
                System.out.println("choose a room ID to book:");
                int roomID = scn.nextInt();
                System.out.println("are you registered as customer?");
                System.out.println("[1] NO, i want to register [2] enter your customer id:");
                try {
                    choice = scn.nextInt();
                } catch (NumberFormatException ex) {
                    System.err.println("Choose a valid number");
                    return;
                } catch (Exception e) {
                    System.out.println("Not a valid number!!");
                    return;
                }
                if (choice == 1) {
                    guestID = registerNewCustomer();
                }
                else if (choice == 2) {
                    guestID = scn.nextInt();
                }

                System.out.println("Do you need extra bed (Y/n)?");

                scn = new Scanner (System.in);
                String result = scn.nextLine();
                boolean extraBed = (result.equalsIgnoreCase("y") ? true : false);

                System.out.println("How many traveler?");
                int companion = scn.nextInt();

                scn = new Scanner (System.in);
                System.out.println("Full board or Half board meal (full/half)?");
                String mealBoard = scn.nextLine();

                if (mealBoard.equalsIgnoreCase("full")){
                    mealBoard = "fullBoard";
                } else {
                    mealBoard = "halfBoard";
                }

                if (guestID != 0){
                    bookRoom(checkIn, checkOut, guestID, roomID, extraBed, companion, mealBoard);
                }

            }
            if (choice == 3) {

            }
            if (choice == 4) {

            }
            if (choice == 5) {
                searchForCustomer();
            }

            if (choice == 0) {
                break;
            }
        }
        System.out.print("Thank you and Goodbye..");
    }

    private int bookRoom(Date checkIn, Date checkOut, int guestID, int roomID, boolean extraBed, int companion, String mealBoard) {
        int bookingID = 0;
        try {

            statement = conn.prepareStatement("Insert Into Booking (checkIn, checkOut, companion, guest_id)" + " VALUES(?, ?, ?, ?)",Statement.RETURN_GENERATED_KEYS);
            statement.setDate(1, checkIn);
            statement.setDate(2, checkOut);
            statement.setInt(3, companion);
            statement.setInt(4, guestID);

            int i = statement.executeUpdate();

            if (i != 0) {
                System.out.println("Booking SUCCESS");

                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        bookingID = generatedKeys.getInt(1);
                    }
                    else {
                        throw new SQLException("Creating user failed, no ID obtained.");
                    }
                }

                if (bookingID != 0)
                {
                    System.out.println(bookingID);
                    PreparedStatement statementRooms = conn.prepareStatement("Insert Into booking_x_rooms (booking_id, rooms_id, extraBed, meals)" + " VALUES(?, ?, ?, ?)");
                    statementRooms.setInt(1, bookingID);
                    statementRooms.setInt(2, roomID);
                    statementRooms.setBoolean(3, extraBed);
                    statementRooms.setInt(4, (mealBoard.equalsIgnoreCase("fullboard")? 1 : 0));

                    int roomInsert = statementRooms.executeUpdate();

                    if (roomInsert != 0) {
                        System.out.println("Room assigned SUCCESS");
                    }
                }
            } else System.out.println("Something were wrong!");
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

        return bookingID;
    }

    public int registerNewCustomer() {
        int guestID = Integer.parseInt(null);

        System.out.println("Enter customer's full name:");
        String cusName = scn.nextLine();
        System.out.println("Enter customer's Address:");
        String cusAdd = scn.nextLine();
        System.out.println("Enter customer's Email:");
        String cusEmail = scn.nextLine();
        System.out.println("Enter customer's Mobile:");
        String cusMobile = scn.nextLine();
        try {

            statement = conn.prepareStatement("INSERT INTO guest (guestName, guestAddress, guestEmail, guestMobile)" + " VALUES(?, ?, ?, ?)",Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, cusName);
            statement.setString(2, cusAdd);
            statement.setString(3, cusEmail);
            statement.setString(4, cusMobile);

            int i = statement.executeUpdate();

            if (i != 0) {
                System.out.println("Registration SUCCESS");

                try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        guestID = generatedKeys.getInt(1);
                    }
                    else {
                        throw new SQLException("Creating user failed, no ID obtained.");
                    }
                }
            } else System.out.println("Something were wrong!");
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

        return guestID;
    }

    public void searchForRoom(Date checkIn, Date checkOut, boolean pool, boolean restaurant, boolean childrenActivities, boolean entertainment) {
        String sqlStat = "select * from availableRooms  where 1 = 1";

        if (checkIn != null && checkOut != null) {
            sqlStat = sqlStat + " and not exists (select  'x' from  allbooking_view where  allbooking_view.roomid = availableRooms.roomid and checkin  >= '" + checkIn + "' and checkout <= '" + checkOut + "' )";
        }

        if (pool) {
            sqlStat = sqlStat + " and pool = 1";
        }
        if (restaurant) {
            sqlStat = sqlStat + " and restaurant = 1";
        }
        if (childrenActivities) {
            sqlStat = sqlStat + " and childrenActivities = 1";
        }
        if (entertainment) {
            sqlStat = sqlStat + " and entertainment = 1";
        }

        sqlStat = sqlStat +" Order By HotelName, RoomNr";

        try {
            statement = conn.prepareStatement(sqlStat);
            resultSet = statement.executeQuery();
        } catch (
                Exception e) {

            e.printStackTrace();
            return;
        }

        try {
            while (resultSet.next()) {

                String row = "id: " + resultSet.getInt("RoomID")
                        + ", Hotel Name: " + resultSet.getString("HotelName")
                        + ", Room Number: " + resultSet.getString("RoomNr")
                        + ", Room Type: " + resultSet.getString("RoomType")
                        + ", hotel distance: " + resultSet.getString("distance")
                        + ", hotel pool: " + resultSet.getString("pool")
                        + ", hotel restaurant: " + resultSet.getString("restaurant")
                        + ", hotel childrenActivities: " + resultSet.getString("childrenActivities")
                        + ", hotel entertainment: " + resultSet.getString("entertainment")
                        + ", hotel room price: " + resultSet.getString("roomPrice");

                System.out.println(row);
            }
        } catch (
                Exception ex) {
            ex.printStackTrace();
        }
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
        System.out.println("customer already registered");
    }

}

