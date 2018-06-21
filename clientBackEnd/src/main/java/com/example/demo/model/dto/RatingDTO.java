package com.example.demo.model.dto;

public class RatingDTO {

	private Long user_id;
	private Long accommodation_unit_id;
	private Long rating;

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public Long getAccommodation_unit_id() {
		return accommodation_unit_id;
	}

	public void setAccommodation_unit_id(Long accommodation_unit_id) {
		this.accommodation_unit_id = accommodation_unit_id;
	}

	public Long getRating() {
		return rating;
	}

	public void setRating(Long rating) {
		this.rating = rating;
	}

}
