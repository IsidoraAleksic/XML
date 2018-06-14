package com.example.demo.repository;

import com.example.demo.model.AccommodationUnit;
import com.example.demo.model.Reservation;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Long> {

    Reservation getById(Long id);
    Reservation getByAccommodationUnit(AccommodationUnit accommodationUnit);
    int countByAccommodationUnitAndStartDateBeforeAndEndDateAfter(AccommodationUnit accommodationUnit, Date endDate, Date startDate);
    Reservation getByUser(User user);
}
