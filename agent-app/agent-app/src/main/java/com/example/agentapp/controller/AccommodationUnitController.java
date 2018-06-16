package com.example.agentapp.controller;

import com.example.agentapp.domain.AccommodationCategory;
import com.example.agentapp.domain.AccommodationType;
import com.example.agentapp.domain.AccommodationUnit;
import com.example.agentapp.domain.AdditionalService;
import com.example.agentapp.service.AccommodationAttributeService;
import com.example.agentapp.service.AccommodationUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/accommodationUnit")
public class AccommodationUnitController {

    private AccommodationUnitService accommodationUnitService;
    private AccommodationAttributeService accommodationAttributeService;

    @Autowired
    public AccommodationUnitController(AccommodationUnitService accommodationUnitService, AccommodationAttributeService accommodationAttributeService) {
        this.accommodationUnitService = accommodationUnitService;
        this.accommodationAttributeService = accommodationAttributeService;
    }

//-------TEST
    @GetMapping("/all")
    public List<AccommodationUnit> getAllUnits() {
        return accommodationUnitService.getAllUnits();
    }

    @GetMapping("/{unitId}")
    public AccommodationUnit getById(@PathVariable("unitId") long id) {
        return accommodationUnitService.getUnit(id);
    }

    @GetMapping("/get/{creatorId}")
    public List<AccommodationUnit> getUnitsByCreator(@PathVariable("creatorId") long agentId) {
        return accommodationUnitService.getUnitsByCreator(agentId);
    }

    @PostMapping(consumes = "application/json")
    public AccommodationUnit addAccommodationUnit(@RequestBody AccommodationUnit unit) {
        AccommodationType type = accommodationAttributeService.getTypeByName(unit.getAccommodationType().getTypeName());
        AccommodationCategory category = accommodationAttributeService.getCategoryByName(unit.getCategory().getCategoryName());
        List<AdditionalService> services = accommodationAttributeService
                .getAdditionalServicesByNames(unit.getAdditionalServices()
                .stream()
                .map(el -> el.getName()).collect(Collectors.toList()));

        unit.setAccommodationType(type);
        unit.setCategory(category);
        unit.setAdditionalServices(services);

        return accommodationUnitService.addUnit(unit);
    }

}
