package com.example.demo.repository;

import com.example.demo.model.AccommodationCategory;
import com.example.demo.model.AccommodationType;
import com.example.demo.model.AccommodationUnit;
import com.example.demo.model.AdditionalServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccommodationRepository extends JpaRepository<AccommodationUnit,Long> {

    AccommodationUnit getById(Long id);
    List<AccommodationUnit> getByPlaceAndCapacity(String place,int capacity);
    List<AccommodationUnit> getByPlaceAndCapacityAndAccommodationTypeAndCategoryAndAdditionalServicesIn
            (String place, int capacity, AccommodationType accommodationType, AccommodationCategory accommodationCategory,
             List<AdditionalServices> additionalServices);

//    List<AccommodationUnit> getByCityAndCapacity(String city, int capacity);
//
//    List<AccommodationUnit> getByPlaceAndCapacityAndAccommodationTypeAndCategoryAndWifiAndParkingAndTvAndKitchenAndPrivateBathroomAndPansion
//            (String place, int capacity, AccommodationType accommodationType, int category,
//             boolean wifi, boolean parking, boolean kitchen, boolean bathroom, FoodService pansion);
}