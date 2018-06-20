package com.example.demo.service.impl;

import com.example.demo.exceptions.BadRequestException;
import com.example.demo.exceptions.NotFoundException;
import com.example.demo.model.AccommodationUnit;
import com.example.demo.model.Reservation;
import com.example.demo.model.Review;
import com.example.demo.model.User;
import com.example.demo.repository.AccommodationRepository;
import com.example.demo.repository.ReservationRepository;
import com.example.demo.repository.ReviewRepository;
import com.example.demo.service.AuthenticationService;
import com.example.demo.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    @Autowired
    ReviewRepository reviewRepository;
    @Autowired
    AuthenticationService authenticationService;
    @Autowired
    AccommodationRepository accommodationRepository;
    @Autowired
    ReservationRepository reservationRepository;

    @Override
    public void post(Long reservationId, Review review) {
        Reservation reservation = reservationRepository.getById(reservationId);
        if(reservation==null)
            throw new NotFoundException("Reservation not found");
        System.out.println("TODAY'S DATE:  " + Calendar.getInstance().getTime());
        System.out.println("END DATE OF RESERVATION:  " + reservation.getEndDate());
        System.out.println("COMPARE:  " +reservation.getEndDate().after(Calendar.getInstance().getTime()));

        if(reservation.getEndDate().after(Calendar.getInstance().getTime()))
            throw new BadRequestException("Reservation has not passed");
        if(review==null)
            throw new BadRequestException("Review cannot be null");
        if(review.getAccommodationUnit()==null)
            throw new BadRequestException("Accommodation cannot be null");
        User user = authenticationService.getLoggedInUser();
        if(user==null)
            throw new BadRequestException("User cannot be null");
        review.setApproved(false);
        review.setUser(user);
        reviewRepository.save(review);

    }

    @Override
    public List<Review> get(Long accommodationId) {
        AccommodationUnit accommodationUnit  =accommodationRepository.getById(accommodationId);
        if(accommodationUnit==null)
            throw new BadRequestException("Accommodation cannot be null");
        List<Review> reviews = reviewRepository.getByAccommodationUnitAndApproved(accommodationUnit, true);
        return reviews;
    }

    @Override
    public void remove(Long id) {
        Review review  = reviewRepository.getById(id);
        if(review== null)
            throw new BadRequestException("Review cannot be null");
        reviewRepository.delete(review);
    }

	@Override
	public Review findById(Long id) {
		return reviewRepository.getById(id);
	}

	@Override
	public void save(Review forPosting) {
		reviewRepository.save(forPosting);
	}
}
