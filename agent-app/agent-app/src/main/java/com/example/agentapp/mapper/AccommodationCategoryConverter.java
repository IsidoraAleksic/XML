package com.example.agentapp.mapper;

import com.example.agentapp.domain.AccommodationCategory;
import org.dozer.DozerBeanMapper;
import schema.wsdl.AccommodationCategoryWs;
import schema.wsdl.ObjectFactory;


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
