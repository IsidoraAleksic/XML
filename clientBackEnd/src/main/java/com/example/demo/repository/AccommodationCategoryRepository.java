package com.example.demo.repository;

import com.example.demo.model.AccommodationCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccommodationCategoryRepository extends JpaRepository<AccommodationCategory,Long> {

    AccommodationCategory getById(Long id);


    AccommodationCategory getByCategoryName(String name);
}