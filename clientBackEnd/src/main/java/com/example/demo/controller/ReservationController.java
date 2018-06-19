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
@PreAuthorize("GUEST")
public class ReservationController {

    @Autowired
    ReservationService reservationService;
    @Autowired
    AccommodationService accommodationService;


    @RequestMapping(method = RequestMethod.POST, consumes = "application/json")
    public void reserve(@RequestBody Reservation reservation){
       reservationService.reserve(reservation);
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.DELETE)
    public void cancel( @PathVariable("id") Long id){
       reservationService.cancel(id);
    }

    @RequestMapping( method = RequestMethod.GET, produces = "application/json")
    public List<Reservation> getAll(){
        return reservationService.getByUser();
    }

    @RequestMapping( value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public Reservation get( @PathVariable("id") Long id){
        return reservationService.getById(id);
    }



}
