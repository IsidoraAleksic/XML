package com.example.demo.mapper;

import com.example.demo.model.AccommodationPricing;
import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import rs.ac.uns.ftn.agenti.ObjectFactory;
import rs.ac.uns.ftn.agenti.Pricing;

public class PricingConverter {

    private static final ObjectFactory objectFactory;
    private static final DozerBeanMapper mapper;
    private static BeanMappingBuilder builder;

    static {
        objectFactory = new ObjectFactory();
        mapper = new DozerBeanMapper();
        builder = new BeanMappingBuilder() {
            @Override
            protected void configure() {
                mapping(AccommodationPricing.class, Pricing.class)
                        .exclude("id")
                        .exclude("accommodationUnit");
            }
        };
        mapper.addMapping(builder);
    }

    public static AccommodationPricing fromXMLTypeToPojo(Pricing xmlType) {
        AccommodationPricing pojo = new AccommodationPricing();
        mapper.map(xmlType, pojo);
        return pojo;
    }

    public static Pricing fromPojoToXMLType(AccommodationPricing pojo) {
        Pricing xmlType = objectFactory.createPricing();
        mapper.map(pojo, xmlType);
        return xmlType;
    }
}
