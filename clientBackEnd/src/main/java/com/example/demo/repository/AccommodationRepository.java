package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.AccommodationCategory;
import com.example.demo.model.AccommodationType;
import com.example.demo.model.AccommodationUnit;
import com.example.demo.model.AdditionalServices;

@Repository
public interface AccommodationRepository extends JpaRepository<AccommodationUnit,Long> {

	List<AccommodationUnit> getByAgent_Id(Long id);
    AccommodationUnit getById(Long id);
    List<AccommodationUnit> getByPlaceAndCapacity(String place,int capacity);
    List<AccommodationUnit> getByPlaceAndCapacityAndAccommodationTypeAndCategoryAndAdditionalServicesContains
            (String place, int capacity, AccommodationType accommodationType, AccommodationCategory accommodationCategory,
             List<AdditionalServices> additionalServices);
    
    @Query("select distinct a from AccommodationUnit a join a.additionalServices as s " + 
    		"where s in (:additionalServices) and a.place = (:place) and a.capacity = (:capacity) and a.accommodationType = (:accommodationType) and a.category = (:accommodationCategory) "
    		+ "group by a.id "
    		+ "having count(s.id) = :size" 
    		)
    List<AccommodationUnit> advancedSearch(@Param("place") String place,
    		@Param("capacity") int capacity, @Param("accommodationType") AccommodationType accommodationType, @Param("accommodationCategory") AccommodationCategory accommodationCategory,
    		@Param("additionalServices") List<AdditionalServices> additionalServices, @Param("size") Long size);

//    List<AccommodationUnit> getByCityAndCapacity(String city, int capacity);
//
//    List<AccommodationUnit> getByPlaceAndCapacityAndAccommodationTypeAndCategoryAndWifiAndParkingAndTvAndKitchenAndPrivateBathroomAndPansion
//            (String place, int capacity, AccommodationType accommodationType, int category,
//             boolean wifi, boolean parking, boolean kitchen, boolean bathroom, FoodService pansion);
}