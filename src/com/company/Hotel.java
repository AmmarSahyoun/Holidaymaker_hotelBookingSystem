package com.company;

public class Hotel {

    private Review review;
    private String hotelName;
    private Facility facility;
    private String city;
    private String distance;
    private double halfBoardPrice;
    private double fullBoardPrice;
    private double extraBedPrice;

    public Hotel(int reviewID, int reviewStarts, int facilityID, boolean pool, boolean restaurant, boolean childrenActivities,
                 boolean entertainment, String hotelName, String city, String distance, double halfBoardPrice,
                 double fullBoardPrice, double extraBedPrice) {
        this.review = new Review(reviewID, reviewStarts);
        this.facility = new Facility(facilityID, pool, restaurant, childrenActivities, entertainment);
        this.hotelName = hotelName;
        this.city = city;
        this.distance = distance;
        this.halfBoardPrice = halfBoardPrice;
        this.fullBoardPrice = fullBoardPrice;
        this.extraBedPrice = extraBedPrice;
    }

    public void setReview(Review review) {
        this.review = review;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public void setHalfBoardPrice(double halfBoardPrice) {
        this.halfBoardPrice = halfBoardPrice;
    }

    public void setFullBoardPrice(double fullBoardPrice) {
        this.fullBoardPrice = fullBoardPrice;
    }

    public void setExtraBedPrice(double extraBedPrice) {
        this.extraBedPrice = extraBedPrice;
    }

    public Review getReview() {
        return review;
    }

    public String getHotelName() {
        return hotelName;
    }

    public Facility getFacility() {
        return facility;
    }

    public String getCity() {
        return city;
    }

    public String getDistance() {
        return distance;
    }

    public double getHalfBoardPrice() {
        return halfBoardPrice;
    }

    public double getFullBoardPrice() {
        return fullBoardPrice;
    }

    public double getExtraBedPrice() {
        return extraBedPrice;
    }


}
