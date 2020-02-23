package com.company;

public class Rooms {

    private int id;
    private String RoomNumber;
    private RoomType roomType;
    private Hotel hotel;

    public Rooms(int id, String roomNumber, RoomType roomType, Hotel hotel) {
        this.id = id;
        RoomNumber = roomNumber;
        this.roomType = roomType;
        this.hotel = hotel;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setRoomNumber(String roomNumber) {
        RoomNumber = roomNumber;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public int getId() {
        return id;
    }

    public String getRoomNumber() {
        return RoomNumber;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public Hotel getHotel() {
        return hotel;
    }


}
