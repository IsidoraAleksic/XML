package com.example.agentapp.domain.dto;

import com.example.agentapp.domain.Reservation;

import java.util.List;

public class BookedIntervals {

    private List<Reservation> reservationList;
    private boolean isSuccess;

    public BookedIntervals() {
    }

    public BookedIntervals(List<Reservation> reservationList, boolean isSuccess) {
        this.reservationList = reservationList;
        this.isSuccess = isSuccess;
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }
}
