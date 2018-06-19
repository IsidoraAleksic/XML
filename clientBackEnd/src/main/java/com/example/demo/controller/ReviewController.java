package com.example.demo.controller;

import com.example.demo.model.Review;
import com.example.demo.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/review")
public class ReviewController {

    @Autowired
    ReviewService reviewService;


    @PreAuthorize("GUEST")
    @RequestMapping( value = "/{reservationId}", method = RequestMethod.POST, consumes = "application/json")
    public void send(@PathVariable("reservationId") Long reservationId, @RequestBody Review review){
        reviewService.post(reservationId, review);
    }


    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public List<Review> get(@PathVariable("id") Long id){
        return reviewService.get(id);
    }

    @PreAuthorize("GUEST")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id){
        reviewService.remove(id);
    }
}
