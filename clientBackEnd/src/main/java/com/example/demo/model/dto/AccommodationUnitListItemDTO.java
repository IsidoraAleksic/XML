package com.example.demo.model.dto;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import com.example.demo.model.AccommodationCategory;
import com.example.demo.model.AccommodationPricing;
import com.example.demo.model.AccommodationType;
import com.example.demo.model.AdditionalServices;
import com.example.demo.model.Agent;

public class AccommodationUnitListItemDTO {

	private long id;
	private String place;
	private String description;
	private int capacity;

	private AccommodationType accommodationType;
	private AccommodationCategory category;
	private List<AdditionalServices> additionalServices;

	private Agent agent;

	private int price;

	public AccommodationUnitListItemDTO(AccommodationPricing pricing, Date startDate, Date endDate) {
		this.id = pricing.getAccommodationUnit().getId();
		this.place = pricing.getAccommodationUnit().getPlace();
		this.description = pricing.getAccommodationUnit().getDescription();
		this.capacity = pricing.getAccommodationUnit().getCapacity();
		this.accommodationType = pricing.getAccommodationUnit().getAccommodationType();
		this.category = pricing.getAccommodationUnit().getCategory();
		this.additionalServices = pricing.getAccommodationUnit().getAdditionalServices();
		this.agent = pricing.getAccommodationUnit().getAgent();
		
		List<Integer> prices = pricingToList(pricing);
		this.price = prices.get(startDate.getMonth()) * ((int)(TimeUnit.MILLISECONDS.toDays(endDate.getTime()-startDate.getTime())));
		 
	}

	private List<Integer> pricingToList(AccommodationPricing pricing) {
		List<Integer> prices = new ArrayList<Integer>(12);
		prices.add(pricing.getJanuary());
		prices.add(pricing.getFebruary());
		prices.add(pricing.getMarch());
		prices.add(pricing.getApril());
		prices.add(pricing.getMay());
		prices.add(pricing.getJune());
		prices.add(pricing.getJuly());
		prices.add(pricing.getAugust());
		prices.add(pricing.getSeptember());
		prices.add(pricing.getOctober());
		prices.add(pricing.getNovember());
		prices.add(pricing.getDecember());
		return prices;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPlace() {
		return place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public AccommodationType getAccommodationType() {
		return accommodationType;
	}

	public void setAccommodationType(AccommodationType accommodationType) {
		this.accommodationType = accommodationType;
	}

	public AccommodationCategory getCategory() {
		return category;
	}

	public void setCategory(AccommodationCategory category) {
		this.category = category;
	}

	public List<AdditionalServices> getAdditionalServices() {
		return additionalServices;
	}

	public void setAdditionalServices(List<AdditionalServices> additionalServices) {
		this.additionalServices = additionalServices;
	}

	public Agent getAgent() {
		return agent;
	}

	public void setAgent(Agent agent) {
		this.agent = agent;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

}
