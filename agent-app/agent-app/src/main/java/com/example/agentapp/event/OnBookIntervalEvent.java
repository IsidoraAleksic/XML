package com.example.agentapp.event;

import com.example.agentapp.domain.Reservation;
import org.springframework.context.ApplicationEvent;

public class OnBookIntervalEvent extends ApplicationEvent {

    private Reservation reservation;

    public OnBookIntervalEvent(Reservation reservation) {
        super(reservation);
        this.reservation = reservation;
    }

    public Reservation getReservation() {
        return reservation;
    }
}
