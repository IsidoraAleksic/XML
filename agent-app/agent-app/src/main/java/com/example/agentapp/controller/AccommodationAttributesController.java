package com.example.agentapp.controller;

import com.example.agentapp.domain.dto.AccommodationAttributes;
import com.example.agentapp.service.AccommodationAttributeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/attributes")
public class AccommodationAttributesController {

    private AccommodationAttributeService accommodationAttributeService;

    public AccommodationAttributesController(AccommodationAttributeService accommodationAttributeService) {
        this.accommodationAttributeService = accommodationAttributeService;
    }

    @GetMapping
    public AccommodationAttributes getAttributes() {
        return accommodationAttributeService.getAccommodationAttributes();
    }

}
