package com.example.demo.model;

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
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String place;
    private String description;
    private int capacity;

    @ManyToOne
    private AccommodationType accommodationType;

    @ManyToOne
    private AccommodationCategory category;

    @ManyToMany(fetch = FetchType.EAGER)
    private List<AdditionalServices> additionalServices;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agent_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Agent agent;


    public AccommodationUnit() {
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

    public List<AdditionalServices> getAdditionalServices() {
        return additionalServices;
    }

    public void setAdditionalServices(List<AdditionalServices> additionalServices) {
        this.additionalServices = additionalServices;
    }
}
