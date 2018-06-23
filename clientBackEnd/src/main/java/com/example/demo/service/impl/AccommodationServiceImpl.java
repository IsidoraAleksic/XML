package com.example.demo.service.impl;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.model.AccommodationCategory;
import com.example.demo.model.AccommodationPricing;
import com.example.demo.model.AccommodationType;
import com.example.demo.model.AccommodationUnit;
import com.example.demo.model.AdditionalServices;
import com.example.demo.repository.AccommodationPricingRepository;
import com.example.demo.repository.AccommodationRepository;
import com.example.demo.repository.ReservationRepository;
import com.example.demo.service.AccommodationOptionService;
import com.example.demo.service.AccommodationService;

@Service
public class AccommodationServiceImpl implements AccommodationService {

	@Autowired
	AccommodationRepository accommodationRepository;
	@Autowired
	ReservationRepository reservationRepository;
	@Autowired
	AccommodationOptionService accommodationOptionServices;
	@Autowired
	AccommodationPricingRepository accommodationPricingRepository;

	@Override
	public void save(AccommodationUnit accommodationUnit) {
		accommodationRepository.save(accommodationUnit);
	}

	@Override
	public void delete(AccommodationUnit accommodationUnit) {
		accommodationRepository.delete(accommodationUnit);
	}

	@Override
	public AccommodationUnit getById(Long id) {
		return accommodationRepository.getById(id);
	}

	@Override
	public List<AccommodationUnit> getAll() {
		return accommodationRepository.findAll();
	}

	@Override
	public Object basicSearch(String place, Date startDate, Date endDate, int people) {
		if (place == null || place.equals("") || startDate == null || startDate.equals("") || endDate == null
				|| endDate.equals("") || people == 0)
			return null;
		List<AccommodationUnit> accommodations = getByPlaceAndCapacity(place, people);
		List<AccommodationUnit> ret = search(accommodations, startDate, endDate);

		List<AccommodationPricing> accommodationPricings = new ArrayList<>();
		for (AccommodationUnit accommodationUnit : ret)
			accommodationPricings.add(accommodationPricingRepository.getByAccommodationUnit(accommodationUnit));

		int month = startDate.getMonth();
		int days = (int) (TimeUnit.MILLISECONDS.toDays(endDate.getTime() - startDate.getTime()));

		return new RestTemplate().postForObject(
				"http://localhost:8010/rating-service/us-central1/average?month=" + month + "&days=" + days,
				accommodationPricings, Object.class);
	}

	@Override
	public Object advancedSearch(String place, Date startDate, Date endDate, int people, Long type, Long category,
			List<Long> additionalServices) {
		if (place == null || place.equals("") || startDate == null || startDate.equals("") || endDate == null
				|| endDate.equals("") || people == 0)
			return null;
		AccommodationType accommodationType = accommodationOptionServices.getTypeById(type);
		AccommodationCategory accommodationCategory = accommodationOptionServices.getCategoryById(category);

		List<AdditionalServices> additionalServices1 = new ArrayList<>();
		for (Long id : additionalServices) {
			additionalServices1.add(accommodationOptionServices.getServiceById(id));
		}
		List<AccommodationUnit> accommodations = getByAllCriteria(place, people, accommodationType,
				accommodationCategory, additionalServices1);
		List<AccommodationUnit> accommodationUnits = search(accommodations, startDate, endDate);
		List<AccommodationPricing> accommodationPricings = new ArrayList<>();
		for (AccommodationUnit accommodationUnit : accommodationUnits)
			accommodationPricings.add(accommodationPricingRepository.getByAccommodationUnit(accommodationUnit));

		int month = startDate.getMonth();
		int days = (int) (TimeUnit.MILLISECONDS.toDays(endDate.getTime() - startDate.getTime()));

		return new RestTemplate().postForObject(
				"http://localhost:8010/rating-service/us-central1/average?month=" + month + "&days=" + days,
				accommodationPricings, Object.class);
	}

	@Override
	public List<AccommodationUnit> getByPlaceAndCapacity(String place, int capacity) {
		return accommodationRepository.getByPlaceContainingIgnoreCaseAndCapacity(place, capacity);
	}

	@Override
	public List<AccommodationUnit> getByAllCriteria(String place, int capacity, AccommodationType accommodationType,
			AccommodationCategory accommodationCategory, List<AdditionalServices> additionalServices) {
		return accommodationRepository.advancedSearch(place, capacity, accommodationType, accommodationCategory,
				additionalServices, (long) additionalServices.size());
	}

	@Override
	public List<AccommodationUnit> search(List<AccommodationUnit> accommodations, Date startDate, Date endDate) {
		List<AccommodationUnit> ret = new ArrayList<>();
		ret.addAll(accommodations);
		for (AccommodationUnit accommodation : accommodations) {
			if (reservationRepository.countByAccommodationUnitAndStartDateBeforeAndEndDateAfter(accommodation, endDate,
					startDate) != 0) {
				ret.remove(accommodation);
			}
		}

		return ret;
	}
}
