package com.example.demo.service;

import com.example.demo.model.*;
import com.example.demo.model.type.FoodService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccommodationService {

    void save(AccommodationUnit accommodationUnit);

    void delete(AccommodationUnit accommodationUnit);

    AccommodationUnit getById(Long id);

    List<AccommodationUnit> getAll();

    List<AccommodationUnit> getByPlaceAndCapacity(String place,int capacity);
    List<AccommodationUnit> getByAllCriteria
            (String place, int capacity, AccommodationType accommodationType, AccommodationCategory accommodationCategory,
             AdditionalServices additionalServices, FoodService foodService);
}
