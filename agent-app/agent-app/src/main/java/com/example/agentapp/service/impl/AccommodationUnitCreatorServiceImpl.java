package com.example.agentapp.service.impl;

import com.example.agentapp.domain.AccommodationUnit;
import com.example.agentapp.domain.AccommodationUnitCreator;
import com.example.agentapp.repository.AccommodationUnitCreatorRepository;
import com.example.agentapp.repository.AccommodationUnitRepository;
import com.example.agentapp.service.AccommodationUnitCreatorService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccommodationUnitCreatorServiceImpl implements AccommodationUnitCreatorService {

    private AccommodationUnitCreatorRepository accommodationUnitCreatorRepository;
    private AccommodationUnitRepository accommodationUnitRepository;

    public AccommodationUnitCreatorServiceImpl(AccommodationUnitCreatorRepository accommodationUnitCreatorRepository,
                                               AccommodationUnitRepository accommodationUnitRepository) {
        this.accommodationUnitCreatorRepository = accommodationUnitCreatorRepository;
        this.accommodationUnitRepository = accommodationUnitRepository;
    }

    @Override
    public List<AccommodationUnit> getByCreator(long userId) {
        List<AccommodationUnitCreator> auc = accommodationUnitCreatorRepository.getByCreator_Id(userId);
        List<AccommodationUnit> units = auc.stream()
                .map(el -> accommodationUnitRepository.getOne(el.getId()))
                .collect(Collectors.toList());
        return units;
    }
}
