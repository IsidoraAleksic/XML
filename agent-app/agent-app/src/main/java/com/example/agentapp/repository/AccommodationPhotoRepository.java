package com.example.agentapp.repository;

import com.example.agentapp.domain.AccommodationPhoto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccommodationPhotoRepository extends JpaRepository<AccommodationPhoto, Long> {

    List<AccommodationPhoto> findByAccommodationUnitId(long id);

}
