package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.dto.SearchParameters;
import com.example.demo.service.AccommodationOptionService;
import com.example.demo.service.AccommodationService;
import com.example.demo.service.ReservationService;

@RestController
@RequestMapping(value = "/search")
public class SearchController {

	@Autowired
	ReservationService reservationService;
	@Autowired
	AccommodationService accommodationService;
	@Autowired
	AccommodationOptionService accommodationOptionService;

	@RequestMapping(value = "/basicSearch", method = RequestMethod.GET, produces = "application/json")
	public Object basicSearch(@RequestParam("place") String place,
			@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate,
			@RequestParam("people") int people) {

		Date sqlStartDate = reservationService.toDate(startDate);
		Date sqlEndDate = reservationService.toDate(endDate);
		return accommodationService.basicSearch(place, sqlStartDate, sqlEndDate, people);
	}

	@RequestMapping(method = RequestMethod.GET, produces = "application/json")
	public SearchParameters getSearchParameters() {
		return accommodationOptionService.getParameters();
	}

	@RequestMapping(value = "/advancedSearch", method = RequestMethod.GET, produces = "application/json")
	public Object advancedSearch(@RequestParam("place") String place,
			@RequestParam("startDate") String startDate, @RequestParam("endDate") String endDate,
			@RequestParam("people") int people, @RequestParam("type") Long type,
			@RequestParam("category") Long category,
			@RequestParam(value = "additionalServices[]") List<Long> additionalServices) {

		Date sqlStartDate = reservationService.toDate(startDate);
		Date sqlEndDate = reservationService.toDate(endDate);
		return accommodationService
				.advancedSearch(place, sqlStartDate, sqlEndDate, people, type, category, additionalServices);

	}
}
