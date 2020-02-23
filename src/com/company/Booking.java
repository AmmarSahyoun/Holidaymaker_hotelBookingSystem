package com.company;

import java.util.Date;

public class Booking {
    private Date checkIn;
    private Date checkOut;
    private String companion;

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

    public Booking(Date checkIn, Date checkOut, String companion) {
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.companion = companion;
    }
}
