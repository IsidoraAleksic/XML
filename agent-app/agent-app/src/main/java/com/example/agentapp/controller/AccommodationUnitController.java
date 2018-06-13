package com.example.agentapp.controller;

import com.example.agentapp.domain.AccommodationUnit;
import com.example.agentapp.service.AccommodationUnitCreatorService;
import com.example.agentapp.service.AccommodationUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accommodationUnit")
public class AccommodationUnitController {

    private AccommodationUnitService accommodationUnitService;
    private AccommodationUnitCreatorService accommodationUnitCreatorService;

    @Autowired
    public AccommodationUnitController(AccommodationUnitService accommodationUnitService,
                                       AccommodationUnitCreatorService accommodationUnitCreatorService) {

        this.accommodationUnitService = accommodationUnitService;
        this.accommodationUnitCreatorService = accommodationUnitCreatorService;
    }

//-------TEST
    @GetMapping("/all")
    public List<AccommodationUnit> getAllUnits() {
        return accommodationUnitService.getAllUnits();
    }

    @GetMapping("/get/{creatorId}")
    public List<AccommodationUnit> getUnitsByCreator(@PathVariable("creatorId") long userId) {
        return accommodationUnitCreatorService.getByCreator(userId);
    }

    @PostMapping
    public AccommodationUnit addAccommodationUnit(@RequestBody AccommodationUnit unit) {
        return accommodationUnitService.addUnit(unit);
    }

}
