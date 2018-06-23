package com.example.agentapp.service.ws.impl;

import com.example.agentapp.domain.AccommodationPricing;
import com.example.agentapp.domain.AccommodationUnit;
import com.example.agentapp.ws.WSClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccommodationUnitWSSend {

    @Autowired
    private WSClient wsClient;

    public AccommodationUnit createAccommodationUnit(AccommodationUnit unit, AccommodationPricing pricing,
                                                        List<String> encodedImages) {

        wsClient.createAccommodation(unit, pricing, encodedImages);

        return null;
    }


}
