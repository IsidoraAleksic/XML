package com.example.agentapp.repository;

import com.example.agentapp.domain.AccommodationCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccommodationCategoryRepository extends JpaRepository<AccommodationCategory, Long> {

    AccommodationCategory findByCategoryNameIgnoreCase(String categoryName);

}
