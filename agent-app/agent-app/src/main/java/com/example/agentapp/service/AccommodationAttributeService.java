package com.example.agentapp.service;

import com.example.agentapp.domain.AccommodationCategory;
import com.example.agentapp.domain.AccommodationType;
import com.example.agentapp.domain.AdditionalService;
import com.example.agentapp.domain.dto.AccommodationAttributes;

import java.util.List;

public interface AccommodationAttributeService {

    AccommodationAttributes getAccommodationAttributes();

    AccommodationType getTypeByName(String typeName);

    AccommodationCategory getCategoryByName(String categoryName);

    List<AdditionalService> getAdditionalServicesByNames(List<String> additionalServiceName);

    void insertAccommodationCategories(List<AccommodationCategory> categories);

    void insertAccommodationTypes(List<AccommodationType> types);

    void insertAdditionalServices(List<AdditionalService> services);
}
