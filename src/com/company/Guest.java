package com.company;

import java.util.ArrayList;

public class Guest {
    private String guestName;
    private String address;
    private String email;
    private String mobile;

    public void setGuestName(String guestName) {
        this.guestName = guestName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getMobile() {
        return mobile;
    }

    private ArrayList<Booking> bookings = new ArrayList<>();

    public Guest(String guestName, String address, String email, String mobile, ArrayList<Booking> bookings) {
        this.guestName = guestName;
        this.address = address;
        this.email = email;
        this.mobile = mobile;
        this.bookings = bookings;
    }


}
