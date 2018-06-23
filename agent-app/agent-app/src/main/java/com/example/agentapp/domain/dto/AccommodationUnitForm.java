package com.example.agentapp.domain.dto;

import com.example.agentapp.domain.*;

import java.util.List;

public class AccommodationUnitForm {

    private long id;
    private String place;
    private String description;
    private int capacity;
    private AccommodationType accommodationType;
    private AccommodationCategory category;
    private List<AdditionalService> additionalServices;
    private Agent agent;
    private AccommodationPricing accommodationPricing;

    public AccommodationUnitForm() {
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public AccommodationType getAccommodationType() {
        return accommodationType;
    }

    public void setAccommodationType(AccommodationType accommodationType) {
        this.accommodationType = accommodationType;
    }

    public AccommodationCategory getCategory() {
        return category;
    }

    public void setCategory(AccommodationCategory category) {
        this.category = category;
    }

    public List<AdditionalService> getAdditionalServices() {
        return additionalServices;
    }

    public void setAdditionalServices(List<AdditionalService> additionalServices) {
        this.additionalServices = additionalServices;
    }

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
    }

    public AccommodationPricing getAccommodationPricing() {
        return accommodationPricing;
    }

    public void setAccommodationPricing(AccommodationPricing accommodationPricing) {
        this.accommodationPricing = accommodationPricing;
    }
}
