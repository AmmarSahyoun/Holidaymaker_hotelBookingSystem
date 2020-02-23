package com.company;

import java.util.Date;

public class Booking {
    private int id;
    private Date checkIn;
    private Date checkOut;
    private String companion;
    private Guest guest;

    public Booking(int id, Date checkIn, Date checkOut, String companion, Guest guest) {
        this.id = id;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.companion = companion;
        this.guest = guest;
    }

    public void setCheckIn(Date checkIn) {
        this.checkIn = checkIn;
    }

    public void setCheckOut(Date checkOut) {
        this.checkOut = checkOut;
    }

    public void setCompanion(String companion) {
        this.companion = companion;
    }

    public Date getCheckIn() {
        return checkIn;
    }

    public Date getCheckOut() {
        return checkOut;
    }

    public String getCompanion() {
        return companion;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public Guest getGuest() {
        return guest;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
