package com.example.agentapp.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Message implements Serializable {

    @Id
    private long id;
    @ManyToOne
    private Reservation reservation;
    private String message;
    private boolean agent;

    public Message() {
    }

    public Message(long id, Reservation reservation, String message, boolean agent) {
        this.id = id;
        this.reservation = reservation;
        this.message = message;
        this.agent = agent;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Reservation getReservation() {
        return reservation;
    }

    public void setReservation(Reservation reservation) {
        this.reservation = reservation;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isAgent() {
        return agent;
    }

    public void setAgent(boolean agent) {
        this.agent = agent;
    }
}
