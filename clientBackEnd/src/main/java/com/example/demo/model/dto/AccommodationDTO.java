package com.example.demo.model.dto;

import com.example.demo.model.AccommodationPricing;
import com.example.demo.model.AccommodationUnit;
import org.apache.catalina.LifecycleState;

import java.util.List;

public class AccommodationDTO {

    private AccommodationPricing pricing;
    private List<String> image;

    public AccommodationDTO() {
    }

    public AccommodationDTO(AccommodationPricing pricing, List<String> image) {
        this.pricing = pricing;
        this.image = image;
    }

    public AccommodationPricing getPricing() {
        return pricing;
    }

    public void setPricing(AccommodationPricing pricing) {
        this.pricing = pricing;
    }

    public List<String> getImage() {
        return image;
    }

    public void setImage(List<String> image) {
        this.image = image;
    }
}
