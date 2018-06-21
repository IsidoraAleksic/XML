package com.example.agentapp.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class AccommodationCategory implements Serializable {

	@Id
    protected Long id;
	
	protected String categoryName;

	public AccommodationCategory() {
	}

	public AccommodationCategory(Long id, String categoryName) {
		this.id = id;
		this.categoryName = categoryName;
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
