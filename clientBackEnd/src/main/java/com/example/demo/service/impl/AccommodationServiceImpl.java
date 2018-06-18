package com.example.demo.service.impl;

import com.example.demo.model.*;
import com.example.demo.repository.AccommodationPricingRepository;
import com.example.demo.repository.AccommodationRepository;
import com.example.demo.repository.ReservationRepository;
import com.example.demo.service.AccommodationOptionService;
import com.example.demo.service.AccommodationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

@Service
public class AccommodationServiceImpl implements AccommodationService {

    @Autowired
    AccommodationRepository accommodationRepository;
    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    AccommodationOptionService accommodationOptionServices;
    @Autowired
    AccommodationPricingRepository accommodationPricingRepository;

    @Override
    public void save(AccommodationUnit accommodationUnit) {
        accommodationRepository.save(accommodationUnit);
    }

    @Override
    public void delete(AccommodationUnit accommodationUnit) {
        accommodationRepository.delete(accommodationUnit);
    }

    @Override
    public AccommodationUnit getById(Long id) {
        return accommodationRepository.getById(id);
    }

    @Override
    public List<AccommodationUnit> getAll() {
        return accommodationRepository.findAll();
    }

    @Override
    public List<AccommodationPricing> basicSearch(String place, Date startDate, Date endDate, int people) {
        if (place==null || place.equals("") ||startDate==null || startDate.equals("") ||
                endDate==null || endDate.equals("") ||people==0 )
            return null;
        List<AccommodationUnit> accommodations = getByPlaceAndCapacity(place,people);
        List<AccommodationUnit> ret  = search(accommodations,startDate,endDate);

        List<AccommodationPricing> accommodationPricings = new ArrayList<>();
        for(AccommodationUnit accommodationUnit: ret)
            accommodationPricings.add(accommodationPricingRepository.getByAccommodationUnit(accommodationUnit));

        return accommodationPricings;
    }

    @Override
    public List<AccommodationPricing> advancedSearch(String place, Date startDate, Date endDate, int people, Long type, Long category, List<Long> additionalServices) {
        if (place==null || place.equals("") ||startDate==null || startDate.equals("") ||
                endDate==null || endDate.equals("") ||people==0 )
            return null;
        AccommodationType accommodationType = accommodationOptionServices.getTypeById(type);
        AccommodationCategory accommodationCategory = accommodationOptionServices.getCategoryById(category);

        List<AdditionalServices> additionalServices1 = new ArrayList<>();
        for (Long id: additionalServices){
            additionalServices1.add(accommodationOptionServices.getServiceById(id));
        }
        List<AccommodationUnit> accommodations = getByAllCriteria(place,people,accommodationType,accommodationCategory,additionalServices1);
        List<AccommodationUnit> accommodationUnits  = search(accommodations,startDate,endDate);
        List<AccommodationPricing> accommodationPricings = new ArrayList<>();
        for(AccommodationUnit accommodationUnit: accommodationUnits)
            accommodationPricings.add(accommodationPricingRepository.getByAccommodationUnit(accommodationUnit));

        return accommodationPricings;
    }

    @Override
    public List<AccommodationUnit> getByPlaceAndCapacity(String place, int capacity) {
        return accommodationRepository.getByPlaceAndCapacity(place,capacity);
    }

    @Override
    public List<AccommodationUnit> getByAllCriteria(String place, int capacity, AccommodationType accommodationType, AccommodationCategory accommodationCategory, List<AdditionalServices> additionalServices) {
        return accommodationRepository.getByPlaceAndCapacityAndAccommodationTypeAndCategoryAndAdditionalServicesIn(
                place,capacity,accommodationType,accommodationCategory,additionalServices);
    }
    @Override
    public List<AccommodationUnit> search(List<AccommodationUnit> accommodations, Date startDate, Date endDate) {
        List<AccommodationUnit> ret = new ArrayList<>();
        ret.addAll(accommodations);
        for (AccommodationUnit accommodation : accommodations) {
            if (reservationRepository.countByAccommodationUnitAndStartDateBeforeAndEndDateAfter(accommodation, endDate, startDate)!=0 ) {
                ret.remove(accommodation);
            }
        }

        return ret;
    }
}
