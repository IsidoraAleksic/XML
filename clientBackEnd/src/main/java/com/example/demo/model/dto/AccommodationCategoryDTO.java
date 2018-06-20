package com.example.demo.model.dto;

import com.example.demo.model.AccommodationCategory;

public class AccommodationCategoryDTO {
	
	private Long id;
	
	private String categoryName;

	public AccommodationCategoryDTO(Long id, String categoryName) {
		super();
		this.id = id;
		this.categoryName = categoryName;
	}
	
	public AccommodationCategoryDTO(){
		
	}
	public AccommodationCategory createAccommodationCategory(){
		AccommodationCategory accommodationCategory = new AccommodationCategory();
		accommodationCategory.setId(id);
		accommodationCategory.setCategoryName(categoryName);
	    return accommodationCategory;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
	
}
