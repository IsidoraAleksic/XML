package com.example.agentapp.event;

import com.example.agentapp.domain.AccommodationPhoto;
import com.example.agentapp.domain.AccommodationPricing;
import com.example.agentapp.domain.AccommodationUnit;
import com.example.agentapp.service.AccommodationPhotoService;
import com.example.agentapp.service.AccommodationPricingService;
import com.example.agentapp.service.AccommodationUnitService;
import com.example.agentapp.service.FileService;
import com.example.agentapp.service.ws.impl.AccommodationUnitWSSend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import schema.wsdl.CreateAccommodationResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Component
public class CreateAccommodationEventListener implements ApplicationListener<OnCreateAccommodationEvent> {

    @Autowired
    AccommodationPhotoService accommodationPhotoService;

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

        CreateAccommodationResponse res = wsSend.createAccommodationUnit(accommodationUnit, accommodationPricing, base64encodedImages);

        AccommodationUnit newUnit = new AccommodationUnit(res.getIdAccommodation(), accommodationUnit.getPlace(), accommodationUnit.getDescription(),
                accommodationUnit.getCapacity(), accommodationUnit.getAccommodationType(), accommodationUnit.getCategory(), accommodationUnit.getAdditionalServices(),
                accommodationUnit.getAgent());
        AccommodationUnit retUnit = accommodationUnitService.addUnit(newUnit);

        AccommodationPricing newPricing = new AccommodationPricing(res.getIdPricing(), retUnit, accommodationPricing.getJanuary(), accommodationPricing.getFebruary(),
                accommodationPricing.getMarch(), accommodationPricing.getApril(), accommodationPricing.getMay(), accommodationPricing.getJune(),
                accommodationPricing.getJuly(), accommodationPricing.getAugust(), accommodationPricing.getSeptember(), accommodationPricing.getOctober(),
                accommodationPricing.getNovember(), accommodationPricing.getDecember());
        accommodationPricingService.save(newPricing);

        List<AccommodationPhoto> accommodationPhotos = new ArrayList<>();
        IntStream.range(0, res.getIdImage().size())
                .forEach(i -> {
                    accommodationPhotos.add(new AccommodationPhoto(res.getIdImage().get(i), newUnit, fNames.get(i)));
                });
        accommodationPhotoService.saveAccommodationUnitPhotos(accommodationPhotos);

        accommodationPricingService.delete(accommodationPricing);
        accommodationUnitService.delete(accommodationUnit);
    }
}
