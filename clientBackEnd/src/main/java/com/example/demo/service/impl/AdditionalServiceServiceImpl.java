package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.AccommodationType;
import com.example.demo.model.AdditionalServices;
import com.example.demo.model.User;
import com.example.demo.model.dto.AdditionalServiceDTO;
import com.example.demo.repository.AccommodationTypeRepository;
import com.example.demo.repository.AdditionalServicesRepository;
import com.example.demo.service.AdditionalServiceService;

@Service
public class AdditionalServiceServiceImpl implements AdditionalServiceService{
	
	@Autowired
	AdditionalServicesRepository additionalServiceRepository;

	public void save(AdditionalServices additionalServices) {
		additionalServiceRepository.save(additionalServices);
		
	}

	public AdditionalServices findById(Long id) {
		return additionalServiceRepository.getById(id);
	}

	public void delete(AdditionalServices forDeleting) {
		additionalServiceRepository.delete(forDeleting);
	}

	@Override
	public String update(Long id, AdditionalServiceDTO additionalServiceDTO) {
		AdditionalServices additionalService = additionalServiceRepository.getById(id);
		if(!additionalService.getId().equals(additionalServiceDTO.getId())) {
			return "ERROR";
		}
		additionalService.setName(additionalServiceDTO.getName());
		additionalServiceRepository.save(additionalService);
		return "SUCCESS";
	}
	
	@Override
	public List<AdditionalServices> findAll() {
		return additionalServiceRepository.findAll();
	}
	
	
}
