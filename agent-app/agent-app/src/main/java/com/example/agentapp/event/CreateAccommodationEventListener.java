package com.example.agentapp.event;

import com.example.agentapp.controller.AccommodationUnitController;
import com.example.agentapp.domain.AccommodationPricing;
import com.example.agentapp.domain.AccommodationUnit;
import com.example.agentapp.service.AccommodationPricingService;
import com.example.agentapp.service.AccommodationUnitService;
import com.example.agentapp.service.FileService;
import com.example.agentapp.service.ws.impl.AccommodationUnitWSSend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class CreateAccommodationEventListener implements ApplicationListener<OnCreateAccommodationEvent> {

    @Autowired
    AccommodationPricingService accommodationPricingService;

    @Autowired
    AccommodationUnitService accommodationUnitService;

    @Autowired
    FileService fileService;

    @Autowired
    AccommodationUnitWSSend wsSend;

    @Override
    public void onApplicationEvent(OnCreateAccommodationEvent onCreateAccommodationEvent) {
        List<String> fNames = onCreateAccommodationEvent.getFileNames();
        long tempId = onCreateAccommodationEvent.getTempUnitId();

        AccommodationUnit accommodationUnit = accommodationUnitService.getUnit(tempId);
        AccommodationPricing accommodationPricing = accommodationPricingService.getByAccommodationUnitId(tempId);

        List<String> base64encodedImages = new ArrayList<>();
        for (String fName : fNames) {
            String encodedImage = "";
            try {
                encodedImage = fileService.getImageAsBase64String(fName);
            } catch (IOException e) {
                e.printStackTrace();
            }
            base64encodedImages.add(encodedImage);
        }

        wsSend.createAccommodationUnit(accommodationUnit, accommodationPricing, base64encodedImages);

        accommodationUnitService.delete(accommodationUnit);
        accommodationPricingService.delete(accommodationPricing);
    }
}
