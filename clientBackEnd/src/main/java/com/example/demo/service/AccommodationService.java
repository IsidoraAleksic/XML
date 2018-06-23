package com.example.demo.service;

import com.example.demo.model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public interface AccommodationService {

    void save(AccommodationUnit accommodationUnit);

    void delete(AccommodationUnit accommodationUnit);

    AccommodationUnit getById(Long id);

    List<AccommodationUnit> getAll();

    Object basicSearch(String place, Date startDate, Date endDate, int people);

    Object advancedSearch(String place, Date startDate, Date endDate, int people,
                                              Long type, Long category, List<Long> additionalServices);

    List<AccommodationUnit> search(List<AccommodationUnit> accommodations, Date startDate, Date endDate);

    List<AccommodationUnit> getByPlaceAndCapacity(String place, int capacity);

    List<AccommodationUnit> getByAllCriteria
            (String place, int capacity, AccommodationType accommodationType, AccommodationCategory accommodationCategory,
             List<AdditionalServices> additionalServices);
}
