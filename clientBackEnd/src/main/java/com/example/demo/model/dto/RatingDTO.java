package com.example.demo.model.dto;

public class RatingDTO {

	private Long user_id;
	private Long reservation_id;
	private Long accommodation_id;
	private int rating;

	public RatingDTO(Long user_id, Long reservation_id, Long accommodation_id, int rating) {
		this.user_id = user_id;
		this.reservation_id = reservation_id;
		this.accommodation_id = accommodation_id;
		this.rating = rating;
	}

	public Long getUser_id() {
		return user_id;
	}

	public void setUser_id(Long user_id) {
		this.user_id = user_id;
	}

	public Long getReservation_id() {
		return reservation_id;
	}

	public void setReservation_id(Long reservation_id) {
		this.reservation_id = reservation_id;
	}

	public Long getAccommodation_id() {
		return accommodation_id;
	}

	public void setAccommodation_id(Long accommodation_id) {
		this.accommodation_id = accommodation_id;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

}
