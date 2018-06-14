package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class AccommodationPhoto implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "accommodation_unit_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private AccommodationUnit accommodationUnit;

    private String path;

    public AccommodationPhoto(AccommodationUnit accommodationUnit, String path) {
        this.accommodationUnit = accommodationUnit;
        this.path = path;
    }

    public AccommodationPhoto() {
    }

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

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
