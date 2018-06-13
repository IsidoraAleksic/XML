package com.example.agentapp.domain;

import com.example.agentapp.domain.type.AccommodationType;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
@Data
@NoArgsConstructor
public class AccommodationUnit implements Serializable {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;
    private String country;
    private String city;
    private String address;
    private String description;
    private AccommodationType accommodationType;
    private int capacity;
    private int category;   // 0 - 5; 0 -> nekategorisano
    private boolean wifi;
    private boolean parking;
    private boolean breakfast;
    private boolean tv;
    private boolean privateBathroom;
    private boolean kitchen;

}
