package com.example.demo.model.dto;

import com.example.demo.model.AccommodationType;
import com.example.demo.model.AdditionalServices;

public class AdditionalServiceDTO {

	private Long id;
		
	private String name;

	
	public AdditionalServices createAdditionalService(){
		AdditionalServices additionalService = new AdditionalServices();
		additionalService.setId(id);
		additionalService.setName(name);
	    return additionalService;
	}
	 
	public AdditionalServiceDTO() {
		
	}

	public AdditionalServiceDTO(Long id, String name) {
		
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	 
	 
	
	
}
