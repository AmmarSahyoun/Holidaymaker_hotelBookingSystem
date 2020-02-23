package com.company;

public class Facility {
    private int id;
    private boolean pool;
    private boolean restaurant;
    private boolean childrenActivities;
    private boolean entertainment;

    public Facility(int id, boolean pool, boolean restaurant, boolean childrenActivities, boolean entertainment) {
        this.id = id;
        this.pool = pool;
        this.restaurant = restaurant;
        this.childrenActivities = childrenActivities;
        this.entertainment = entertainment;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPool(boolean pool) {
        this.pool = pool;
    }

    public void setRestaurant(boolean restaurant) {
        this.restaurant = restaurant;
    }

    public void setChildrenActivities(boolean childrenActivities) {
        this.childrenActivities = childrenActivities;
    }

    public void setEntertainment(boolean entertainment) {
        this.entertainment = entertainment;
    }

    public int getId() {
        return id;
    }

    public boolean isPool() {
        return pool;
    }

    public boolean isRestaurant() {
        return restaurant;
    }

    public boolean isChildrenActivities() {
        return childrenActivities;
    }

    public boolean isEntertainment() {
        return entertainment;
    }


}
