package com.example.demo.service.impl;

import com.example.demo.exceptions.BadRequestException;
import com.example.demo.model.AccommodationUnit;
import com.example.demo.model.Reservation;
import com.example.demo.model.User;
import com.example.demo.repository.ReservationRepository;
import com.example.demo.service.AuthenticationService;
import com.example.demo.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    AuthenticationService authenticationService;

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
    public void reserve(Reservation reservation) {
        if(reservation==null){
            throw new BadRequestException("Reservation must not be null");
        }
        User user = authenticationService.getLoggedInUser();
        reservation.setUser(user);
        save(reservation);

    }

    @Override
    public void cancel(Long id) {
        Reservation reservation = getById(id);
        if(reservation==null){
            throw new BadRequestException("Reservation must not be null");
        }
        delete(reservation);
    }

    @Override
    public int getByAccommodationUnitAndStartDateBeforeAndEndDateAfter(AccommodationUnit accommodationUnit,Date endDate, Date startDate) {
        return reservationRepository.countByAccommodationUnitAndStartDateBeforeAndEndDateAfter(accommodationUnit,endDate,startDate);
    }

    @Override
    public List<Reservation>  getByUser() {
        User user = authenticationService.getLoggedInUser();
        return reservationRepository.getByUser(user);
    }

    @Override
    public List<Reservation> getAll() {
        return reservationRepository.findAll();
    }


}
