package com.example.demo.controller;

import com.example.demo.model.*;
import com.example.demo.service.AccommodationService;
import com.example.demo.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/reserve")
public class ReservationController {

    @Autowired
    ReservationService reservationService;
    @Autowired
    AccommodationService accommodationService;

    @PreAuthorize("GUEST")
    @RequestMapping(value = "/reserve", method = RequestMethod.POST, consumes = "application/json")
    public void reserve(@RequestBody Reservation reservation){
       reservationService.reserve(reservation);
    }

    @RequestMapping(value = "/cancel", method = RequestMethod.DELETE)
    public void cancel( @RequestParam("id") Long id){
       reservationService.cancel(id);
    }

    @RequestMapping(value = "/getAll", method = RequestMethod.GET, produces = "application/json")
    public List<Reservation> getAll(){
        return reservationService.getByUser();
    }


}
