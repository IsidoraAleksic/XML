package com.example.demo.controller;

import com.example.demo.model.AccommodationPricing;
import com.example.demo.model.dto.SearchParameters;
import com.example.demo.service.AccommodationOptionService;
import com.example.demo.service.AccommodationService;
import com.example.demo.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/search")
public class SearchController {

    @Autowired
    ReservationService reservationService;
    @Autowired
    AccommodationService accommodationService;
    @Autowired
    AccommodationOptionService accommodationOptionService;

    @RequestMapping(value = "/basicSearch", method = RequestMethod.GET, produces = "application/json")
    public List<AccommodationPricing> basicSearch(@RequestParam("place") String place, @RequestParam("startDate") String startDate,
                                                  @RequestParam("endDate") String endDate, @RequestParam("people") int people){

        Date date = null;
        try {
            SimpleDateFormat sdf1 = new SimpleDateFormat("MM/dd/yyyy");
            date = sdf1.parse(startDate);
            java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
            date = sdf1.parse(endDate);
            java.sql.Date sqlEndDate = new java.sql.Date(date.getTime());
            return accommodationService.basicSearch(place,sqlStartDate,sqlEndDate,people);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;

    }

    @RequestMapping( method = RequestMethod.GET, produces = "application/json")
    public SearchParameters getSearchParameters(){
        return accommodationOptionService.getParameters();
    }

    @RequestMapping(value = "/advancedSearch", method = RequestMethod.GET, produces = "application/json")
    public List<AccommodationPricing> advancedSearch(@RequestParam("place") String place,@RequestParam("startDate") String startDate,
                                                     @RequestParam("endDate") String endDate, @RequestParam("people") int people,
                                                     @RequestParam("id") Long type, @RequestParam("id") Long category,
                                                     @RequestParam(value = "additionalServices[]") List<Long> additionalServices){
        Date date = null;
        try {
            SimpleDateFormat sdf1 = new SimpleDateFormat("dd-MM-yyyy");
            date = sdf1.parse(startDate);
            java.sql.Date sqlStartDate = new java.sql.Date(date.getTime());
            date = sdf1.parse(endDate);
            java.sql.Date sqlEndDate = new java.sql.Date(date.getTime());
            return accommodationService.advancedSearch(place,sqlStartDate,sqlEndDate,people,type,category,additionalServices);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
