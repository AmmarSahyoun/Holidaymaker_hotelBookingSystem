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
            System.out.println("[1] Register a new customer ");
            System.out.println("[2] Search for available room and Book");
            System.out.println("[3] Change a booking");
            System.out.println("[4] Search for a customer info");
            System.out.println("[0] Exit");

            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/holidaymaker?user=root&password=lIgammoury16R&serverTimezone=UTC");
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
                System.out.println("Choose your hotel facilities:");
                System.out.println("[1] With pool  [0] Without pool");
                pool = Boolean.parseBoolean(scn.nextLine());
                System.out.println("[1] With restaurant  [0] Without restaurant");
                restaurant = Boolean.parseBoolean(scn.nextLine());
                System.out.println("[1] With children activities  [0] Without children activities");
                childrenActivities = Boolean.parseBoolean(scn.nextLine());
                System.out.println("[1] With entertainment  [0] Without entertainment");
                entertainment = Boolean.parseBoolean(scn.nextLine());

                searchForRoom(checkIn, checkOut, pool, restaurant, childrenActivities, entertainment);

                int guestID = 0;
                System.out.println("Choose a room ID to book:");
                int roomID = scn.nextInt();
                System.out.println("Are you registered as a hotel guest?");
                System.out.println("[1] NO, i want to register    [2] Enter your customer id:");
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
                } else if (choice == 2) {
                    guestID = scn.nextInt();
                }

                System.out.println("Do you need extra bed (Y/n)?");

                scn = new Scanner(System.in);
                String result = scn.nextLine();
                boolean extraBed = (result.equalsIgnoreCase("y") ? true : false);

                System.out.println("How many guests companion you?");
                int companion = scn.nextInt();

                scn = new Scanner(System.in);
                System.out.println("Full board or Half board meal (full/half)?");
                String mealBoard = scn.nextLine();

                if (mealBoard.equalsIgnoreCase("full")) {
                    mealBoard = "fullBoard";
                } else {
                    mealBoard = "halfBoard";
                }

                if (guestID != 0) {
                    bookRoom(checkIn, checkOut, guestID, roomID, extraBed, companion, mealBoard);
                }

            }
            if (choice == 3) {
                changeBooking();
            }

            if (choice == 4) {
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

            statement = conn.prepareStatement("Insert Into Booking (checkIn, checkOut, companion, guest_id)" + " VALUES(?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
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
                    } else {
                        throw new SQLException("Operation failed!");
                    }
                }

                if (bookingID != 0) {
                    System.out.println(bookingID);
                    PreparedStatement statementRooms = conn.prepareStatement("Insert Into booking_x_rooms (booking_id, rooms_id, extraBed, meals)" + " VALUES(?, ?, ?, ?)");
                    statementRooms.setInt(1, bookingID);
                    statementRooms.setInt(2, roomID);
                    statementRooms.setBoolean(3, extraBed);
                    statementRooms.setInt(4, (mealBoard.equalsIgnoreCase("fullboard") ? 1 : 0));

                    int roomInsert = statementRooms.executeUpdate();

                    if (roomInsert != 0) {
                        System.out.println("The room has booked successfully");
                    }
                }
            } else System.out.println("Something were wrong!");
        } catch (SQLException e) {
            throw new RuntimeException(e);

        }

        return bookingID;
    }

    public int registerNewCustomer() {
        int guestID = 0;

        System.out.println("Enter customer's full name:");
        String cusName = scn.nextLine();
        System.out.println("Enter customer's Address:");
        String cusAdd = scn.nextLine();
        System.out.println("Enter customer's Email:");
        String cusEmail = scn.nextLine();
        System.out.println("Enter customer's Mobile:");
        String cusMobile = scn.nextLine();
        try {

            statement = conn.prepareStatement("INSERT INTO guest (guestName, guestAddress, guestEmail, guestMobile)" + " VALUES(?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
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
                    } else {
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

        sqlStat = sqlStat + " Order By roomPrice, reviewStars";

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

                String row = "Room Id: " + resultSet.getInt("RoomID")
                        + ", Hotel Name: " + resultSet.getString("HotelName")
                        + ", Hotel review: " + resultSet.getString("reviewStars")
                        //           + ", Room No: " + resultSet.getString("Roomnr")
                        + ", hotel room price: " + resultSet.getString("roomPrice")
                        + ", Room Type: " + resultSet.getString("RoomType")
                        + ", hotel distance: " + resultSet.getString("distance")
                        + ", hotel pool: " + resultSet.getString("pool")
                        + ", hotel restaurant: " + resultSet.getString("restaurant")
                        + ", hotel childrenActivities: " + resultSet.getString("childrenActivities")
                        + ", hotel entertainment: " + resultSet.getString("entertainment");


                System.out.println(row);
            }
        } catch (
                Exception ex) {
            ex.printStackTrace();
        }
    }

    public void changeBooking() {
        int guestId = 0;
        System.out.println("enter a guest id:");
        try {
            guestId = scn.nextInt();
        } catch (NumberFormatException ex) {
            System.err.println("Choose a valid number");
            new Program();
        } catch (Exception e) {
            System.out.println("Not a valid number!!");
            return;
        }

        try {
            statement = conn.prepareStatement("select * from allbooking_view \n" +
                    "\tInner Join Guest on (Guest.id = allbooking_view.guestID)\n" +
                    "    Inner Join AllRooms_View on (AllRooms_View.roomid = allbooking_view.roomid) where guestID like ?");
            statement.setString(1, String.valueOf(guestId));

            resultSet = statement.executeQuery();
        } catch (Exception e) {

            e.printStackTrace();
        }
        try {
            while (resultSet.next()) {
                String row = " guestId: " + resultSet.getString("id")
                        + ", Name: " + resultSet.getString("guestName")
                        + ", booking id: " + resultSet.getString("bookingId")
                        + ", check-in: " + resultSet.getString("checkIn")
                        + ", check-out: " + resultSet.getString("checkOut")
                        + ", companion: " + resultSet.getString("companion")
                        + ", extra Bed: " + resultSet.getString("extraBed")
                        + ", meals: " + resultSet.getString("meals")
                        + ", room Id: " + resultSet.getString("roomId")
                        + ", room type: " + resultSet.getString("roomType")
                        + ", room price: " + resultSet.getString("roomPrice");
                System.out.println(row);
                System.out.println();

                System.out.println("Enter Your Booking ID:");
                int guestBookingId = scn.nextInt();


                Date guestCheckIn = Date.valueOf(resultSet.getString("checkIn"));
                Date guestCheckOut = Date.valueOf(resultSet.getString("checkOut"));
                System.out.println("Choose NEW hotel facilities:");
                System.out.println("[1] With pool  [0] Without pool");
                Scanner scnn = new Scanner(System.in);
                boolean pool = Boolean.parseBoolean(scnn.nextLine());
                System.out.println("[1] With restaurant  [0] Without restaurant");
                boolean restaurant = Boolean.parseBoolean(scnn.nextLine());
                System.out.println("[1] With children activities  [0] Without children activities");
                boolean childrenActivities = Boolean.parseBoolean(scnn.nextLine());
                System.out.println("[1] With entertainment  [0] Without entertainment");
                boolean entertainment = Boolean.parseBoolean(scnn.nextLine());

                System.out.println("       List of available rooms sorted by Price and review:");
                searchForRoom(guestCheckIn, guestCheckOut, pool, restaurant, childrenActivities, entertainment);
                System.out.println("Choose a room ID to change your booking:");
                int roomID = scnn.nextInt();

                System.out.println("Do you need extra bed (Y/n)?");

                scn = new Scanner(System.in);
                String result = scn.nextLine();
                boolean extraBed = (result.equalsIgnoreCase("y") ? true : false);

                scn = new Scanner(System.in);
                System.out.println("Full board or Half board meal (full/half)?");
                String mealBoard = scn.nextLine();

                if (mealBoard.equalsIgnoreCase("full")) {
                    mealBoard = "fullBoard";
                } else {
                    mealBoard = "halfBoard";
                }

                statement = conn.prepareStatement("update holidaymaker.booking_x_rooms set meals=?, extraBed=?, rooms_id=? where booking_id like ?");
                statement.setString(1, mealBoard);
                statement.setBoolean(2, extraBed);
                statement.setInt(3, roomID);
                statement.setInt(4, guestBookingId);

                int i = statement.executeUpdate();

                if (i != 0) {
                    System.out.println("The booking has Changed SUCCESSFULLY");

                    try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            guestBookingId = generatedKeys.getInt(1);
                        } else {
                            throw new SQLException("Operation failed!");
                        }
                    }
                }

            }
        } catch (NumberFormatException ex) {
            new Program();
        } catch (Exception e) {
            System.out.println();
            return;
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
                String row = "Guest id: " + resultSet.getString("id")
                        + ", guest name: " + resultSet.getString("guestName")
                        + ", guestAddress: " + resultSet.getString("guestAddress")
                        + ", guestEmail: " + resultSet.getString("guestEmail")
                        + ", guestMobile: " + resultSet.getString("guestMobile") + ".";

                if (!cusName.equalsIgnoreCase(resultSet.getString("guestName"))) {
                    System.out.println("customer are not registered");
                }
                System.out.println(row);

            }
        } catch (
                Exception ex) {
            ex.printStackTrace();
        }
    }
}

