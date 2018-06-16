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
    void reserve( Reservation reservation);
    void cancel( Long id);
    int getByAccommodationUnitAndStartDateBeforeAndEndDateAfter(AccommodationUnit accommodationUnit,Date endDate, Date startDate);
    List<Reservation>  getByUser();
    List<Reservation> getAll();
}
