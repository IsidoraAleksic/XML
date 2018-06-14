package com.example.demo.service.impl;

import com.example.demo.model.AccommodationCategory;
import com.example.demo.model.AccommodationType;
import com.example.demo.model.AdditionalServices;
import com.example.demo.repository.AccommodationCategoryRepository;
import com.example.demo.repository.AccommodationTypeRepository;
import com.example.demo.repository.AdditionalServicesRepository;
import com.example.demo.service.AccommodationOptionServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccommodationOptionServicesImpl implements AccommodationOptionServices {

    @Autowired
    AccommodationCategoryRepository accommodationCategoryRepository;
    @Autowired
    AccommodationTypeRepository accommodationTypeRepository;
    @Autowired
    AdditionalServicesRepository additionalServicesRepository;


    @Override
    public AdditionalServices getServiceById(Long id) {
        return additionalServicesRepository.getById(id);
    }

    @Override
    public AccommodationType getTypeById(Long id) {
        return accommodationTypeRepository.getById(id);
    }

    @Override
    public AccommodationCategory getCategoryById(Long id) {
        return accommodationCategoryRepository.getById(id);
    }
}
