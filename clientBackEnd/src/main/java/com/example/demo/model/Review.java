package com.example.demo.model;

import javax.persistence.*;

@Entity
public class Review  {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String review;
    @ManyToOne
    private AccommodationUnit accommodationUnit;
    private boolean approved;
    @ManyToOne
    private User user;

    public Review() {
    }

    public Review(String review, AccommodationUnit accommodationUnit, boolean approved, User user) {

        this.review = review;
        this.accommodationUnit = accommodationUnit;
        this.approved = approved;
        this.user = user;
    }

    public long getId() {

        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public AccommodationUnit getAccommodationUnit() {
        return accommodationUnit;
    }

    public void setAccommodationUnit(AccommodationUnit accommodationUnit) {
        this.accommodationUnit = accommodationUnit;
    }

    public boolean isApproved() {
        return approved;
    }

    public void setApproved(boolean approved) {
        this.approved = approved;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
