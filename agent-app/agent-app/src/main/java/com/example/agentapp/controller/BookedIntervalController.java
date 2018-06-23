package com.example.agentapp.controller;

import com.example.agentapp.domain.AccommodationUnit;
import com.example.agentapp.domain.Reservation;
import com.example.agentapp.domain.dto.BookFromTo;
import com.example.agentapp.domain.dto.BookedIntervals;
import com.example.agentapp.service.AccommodationUnitService;
import com.example.agentapp.service.BookedIntervalService;
import com.example.agentapp.service.ws.impl.AccommodationUnitWSSend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.datatype.DatatypeConfigurationException;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookedIntervalController {

    @Autowired
    AccommodationUnitWSSend wsSend;

    private BookedIntervalService bookedIntervalService;
    private AccommodationUnitService accommodationUnitService;

    public BookedIntervalController(BookedIntervalService bookedIntervalService, AccommodationUnitService accommodationUnitService) {
        this.bookedIntervalService = bookedIntervalService;
        this.accommodationUnitService = accommodationUnitService;
    }

    @GetMapping("/get/{unitId}")
    public List<Reservation> getBookedIntervalsFromUnit(@PathVariable("unitId") long id) {
        List<Reservation> ints = bookedIntervalService.getByUnitId(id);
        return bookedIntervalService.getByUnitId(id);
    }

    @PostMapping(path = "/bookInterval")
    public boolean bookInterval(@RequestBody BookFromTo fromTo) throws DatatypeConfigurationException {
        AccommodationUnit accommodationUnit = accommodationUnitService.getUnit(fromTo.getUnitId());

        BookedIntervals ret = wsSend.bookInterval(new Reservation(fromTo.getFrom(), fromTo.getTo(), accommodationUnit));
        bookedIntervalService.saveReservations(ret.getReservationList());

        return ret.isSuccess();
    }

    @GetMapping(path = "/getAll")
    public List<Reservation> getAll() {
        return bookedIntervalService.getAll();
    }
}
