package com.example.demo.repository;

import com.example.demo.model.AccommodationPricing;
import com.example.demo.model.AccommodationUnit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccommodationPricingRepository extends JpaRepository<AccommodationPricing,Long> {

    AccommodationPricing getByAccommodationUnit(AccommodationUnit accommodationUnit);
}
