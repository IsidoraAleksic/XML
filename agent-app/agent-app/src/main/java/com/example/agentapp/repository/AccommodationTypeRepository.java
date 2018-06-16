package com.example.agentapp.repository;

import com.example.agentapp.domain.AccommodationType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccommodationTypeRepository extends JpaRepository<AccommodationType, Long> {

    AccommodationType findByTypeNameIgnoreCase(String name);
}
