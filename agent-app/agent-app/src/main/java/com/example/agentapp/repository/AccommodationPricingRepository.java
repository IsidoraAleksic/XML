package com.example.agentapp.repository;

import com.example.agentapp.domain.AccommodationPricing;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccommodationPricingRepository extends JpaRepository<AccommodationPricing, Long> {

    AccommodationPricing findByAccommodationUnit_Id(long unitId);

}
