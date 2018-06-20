package com.example.demo.model.dto;

import com.example.demo.model.AccommodationType;

public class AccommodationTypeDTO {
	
	private Long id;
	
	private String typeName;

	public AccommodationTypeDTO(Long id, String typeName) {
		super();
		this.id = id;
		this.typeName = typeName;
	}
	
	public AccommodationTypeDTO(){
		
	}
	
	public AccommodationType createAccommodationType(){
		AccommodationType accommodationType = new AccommodationType();
	    accommodationType.setId(id);
	    accommodationType.setTypeName(typeName);
	    return accommodationType;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
}
