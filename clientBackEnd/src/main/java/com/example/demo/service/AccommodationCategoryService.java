package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.AccommodationCategory;
import com.example.demo.model.AdditionalServices;
import com.example.demo.model.dto.AccommodationCategoryDTO;

@Service
public interface AccommodationCategoryService {

	void save(AccommodationCategory accommodationCategory);
	AccommodationCategory findById(Long id);
	void delete(AccommodationCategory forDeleting);
    String update(Long id, AccommodationCategoryDTO accommodationCategoryDTO);
    List<AccommodationCategory> findAll();
}
