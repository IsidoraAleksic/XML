package com.example.demo.service;

import com.example.demo.model.Review;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReviewService {

    void post(Review review);
    List<Review> get(Long accommodationId);
    void remove(Long id);


}
