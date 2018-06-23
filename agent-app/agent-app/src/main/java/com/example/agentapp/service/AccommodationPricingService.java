package com.example.agentapp.service;

import com.example.agentapp.domain.AccommodationPricing;

public interface AccommodationPricingService {

    AccommodationPricing getByAccommodationUnitId(long unitId);

    AccommodationPricing save(AccommodationPricing accommodationPricing);

    void delete(AccommodationPricing accommodationPricing);
}
