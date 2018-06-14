package com.example.demo.controller;

import com.example.demo.model.AccommodationCategory;
import com.example.demo.model.AccommodationType;
import com.example.demo.model.AccommodationUnit;
import com.example.demo.model.AdditionalServices;
import com.example.demo.service.AccommodationService;
import com.example.demo.service.ReservationService;
import com.example.demo.service.impl.AccommodationOptionServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/reserve")
public class ReservationController {

    @Autowired
    ReservationService reservationService;
    @Autowired
    AccommodationService accommodationService;
    @Autowired
    AccommodationOptionServicesImpl accommodationOptionServices;

    @RequestMapping(value = "/basicSearch", method = RequestMethod.GET, produces = "application/json")
    public List<AccommodationUnit> basicSearch(@RequestParam("place") String place,@RequestParam("startDate") Date startDate,
                                               @RequestParam("endDate") Date endDate, @RequestParam("people") int people){
            if (place==null || place.equals("") ||startDate==null || startDate.equals("") ||
                    endDate==null || endDate.equals("") ||people==0 )
                return null;
            List<AccommodationUnit> accommodations = accommodationService.getByPlaceAndCapacity(place,people);
            List<AccommodationUnit> ret  = search(accommodations,startDate,endDate);
            return ret;
    }

    @RequestMapping(value = "/advancedSearch", method = RequestMethod.GET, produces = "application/json")
    public List<AccommodationUnit> advancedSearch(@RequestParam("place") String place,@RequestParam("startDate") Date startDate,
                                                  @RequestParam("endDate") Date endDate, @RequestParam("people") int people,
                                                  @RequestParam("id") Long type, @RequestParam("id") Long category,
                                                  @RequestParam(value = "additionalServices[]") List<Long> additionalServices){
        if (place==null || place.equals("") ||startDate==null || startDate.equals("") ||
                endDate==null || endDate.equals("") ||people==0 )
            return null;
        AccommodationType accommodationType = accommodationOptionServices.getTypeById(type);
        AccommodationCategory accommodationCategory = accommodationOptionServices.getCategoryById(category);

        List<AdditionalServices> additionalServices1 = new ArrayList<>();
        for (Long id: additionalServices){
            additionalServices1.add(accommodationOptionServices.getServiceById(id));
        }
        List<AccommodationUnit> accommodations = accommodationService.getByAllCriteria(place,people,accommodationType,accommodationCategory,additionalServices1);
        List<AccommodationUnit> ret  = search(accommodations,startDate,endDate);
        return ret;
    }

    public List<AccommodationUnit> search(List<AccommodationUnit> accommodations,Date startDate,Date endDate) {
        List<AccommodationUnit> ret = new ArrayList<>();
        ret.addAll(accommodations);
            for (AccommodationUnit accommodation : accommodations) {
                if (reservationService.getByAccommodationUnitAndStartDateBeforeAndEndDateAfter(accommodation, endDate, startDate)!=0 ) {
                    ret.remove(accommodation);                }
            }
        return ret;
    }


}
