package com.example.agentapp.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@JsonIgnoreProperties({ "hibernateLazyInitializer","handler"})
public class AccommodationUnit implements Serializable {

    @Id
    private long id;
    private String place;
    private String description;
    private int capacity;

    @ManyToOne
    private AccommodationType accommodationType;

    @ManyToOne
    private AccommodationCategory category;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<AdditionalService> additionalServices;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agent_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Agent agent;


    public AccommodationUnit() {
    }

    public AccommodationUnit(long id, String place, String description, int capacity, AccommodationType accommodationType, AccommodationCategory category, List<AdditionalService> additionalServices, Agent agent) {
        this.id = id;
        this.place = place;
        this.description = description;
        this.capacity = capacity;
        this.accommodationType = accommodationType;
        this.category = category;
        this.additionalServices = additionalServices;
        this.agent = agent;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Agent getAgent() {
        return agent;
    }

    public void setAgent(Agent agent) {
        this.agent = agent;
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
}
