//package com.example.demo.model;
//
//import javax.persistence.*;
//
//@Entity
//public class Rating {
//
//    @Id
//    @GeneratedValue(strategy= GenerationType.IDENTITY)
//    private long id;
//    private int rating;
//    @ManyToOne
//    private AccommodationUnit accommodationUnit;
//    @ManyToOne
//    private User user;
//
//    public Rating() {
//    }
//
//    public Rating(int rating, AccommodationUnit accommodationUnit, User user) {
//
//        this.rating = rating;
//        this.accommodationUnit = accommodationUnit;
//        this.user = user;
//    }
//
//    public long getId() {
//
//        return id;
//    }
//
//    public void setId(long id) {
//        this.id = id;
//    }
//
//    public int getRating() {
//        return rating;
//    }
//
//    public void setRating(int rating) {
//        this.rating = rating;
//    }
//
//    public AccommodationUnit getAccommodationUnit() {
//        return accommodationUnit;
//    }
//
//    public void setAccommodationUnit(AccommodationUnit accommodationUnit) {
//        this.accommodationUnit = accommodationUnit;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//}
