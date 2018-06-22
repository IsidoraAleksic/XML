package com.example.demo.service;

import com.example.demo.model.AccommodationCategory;
import com.example.demo.model.AccommodationType;
import com.example.demo.model.AdditionalServices;
import com.example.demo.model.dto.SearchParameters;
import org.springframework.stereotype.Service;


public interface AccommodationOptionService {

    AdditionalServices getServiceById(Long id);
    AccommodationType getTypeById(Long id);
    AccommodationCategory getCategoryById(Long id);
    SearchParameters getParameters();
}
