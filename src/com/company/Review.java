package com.company;

public class Review {
    private int id;
    private int reviewStarts;

    public Review(int id, int reviewStarts) {
        this.id = id;
        this.reviewStarts = reviewStarts;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setReviewStarts(int reviewStarts) {
        this.reviewStarts = reviewStarts;
    }

    public int getId() {
        return id;
    }

    public int getReviewStarts() {
        return reviewStarts;
    }


}
