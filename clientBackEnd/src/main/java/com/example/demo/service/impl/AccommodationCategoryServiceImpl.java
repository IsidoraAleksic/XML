package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.AccommodationCategory;
import com.example.demo.model.AccommodationType;
import com.example.demo.model.dto.AccommodationCategoryDTO;
import com.example.demo.repository.AccommodationCategoryRepository;
import com.example.demo.repository.AccommodationTypeRepository;
import com.example.demo.service.AccommodationCategoryService;

@Service
public class AccommodationCategoryServiceImpl implements AccommodationCategoryService {
	
	@Autowired
	AccommodationCategoryRepository accommodationCategoryRepository;

	public void save(AccommodationCategory accommodationCategory) {
		accommodationCategoryRepository.save(accommodationCategory);
		
	}

	public AccommodationCategory findById(Long id) {
		return accommodationCategoryRepository.getById(id);
	}

	public void delete(AccommodationCategory forDeleting) {
		accommodationCategoryRepository.delete(forDeleting);
		
	}

	public String update(Long id, AccommodationCategoryDTO accommodationCategoryDTO) {
		AccommodationCategory accommodationCategory = accommodationCategoryRepository.getById(id);
		if(!accommodationCategory.getId().equals(id)) {
			return "ERROR";
		}
		accommodationCategory.setCategoryName(accommodationCategoryDTO.getCategoryName());
		accommodationCategoryRepository.save(accommodationCategory);
		return "SUCCESS";
		
	}

	@Override
	public List<AccommodationCategory> findAll() {
		return accommodationCategoryRepository.findAll();
	}

	

	

}
