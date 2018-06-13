package com.example.agentapp.service.impl;

import com.example.agentapp.domain.AccommodationUnit;
import com.example.agentapp.repository.AccommodationUnitRepository;
import com.example.agentapp.service.AccommodationUnitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccommodationUnitServiceImpl implements AccommodationUnitService {

    private AccommodationUnitRepository accommodationUnitRepository;

    @Autowired
    public AccommodationUnitServiceImpl(AccommodationUnitRepository unitRepository) {
        accommodationUnitRepository = unitRepository;
    }

    @Override
    public AccommodationUnit getUnit(long id) {
        return accommodationUnitRepository.getOne(id);
    }

    @Override
    public List<AccommodationUnit> getAllUnits() {
        return accommodationUnitRepository.findAll();
    }

    @Override
    public AccommodationUnit addUnit(AccommodationUnit unit) {
        return accommodationUnitRepository.save(unit);
    }
}
