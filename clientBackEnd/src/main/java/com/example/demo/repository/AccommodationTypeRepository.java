package com.example.demo.repository;

import com.example.demo.model.AccommodationType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccommodationTypeRepository extends JpaRepository<AccommodationType,Long> {

    AccommodationType getById(Long id);

    AccommodationType getByTypeName(String name);
}
