package com.example.agentapp.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class AccommodationCategory implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
	
	protected String categoryName;

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

	public AccommodationCategory() {
	}
}