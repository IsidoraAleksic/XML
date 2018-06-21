package com.example.demo.service.impl;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.exceptions.BadRequestException;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.exceptions.UnauthorizedException;
import com.example.demo.model.Reservation;
import com.example.demo.model.User;
import com.example.demo.model.dto.RatingDTO;
import com.example.demo.repository.ReservationRepository;
import com.example.demo.service.AuthenticationService;
import com.example.demo.service.RatingService;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	private AuthenticationService authenticationService;

	@Autowired
	private ReservationRepository reservationRepository;

	@Override
	public void rate(Long reservation_id, int rating) {
		User user = authenticationService.getLoggedInUser();

		if (user == null)
			throw new UnauthorizedException("Not logged in");

		Reservation reservation = reservationRepository.getById(reservation_id);

		if (reservation == null)
			throw new NotFoundException("Reservation with id " + reservation_id + " doesn't exist");

		if (reservation.getUser().getId() != user.getId())
			throw new UnauthorizedException("Can't rate");
		
		if (reservation.getEndDate().after(Calendar.getInstance().getTime()))
			throw new BadRequestException("Can't rate yet");
		
		if (rating < 1 || rating > 5)
			throw new BadRequestException("Rating must be between 1 and 5");

		RatingDTO ratingDTO = new RatingDTO(user.getId(), reservation_id, rating);

		new RestTemplate().postForObject("http://localhost:8010/rating-service/us-central1/ratings", ratingDTO,
				Object.class);

	}

}
