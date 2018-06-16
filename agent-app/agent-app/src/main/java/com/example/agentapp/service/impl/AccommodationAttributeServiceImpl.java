package com.example.agentapp.service.impl;

import com.example.agentapp.domain.AccommodationCategory;
import com.example.agentapp.domain.AccommodationType;
import com.example.agentapp.domain.AdditionalService;
import com.example.agentapp.domain.dto.AccommodationAttributes;
import com.example.agentapp.repository.AccommodationCategoryRepository;
import com.example.agentapp.repository.AccommodationTypeRepository;
import com.example.agentapp.repository.AdditionalServiceRepository;
import com.example.agentapp.service.AccommodationAttributeService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccommodationAttributeServiceImpl implements AccommodationAttributeService {

    private AccommodationTypeRepository accommodationTypeRepository;
    private AccommodationCategoryRepository accommodationCategoryRepository;
    private AdditionalServiceRepository additionalServiceRepository;

    public AccommodationAttributeServiceImpl(AccommodationTypeRepository accommodationTypeRepository, AccommodationCategoryRepository accommodationCategoryRepository,
                                             AdditionalServiceRepository additionalServiceRepository) {
        this.accommodationTypeRepository = accommodationTypeRepository;
        this.accommodationCategoryRepository = accommodationCategoryRepository;
        this.additionalServiceRepository = additionalServiceRepository;
    }

    @Override
    public AccommodationAttributes getAccommodationAttributes() {
        List<String> categories = accommodationCategoryRepository
                .findAll()
                .stream()
                .map(el -> el.getCategoryName())
                .collect(Collectors.toList());
        List<String> types = accommodationTypeRepository.
                findAll()
                .stream()
                .map(el -> el.getTypeName())
                .collect(Collectors.toList());
        List<String> options = additionalServiceRepository
                .findAll()
                .stream()
                .map(el -> el.getName())
                .collect(Collectors.toList());
        return new AccommodationAttributes(categories, types, options);
    }

    @Override
    public AccommodationCategory getCategoryByName(String name) {
        return accommodationCategoryRepository.findByCategoryNameIgnoreCase(name);
    }

    @Override
    public AccommodationType getTypeByName(String name) {
        return accommodationTypeRepository.findByTypeNameIgnoreCase(name);
    }

    @Override
    public List<AdditionalService> getAdditionalServicesByNames(List<String> names) {
       return additionalServiceRepository.findByNameInIgnoreCase(names);
    }

}
