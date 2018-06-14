package com.example.demo.model;

import com.example.demo.model.type.FoodService;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class AccommodationUnit implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String place;
    @ManyToOne
    private AccommodationType accommodationType;
    private int capacity;
    @ManyToOne
    private AccommodationCategory category;
    @Enumerated(EnumType.STRING)
    private FoodService pansion;


    @ManyToMany
    private List<AdditionalServices> additionalServices;

       public AccommodationUnit() {
        }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public AccommodationType getAccommodationType() {
        return accommodationType;
    }

    public void setAccommodationType(AccommodationType accommodationType) {
        this.accommodationType = accommodationType;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public AccommodationCategory getCategory() {
        return category;
    }

    public void setCategory(AccommodationCategory category) {
        this.category = category;
    }

    public FoodService getPansion() {
        return pansion;
    }

    public void setPansion(FoodService pansion) {
        this.pansion = pansion;
    }

    public List<AdditionalServices> getAdditionalServices() {
        return additionalServices;
    }

    public void setAdditionalServices(List<AdditionalServices> additionalServices) {
        this.additionalServices = additionalServices;
    }
}
