package com.example.agentapp.service.impl;

import com.example.agentapp.domain.AccommodationPricing;
import com.example.agentapp.repository.AccommodationPricingRepository;
import com.example.agentapp.service.AccommodationPricingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccommodationPricingServiceImpl implements AccommodationPricingService {

    @Autowired
    AccommodationPricingRepository accommodationPricingRepository;

    @Override
    public AccommodationPricing getByAccommodationUnitId(long unitId) {
        return accommodationPricingRepository.findByAccommodationUnit_Id(unitId);
    }

    @Override
    public AccommodationPricing save(AccommodationPricing accommodationPricing) {
        return accommodationPricingRepository.save(accommodationPricing);
    }

    @Override
    public void delete(AccommodationPricing accommodationPricing) {
        accommodationPricingRepository.delete(accommodationPricing);
    }
}
