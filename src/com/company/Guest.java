package com.company;

public class Guest {
    private int id;
    private String guestName;
    private String address;
    private String email;
    private String mobile;

    public Guest(int id, String guestName, String address, String email, String mobile) {
        this.id = id;
        this.guestName = guestName;
        this.address = address;
        this.email = email;
        this.mobile = mobile;
    }

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


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
