package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.AccommodationType;
import com.example.demo.model.AdditionalServices;
import com.example.demo.model.dto.AdditionalServiceDTO;

@Service
public interface AdditionalServiceService {
	
	void save(AdditionalServices additionalServices);
	AdditionalServices findById(Long id);
	void delete(AdditionalServices forDeleting);
	String update(Long id, AdditionalServiceDTO additionalServiceDTO);
	List<AdditionalServices> findAll();
}
