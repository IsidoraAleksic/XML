package com.example.demo.service.impl;

import com.example.demo.model.AccommodationCategory;
import com.example.demo.model.AccommodationType;
import com.example.demo.model.AccommodationUnit;
import com.example.demo.model.AdditionalServices;
import com.example.demo.repository.AccommodationRepository;
import com.example.demo.service.AccommodationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccommodationServiceImpl implements AccommodationService {

    @Autowired
    AccommodationRepository accommodationRepository;


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
    public List<AccommodationUnit> getByPlaceAndCapacity(String place, int capacity) {
        return accommodationRepository.getByPlaceAndCapacity(place,capacity);
    }

    @Override
    public List<AccommodationUnit> getByAllCriteria(String place, int capacity, AccommodationType accommodationType, AccommodationCategory accommodationCategory, List<AdditionalServices> additionalServices) {
        return accommodationRepository.getByPlaceAndCapacityAndAccommodationTypeAndCategoryAndAdditionalServices(
                place,capacity,accommodationType,accommodationCategory,additionalServices);
    }

//    @Override
//    public List<AccommodationUnit> getByCityAndCapacity(String city, int capacity) {
//        return accommodationRepository.getByCityAndCapacity(city,capacity);
//    }
//
//    @Override
//    public List<AccommodationUnit> getByAllCriteria(
//            String place, int capacity, AccommodationType accommodationType,
//            int category, boolean wifi, boolean parking, boolean kitchen, boolean bathroom, FoodService pansion) {
//        return accommodationRepository.
//                getByPlaceAndCapacityAndAccommodationTypeAndCategoryAndWifiAndParkingAndTvAndKitchenAndPrivateBathroomAndPansion(
//                place,capacity,accommodationType,category,wifi,parking,kitchen,bathroom,pansion);
//    }
}
