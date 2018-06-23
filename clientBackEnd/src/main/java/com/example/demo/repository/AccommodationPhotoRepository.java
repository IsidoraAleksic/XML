package com.example.demo.repository;

import com.example.demo.model.AccommodationPhoto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccommodationPhotoRepository extends JpaRepository<AccommodationPhoto,Long> {

    List<AccommodationPhoto> getByAccommodationUnit_Id(Long accommodationId);

}
