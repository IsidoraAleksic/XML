package com.example.demo.model.dto;

import com.example.demo.model.AccommodationCategory;
import com.example.demo.model.AccommodationType;
import com.example.demo.model.AdditionalServices;

import java.util.List;

public class SearchParameters  {

    private List<AdditionalServices> additionalServices;
    private List<AccommodationCategory> accommodationCategories ;
    private List<AccommodationType> accommodationTypes;

    public SearchParameters() {
    }

    public SearchParameters(List<AdditionalServices> additionalServices, List<AccommodationCategory> accommodationCategories, List<AccommodationType> accommodationTypes) {
        this.additionalServices = additionalServices;
        this.accommodationCategories = accommodationCategories;
        this.accommodationTypes = accommodationTypes;
    }

    public List<AdditionalServices> getAdditionalServices() {
        return additionalServices;
    }

    public void setAdditionalServices(List<AdditionalServices> additionalServices) {
        this.additionalServices = additionalServices;
    }

    public List<AccommodationCategory> getAccommodationCategories() {
        return accommodationCategories;
    }

    public void setAccommodationCategories(List<AccommodationCategory> accommodationCategories) {
        this.accommodationCategories = accommodationCategories;
    }

    public List<AccommodationType> getAccommodationTypes() {
        return accommodationTypes;
    }

    public void setAccommodationTypes(List<AccommodationType> accommodationTypes) {
        this.accommodationTypes = accommodationTypes;
    }
}
