package com.company;

public class RoomType {
    private int id;
    private RoomTitle roomTitle;
    private double roomPrice;

    public RoomType(int id, RoomTitle roomTitle, double roomPrice) {

        this.id = id;
        this.roomTitle = roomTitle;
        this.roomPrice = roomPrice;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RoomTitle getRoomTitle() {
        return roomTitle;
    }

    public void setRoomTitle(RoomTitle roomTitle) {
        this.roomTitle = roomTitle;
    }

    public void setRoomPrice(double roomPrice) {
        this.roomPrice = roomPrice;
    }

    public int getId() {
        return id;
    }


    public double getRoomPrice() {
        return roomPrice;
    }


}


