package com.example.agentapp.service;

import com.example.agentapp.domain.Reservation;

import java.util.List;

public interface BookedIntervalService {

    Reservation bookInterval(Reservation reservation);

    List<Reservation> getByUnitId(long id);

    List<Reservation> getAll();

    void saveReservations(List<Reservation> reservations);

    Reservation getById(long id);

    List<Reservation> getAllUnconfirmed();

}

