package com.example.demo.service;

import com.example.demo.model.AdditionalServices;
import com.example.demo.model.Review;
import com.example.demo.model.User;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewService {

    void post(Long reservationId, Review review);
    List<Review> get(Long accommodationId);
    void remove(Long id);
    Review findById(Long id);
	void save(Review forPosting);
	public List<Review> findAll();
}
