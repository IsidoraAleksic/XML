package com.example.agentapp.repository;

import com.example.agentapp.domain.AccommodationUnitCreator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccommodationUnitCreatorRepository extends JpaRepository<AccommodationUnitCreator, Long> {

    List<AccommodationUnitCreator> getByCreator_Id(long id);
}
