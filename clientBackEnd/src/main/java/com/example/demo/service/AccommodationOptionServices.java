package com.example.demo.service;

import com.example.demo.model.AccommodationCategory;
import com.example.demo.model.AccommodationType;
import com.example.demo.model.AdditionalServices;
import org.springframework.stereotype.Service;

@Service
public interface AccommodationOptionServices {

    AdditionalServices getServiceById(Long id);
    AccommodationType getTypeById(Long id);
    AccommodationCategory getCategoryById(Long id);
}
