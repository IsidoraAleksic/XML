package com.example.demo.service;

import com.example.demo.model.AccommodationUnit;
import com.example.demo.model.Reservation;
import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface ReservationService {

    void save(Reservation reservation);
    void delete(Reservation reservation);
    Reservation getById(Long id);
    Reservation getByAccommodationUnit(AccommodationUnit accommodationUnit);
    Reservation getByStartDateBeforeAndEndDateAfter(Date endDate, Date startDate);
    Reservation getByUser(User user);
    List<Reservation> getAll();
}