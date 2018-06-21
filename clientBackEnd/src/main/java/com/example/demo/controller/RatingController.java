package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.example.demo.service.RatingService;

@RestController
@RequestMapping(value = "/rating")
public class RatingController {

	@Autowired
	private RatingService ratingService;

	@PreAuthorize("GUEST")
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<?> rate(@RequestParam("reservation") Long reservation, @RequestParam("rating") int rating) {
		try {
			ratingService.rate(reservation, rating);
			return ResponseEntity.ok(null);
		} catch (HttpClientErrorException e) {			
			return ResponseEntity.status(e.getStatusCode()).body(e.getResponseBodyAsString());
		}
	}

}
