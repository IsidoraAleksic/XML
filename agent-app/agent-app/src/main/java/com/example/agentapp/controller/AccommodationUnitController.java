package com.example.agentapp.controller;

import com.example.agentapp.domain.*;
import com.example.agentapp.domain.dto.AccommodationUnitForm;
import com.example.agentapp.service.AccommodationAttributeService;
import com.example.agentapp.service.AccommodationPricingService;
import com.example.agentapp.service.AccommodationUnitService;
import com.example.agentapp.service.AuthenticationService;
import com.example.agentapp.service.ws.impl.AccommodationUnitWSGet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/accommodationUnit")
@CrossOrigin
public class AccommodationUnitController {

    public static final long TEMP_ID = 10111011;

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private AccommodationUnitWSGet accommodationUnitWSGet;

    @Autowired
    private AccommodationPricingService accommodationPricingService;

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
        System.out.println("Logged in user USERNAME : +++++++" + authenticationService.getLoggedInEmail());
        return accommodationUnitService.getAllUnits();
    }

    @GetMapping("/{unitId}")
    public AccommodationUnit getById(@PathVariable("unitId") long id) {
        return accommodationUnitService.getUnit(id);
    }

    @GetMapping("/get/{creatorId}") // nece ni trebat
    public List<AccommodationUnit> getUnitsByCreator(@PathVariable("creatorId") long agentId) {
//        Long loggedInId = authenticationService.getLoggedInEmail();
        return accommodationUnitService.getUnitsByCreator(agentId);
    }

//    @PostMapping(consumes = "application/json")
//    public AccommodationUnit addAccommodationUnit(@RequestBody AccommodationUnit unit) {
//        AccommodationType type = accommodationAttributeService.getTypeByName(unit.getAccommodationType().getTypeName());
//        AccommodationCategory category = accommodationAttributeService.getCategoryByName(unit.getCategory().getCategoryName());
//        List<AdditionalService> services = accommodationAttributeService
//                .getAdditionalServicesByNames(unit.getAdditionalServices()
//                .stream()
//                .map(el -> el.getName()).collect(Collectors.toList()));
//
//        unit.setAccommodationType(type);
//        unit.setCategory(category);
//        unit.setAdditionalServices(services);
//
//        return accommodationUnitService.addUnit(unit);
//    }

    @PostMapping(consumes = "application/json")
    public AccommodationUnit addAccommodationUnit(@RequestBody AccommodationUnitForm unit) {
        AccommodationUnit accommodationUnit = new AccommodationUnit();

        AccommodationType type = accommodationAttributeService.getTypeByName(unit.getAccommodationType().getTypeName());
        AccommodationCategory category = accommodationAttributeService.getCategoryByName(unit.getCategory().getCategoryName());
        List<AdditionalService> services = accommodationAttributeService
                .getAdditionalServicesByNames(unit.getAdditionalServices()
                        .stream()
                        .map(el -> el.getName()).collect(Collectors.toList()));

        accommodationUnit.setId(TEMP_ID);
        accommodationUnit.setAccommodationType(type);
        accommodationUnit.setCategory(category);
        accommodationUnit.setAdditionalServices(services);
        accommodationUnit.setAgent(unit.getAgent());
        accommodationUnit.setCapacity(unit.getCapacity());
        accommodationUnit.setDescription(unit.getDescription());
        accommodationUnit.setPlace(unit.getPlace());
        AccommodationUnit saved = accommodationUnitService.addUnit(accommodationUnit);

        AccommodationPricing accommodationPricing = unit.getAccommodationPricing();
        accommodationPricing.setId(TEMP_ID);
        accommodationPricing.setAccommodationUnit(saved);
        accommodationPricingService.save(accommodationPricing);

        return saved;
    }

}
