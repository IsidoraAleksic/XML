package com.example.agentapp.domain.dto;

import java.io.Serializable;
import java.util.List;

public class AccommodationAttributes implements Serializable {

    //prevaci da sve budu liste stringova
    private List<String> categories;
    private List<String> types;
    private List<String> additionalServices;

    public AccommodationAttributes() {
    }

    public AccommodationAttributes(List<String> categories, List<String> types, List<String> additionalServices) {
        this.categories = categories;
        this.types = types;
        this.additionalServices = additionalServices;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }

    public List<String> getAdditionalServices() {
        return additionalServices;
    }

    public void setAdditionalServices(List<String> additionalServices) {
        this.additionalServices = additionalServices;
    }
}
