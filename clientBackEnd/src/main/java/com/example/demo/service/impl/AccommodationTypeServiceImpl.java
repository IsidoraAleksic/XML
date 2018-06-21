package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.AccommodationType;
import com.example.demo.model.dto.AccommodationTypeDTO;
import com.example.demo.repository.AccommodationTypeRepository;
import com.example.demo.service.AccommodationTypeService;

@Service
public class AccommodationTypeServiceImpl implements AccommodationTypeService{

	 @Autowired
	 AccommodationTypeRepository accommodationTypeRepository;

	public void save(AccommodationType accommodationType) {
		accommodationTypeRepository.save(accommodationType);
	}

	public AccommodationType findById(Long id) {
		
		return accommodationTypeRepository.getById(id);
	}

	public void delete(AccommodationType forDeleting) {
		accommodationTypeRepository.delete(forDeleting);
	}

	@Override
	public String update(Long id, AccommodationTypeDTO accommodationTypeDTO) {
		AccommodationType accommodationType = accommodationTypeRepository.getById(id);
		if(!accommodationType.getId().equals(id)) {
			return "ERROR";
		}
		accommodationType.setTypeName(accommodationTypeDTO.getTypeName());
		accommodationTypeRepository.save(accommodationType);
		return "SUCCESS";
	}

	@Override
	public List<AccommodationType> findAll() {
		return accommodationTypeRepository.findAll();
	}

	
}
