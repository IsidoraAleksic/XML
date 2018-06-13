package com.example.agentapp.controller;

import com.example.agentapp.domain.AccommodationUnit;
import com.example.agentapp.domain.BookedInterval;
import com.example.agentapp.domain.dto.BookFromTo;
import com.example.agentapp.service.AccommodationUnitService;
import com.example.agentapp.service.BookedIntervalService;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookedIntervalController {

    private BookedIntervalService bookedIntervalService;
    private AccommodationUnitService accommodationUnitService;

    public BookedIntervalController(BookedIntervalService bookedIntervalService, AccommodationUnitService accommodationUnitService) {
        this.bookedIntervalService = bookedIntervalService;
        this.accommodationUnitService = accommodationUnitService;
    }

    @GetMapping("/get/{unitId}")
    public List<BookedInterval> getBookedIntervalsFromUnit(@PathVariable("unitId") long id) {
        return bookedIntervalService.getByUnitId(id);
    }

    @PostMapping(path = "/bookInterval")
    public BookedInterval bookInterval(@RequestBody BookFromTo fromTo) {
        AccommodationUnit accommodationUnit = accommodationUnitService.getUnit(fromTo.getUnitId());
        return bookedIntervalService.bookInterval(new BookedInterval(fromTo.getFrom(), fromTo.getTo(), accommodationUnit));
    }
}
