package com.example.demo.service.impl;

import com.example.demo.model.AccommodationUnit;
import com.example.demo.model.Reservation;
import com.example.demo.model.User;
import com.example.demo.repository.ReservationRepository;
import com.example.demo.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    @Override
    public void save(Reservation reservation) {
        reservationRepository.save(reservation);
    }

    @Override
    public void delete(Reservation reservation) {
        reservationRepository.delete(reservation);
    }

    @Override
    public Reservation getById(Long id) {
        return reservationRepository.getById(id);
    }

    @Override
    public Reservation getByAccommodationUnit(AccommodationUnit accommodationUnit) {
        return reservationRepository.getByAccommodationUnit(accommodationUnit);
    }

    @Override
    public Reservation getByStartDateBeforeAndEndDateAfter(Date endDate, Date startDate) {
        return reservationRepository.getByStartDateBeforeAndEndDateAfter(endDate,startDate);
    }

    @Override
    public Reservation getByUser(User user) {
        return reservationRepository.getByUser(user);
    }

    @Override
    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }
}
