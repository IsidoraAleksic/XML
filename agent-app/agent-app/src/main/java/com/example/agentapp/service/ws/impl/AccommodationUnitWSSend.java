package com.example.agentapp.service.ws.impl;

import com.example.agentapp.domain.AccommodationPricing;
import com.example.agentapp.domain.AccommodationUnit;
import com.example.agentapp.service.AccommodationUnitService;
import com.example.agentapp.ws.WSClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import schema.wsdl.CreateAccommodationResponse;

import java.util.List;

@Service
public class AccommodationUnitWSSend {

    @Autowired
    private WSClient wsClient;

    @Autowired
    private AccommodationUnitService accommodationUnitService;

    public CreateAccommodationResponse createAccommodationUnit(AccommodationUnit unit, AccommodationPricing pricing,
                                                        List<String> encodedImages) {

        CreateAccommodationResponse response = wsClient.createAccommodation(unit, pricing, encodedImages);
        return response;
    }


}
