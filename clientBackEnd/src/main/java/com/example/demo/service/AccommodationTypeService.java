package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.AccommodationCategory;
import com.example.demo.model.AccommodationType;
import com.example.demo.model.dto.AccommodationTypeDTO;

@Service
public interface AccommodationTypeService {
	
	void save(AccommodationType accommodationType);
	AccommodationType findById(Long id);
	void delete(AccommodationType forDeleting);
	String update(Long id, AccommodationTypeDTO accommodationTypeDTO);
	List<AccommodationType> findAll();
}
