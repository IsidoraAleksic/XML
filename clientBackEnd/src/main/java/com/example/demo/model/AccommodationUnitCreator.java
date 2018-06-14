package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.*;

@Entity
public class AccommodationUnitCreator {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @OneToOne
    @JoinColumn(name = "accommodation_unit_id", nullable = false)
    private AccommodationUnit accommodationUnit;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User creator;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public AccommodationUnit getAccommodationUnit() {
        return accommodationUnit;
    }

    public void setAccommodationUnit(AccommodationUnit accommodationUnit) {
        this.accommodationUnit = accommodationUnit;
    }

    public User getCreator() {
        return creator;
    }

    public void setCreator(User creator) {
        this.creator = creator;
    }

    public AccommodationUnitCreator() {

    }
}
