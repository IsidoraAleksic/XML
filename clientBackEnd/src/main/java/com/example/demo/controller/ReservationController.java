package com.example.demo.controller;

import com.example.demo.model.AccommodationUnit;
import com.example.demo.model.Reservation;
import com.example.demo.service.AccommodationService;
import com.example.demo.service.ReservationService;
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
                                                  @RequestParam("type") String type ){
        if (place==null || place.equals("") ||startDate==null || startDate.equals("") ||endDate==null || endDate.equals("") ||people==0 )
            return null;

        List<AccommodationUnit> accommodations = accommodationService.getByPlaceAndCapacity(place,people);
        List<AccommodationUnit> ret  = search(accommodations,startDate,endDate);
        return ret;
    }

    public List<AccommodationUnit> search(List<AccommodationUnit> accommodations,Date startDate,Date endDate) {
        List<AccommodationUnit> ret = new ArrayList<>();
        ret.addAll(accommodations);
        List<Reservation> reservations = reservationService.getAll();
        for (Reservation reservation : reservations) {
            for (AccommodationUnit accommodation : accommodations) {
                if (reservation.getAccommodationUnit().getId() == accommodation.getId()
                        && reservationService.getByStartDateBeforeAndEndDateAfter(endDate, startDate) != null) {
                    ret.remove(accommodation);

                }
            }
        }
        return ret;
    }


}
