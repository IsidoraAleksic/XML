package com.example.agentapp.service.impl;

import com.example.agentapp.domain.AccommodationPhoto;
import com.example.agentapp.domain.AccommodationUnit;
import com.example.agentapp.repository.AccommodationPhotoRepository;
import com.example.agentapp.repository.AccommodationUnitRepository;
import com.example.agentapp.service.AccommodationPhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AccommodationPhotoServiceImpl implements AccommodationPhotoService{

    private AccommodationPhotoRepository accommodationPhotoRepository;
    private AccommodationUnitRepository accommodationUnitRepository;

    @Autowired
    public AccommodationPhotoServiceImpl(AccommodationPhotoRepository photoRepository, AccommodationUnitRepository unitRepository) {
        accommodationPhotoRepository = photoRepository;
        accommodationUnitRepository = unitRepository;
    }

    @Override
    public List<AccommodationPhoto> getPhotosByAccommodationUnitId(long id) {
        return accommodationPhotoRepository.findByAccommodationUnitId(id);
    }

//    @Override
//    public void saveUnitPhotos(long accPhotoId, long unitId, List<String> paths) {
//        AccommodationUnit unit = accommodationUnitRepository.getOne(unitId);
//        List<AccommodationPhoto> photos = paths.stream()
//                .map(el -> new AccommodationPhoto(unit, el))
//                .collect(Collectors.toList());
//        accommodationPhotoRepository.saveAll(photos);
//    }

    @Override
    public void saveAccommodationUnitPhotos(List<AccommodationPhoto> photos) {
        accommodationPhotoRepository.saveAll(photos);
    }
}
