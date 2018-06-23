package com.example.demo.mapper;

import com.example.demo.model.AccommodationCategory;
import org.dozer.DozerBeanMapper;
import rs.ac.uns.ftn.agenti.AccommodationCategoryWs;
import rs.ac.uns.ftn.agenti.ObjectFactory;


public class AccommodationCategoryConverter {

    private static final ObjectFactory objectFactory = new ObjectFactory();
    private static final DozerBeanMapper mapper = new DozerBeanMapper();

    public static AccommodationCategory fromXMLTypeToPojo(AccommodationCategoryWs xmlType) {
        AccommodationCategory pojo = new AccommodationCategory();
        mapper.map(xmlType, pojo);
        return pojo;
    }

    public static AccommodationCategoryWs fromPojoToXMLType(AccommodationCategory pojo) {
        AccommodationCategoryWs xmlType = objectFactory.createAccommodationCategoryWs();
        mapper.map(pojo, xmlType);
        return xmlType;
    }
}
