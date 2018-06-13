package com.example.agentapp.service;

import com.example.agentapp.domain.AccommodationPhoto;

import java.util.List;

public interface AccommodationPhotoService {

    List<AccommodationPhoto> getPhotosByAccommodationUnitId(long id);

    void saveUnitPhotos(long id, List<String> paths);
}
