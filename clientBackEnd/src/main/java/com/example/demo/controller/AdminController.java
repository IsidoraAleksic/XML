package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.AccommodationCategory;
import com.example.demo.model.AccommodationType;
import com.example.demo.model.AdditionalServices;
import com.example.demo.model.Agent;
import com.example.demo.model.Review;
import com.example.demo.model.User;
import com.example.demo.model.dto.AccommodationCategoryDTO;
import com.example.demo.model.dto.AccommodationTypeDTO;
import com.example.demo.model.dto.AdditionalServiceDTO;
import com.example.demo.model.dto.AgentDTO;
import com.example.demo.model.type.Role;
import com.example.demo.service.AccommodationCategoryService;
import com.example.demo.service.AccommodationTypeService;
import com.example.demo.service.AdditionalServiceService;
import com.example.demo.service.AgentService;
import com.example.demo.service.AuthenticationService;
import com.example.demo.service.ReviewService;

@RestController
@RequestMapping(value = "/administrator")
public class AdminController {

	@Autowired
	private AccommodationTypeService accommodationTypeService;

	@Autowired
	private AccommodationCategoryService accommodationCategoryService;

	@Autowired
	private AdditionalServiceService additionalServiceService;

	@Autowired
	private AuthenticationService authenticationService;

	@Autowired
	private AgentService agentService;

	@Autowired
	private ReviewService reviewService;

	@PostMapping("/addAccommodationType")
	public ResponseEntity<?> addAccommodationType(@RequestBody AccommodationTypeDTO accommodationTypeDTO) {
		AccommodationType accommodationType = accommodationTypeDTO.createAccommodationType();
		accommodationTypeService.save(accommodationType);

		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PostMapping("/updateAccommodationType/{id}")
	public ResponseEntity updateAccommodationType(@PathVariable("id") Long id,
			@RequestBody AccommodationTypeDTO accommodationTypeDTO) {
		String result = accommodationTypeService.update(id, accommodationTypeDTO);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@DeleteMapping("/deleteAccommodationType/{id}")
	public boolean deleteAccommodationType(@PathVariable("id") Long id) {
		AccommodationType forDeleting = accommodationTypeService.findById(id);
		if (forDeleting != null) {
			accommodationTypeService.delete(forDeleting);
			return true;
		}

		return false;
	}

	@PostMapping("/addAccommodationCategory")
	public ResponseEntity<?> addAccommodationCategory(@RequestBody AccommodationCategoryDTO accommodationCategoryDTO) {
		AccommodationCategory accommodationCategory = accommodationCategoryDTO.createAccommodationCategory();
		accommodationCategoryService.save(accommodationCategory);

		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PostMapping("/updateAccommodationCategory/{id}")
	public ResponseEntity updateAccommodationCategory(@PathVariable("id") Long id,
			@RequestBody AccommodationCategoryDTO accommodationCategoryDTO) {
		String result = accommodationCategoryService.update(id, accommodationCategoryDTO);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@DeleteMapping("/deleteAccommodationCategory/{id}")
	public boolean deleteAccommodationCategory(@PathVariable("id") Long id) {
		AccommodationCategory forDeleting = accommodationCategoryService.findById(id);
		if (forDeleting != null) {
			accommodationCategoryService.delete(forDeleting);
			return true;
		}

		return false;
	}

	@PostMapping("/addAdditionalServices")
	public ResponseEntity<?> addAdditionalServices(@RequestBody AdditionalServiceDTO additionalServiceDTO) {
		AdditionalServices additionalServices = additionalServiceDTO.createAdditionalService();
		additionalServiceService.save(additionalServices);

		return new ResponseEntity<>(HttpStatus.CREATED);

	}

	@PostMapping("/updateAdditionalServices/{id}")
	public ResponseEntity updateAdditionalServices(@PathVariable("id") Long id_ad,
			@RequestBody AdditionalServiceDTO additionalServiceDTO) {
		String result = additionalServiceService.update(id_ad, additionalServiceDTO);
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	@DeleteMapping("/deleteAdditionalServices/{id}")
	public boolean deleteAdditionalServices(@PathVariable("id") Long id) {
		AdditionalServices forDeleting = additionalServiceService.findById(id);
		if (forDeleting != null) {
			additionalServiceService.delete(forDeleting);
			return true;
		}

		return false;
	}

	@RequestMapping("/getAllUsers")
	public List<User> getAllUsers() {
		List<User> list = authenticationService.findAll();
		return list;
	}

	@RequestMapping("/getAllReviews")
	public List<Review> getAllReviews() {
		List<Review> list = reviewService.findAll();
		return list;
	}
	
	@RequestMapping("/getAllAccommodationType")
	public List<AccommodationType> getAllAccommodationType() {
		List<AccommodationType> list = accommodationTypeService.findAll();
		return list;
	}

	@RequestMapping("/getAllAccommodationCategory")
	public List<AccommodationCategory> getAllAccommodationCategory() {
		List<AccommodationCategory> list = accommodationCategoryService.findAll();
		return list;
	}

	@RequestMapping("/getAllAdditionalServices")
	public List<AdditionalServices> getAllAdditionalServices() {
		List<AdditionalServices> list = additionalServiceService.findAll();
		return list;
	}

	@PostMapping("/blockGuests/{email}")
	public boolean block(@PathVariable("email") String email) {
		User forBlocking = authenticationService.findRegisteredByEmail(email);
		if (forBlocking != null && forBlocking.getRole() == Role.GUEST) {
			forBlocking.setBlocked(true);
			authenticationService.saveUser(forBlocking);
			return true;
		}

		return false;
	}

	@PostMapping("/activateGuests/{email}")
	public boolean activate(@PathVariable("email") String email) {
		User forActivation = authenticationService.findRegisteredByEmail(email);
		if (forActivation != null && forActivation.getRole() == Role.GUEST) {
			forActivation.setActivated(true);
			authenticationService.saveUser(forActivation);
			return true;
		}

		return false;
	}

	@PostMapping("/deleteGuests/{email}")
	public boolean delete(@PathVariable("email") String email) {
		User forDeleting = authenticationService.findRegisteredByEmail(email);
		if (forDeleting != null && forDeleting.getRole() == Role.GUEST) {
			forDeleting.setDeleted(true);
			authenticationService.saveUser(forDeleting);
			return true;
		}

		return false;
	}

	@PostMapping("/addAgent")
	public ResponseEntity<?> addAgent(@RequestBody AgentDTO agentDTO) {

		Agent agent = agentDTO.createAgent();
		agentService.save(agent);

		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@PostMapping("/postReview")
	public boolean postReview(@RequestBody Long id) {
		Review forPosting = reviewService.findById(id);
		if (forPosting != null) {
			forPosting.setApproved(true);
			reviewService.save(forPosting);
			return true;
		}

		return false;
	}

}
