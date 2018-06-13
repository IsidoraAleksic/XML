package com.example.agentapp.repository;

import com.example.agentapp.domain.BookedInterval;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookedIntervalRepository extends JpaRepository<BookedInterval, Long> {

    List<BookedInterval> getByAccommodationUnit_Id(long id);

}
