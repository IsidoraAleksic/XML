package com.example.agentapp.service;

import com.example.agentapp.domain.AccommodationUnit;

import java.util.List;

public interface AccommodationUnitCreatorService {

    List<AccommodationUnit> getByCreator(long userId);

}
