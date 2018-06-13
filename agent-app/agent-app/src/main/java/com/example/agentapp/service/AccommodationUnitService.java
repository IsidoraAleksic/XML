package com.example.agentapp.service;

import com.example.agentapp.domain.AccommodationUnit;

import java.util.List;

public interface AccommodationUnitService {

    AccommodationUnit getUnit(long id);

    List<AccommodationUnit> getAllUnits();

    AccommodationUnit addUnit(AccommodationUnit unit);
}
