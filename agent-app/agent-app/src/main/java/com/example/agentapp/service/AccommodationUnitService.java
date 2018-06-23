package com.example.agentapp.service;

import com.example.agentapp.domain.AccommodationUnit;

import java.util.List;

public interface AccommodationUnitService {


    AccommodationUnit getUnit(long id);

    List<AccommodationUnit> getAllUnits();

    List<AccommodationUnit> getUnitsByCreator(long id);

    AccommodationUnit addUnit(AccommodationUnit unit);

    void saveUnits(List<AccommodationUnit> units);

    void delete(AccommodationUnit accommodationUnit);

}
