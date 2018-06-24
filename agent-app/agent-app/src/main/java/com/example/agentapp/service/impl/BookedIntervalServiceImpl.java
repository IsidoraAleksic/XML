package com.example.agentapp.service.impl;

import com.example.agentapp.domain.Reservation;
import com.example.agentapp.repository.BookedIntervalRepository;
import com.example.agentapp.service.BookedIntervalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class BookedIntervalServiceImpl implements BookedIntervalService {

    private BookedIntervalRepository bookedIntervalRepository;

    @Autowired
    public BookedIntervalServiceImpl(BookedIntervalRepository bookedIntervalRepository) {
        this.bookedIntervalRepository = bookedIntervalRepository;
    }

    @Override
    public Reservation bookInterval(Reservation reservation) {
        return bookedIntervalRepository.save(reservation);
    }

    @Override
    public List<Reservation> getByUnitId(long id) {
        return bookedIntervalRepository.getByAccommodationUnit_Id(id);
    }

    @Override
    public List<Reservation> getAll() {
        return bookedIntervalRepository.findAll();
    }

    @Override
    public void saveReservations(List<Reservation> reservations) {
        bookedIntervalRepository.saveAll(reservations);
    }

    @Override
    public Reservation getById(long id) {
        return bookedIntervalRepository.getOne(id);
    }

    @Override
    public List<Reservation> getAllUnconfirmed() {
        return bookedIntervalRepository.getByConfirmedFalse();
    }
}
