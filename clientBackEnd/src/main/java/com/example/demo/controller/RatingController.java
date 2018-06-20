package com.example.demo.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.demo.exceptions.InternalServerErrorException;
import com.example.demo.model.dto.RatingDTO;

@RestController
@RequestMapping(value = "/rating")
// @PreAuthorize("GUEST")
public class RatingController {

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public Object reserve(@RequestBody RatingDTO rating) {
		try {
			return new RestTemplate().postForObject("http://localhost:8010/rating-service/us-central1/ratings", rating,
					Object.class);
		} catch (Exception e) {
			throw new InternalServerErrorException(e.getMessage());
		}
	}

}
