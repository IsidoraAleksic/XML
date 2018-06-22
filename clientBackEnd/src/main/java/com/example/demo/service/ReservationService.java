package com.example.demo.service;

import com.example.demo.model.AccommodationUnit;
import com.example.demo.model.Reservation;
import com.example.demo.model.User;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.List;

@Service
public interface ReservationService {

    void save(Reservation reservation);
    void delete(Reservation reservation);
    Reservation getById(Long id);
    Date toDate(String date);
    List<Reservation> getByAccommodationUnit(AccommodationUnit accommodationUnit);
    void reserve( Reservation reservation);


    boolean check(Reservation reservation);

    void cancel(Long id);
    int getByAccommodationUnitAndStartDateBeforeAndEndDateAfter(AccommodationUnit accommodationUnit,Date endDate, Date startDate);
    List<Reservation>  getByUser();
    List<Reservation> getAll();
}
