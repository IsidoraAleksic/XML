package com.example.agentapp.repository;

import com.example.agentapp.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookedIntervalRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> getByAccommodationUnit_Id(long id);

    List<Reservation> getByConfirmedFalse();
}
