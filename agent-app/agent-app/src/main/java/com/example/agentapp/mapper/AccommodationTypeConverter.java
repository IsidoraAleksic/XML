package com.example.agentapp.mapper;

import com.example.agentapp.domain.AccommodationType;
import org.dozer.DozerBeanMapper;
import schema.wsdl.AccommodationTypeWs;
import schema.wsdl.ObjectFactory;

public class AccommodationTypeConverter {

    private static final ObjectFactory objectFactory = new ObjectFactory();
    private static final DozerBeanMapper mapper = new DozerBeanMapper();

    public static AccommodationType fromXMLTypeToPojo(AccommodationTypeWs xmlType) {
        AccommodationType pojo = new AccommodationType();
        mapper.map(xmlType, pojo);
        return pojo;
    }

    public static AccommodationTypeWs fromPojoToXMLType(AccommodationType pojo) {
        AccommodationTypeWs xmlType = objectFactory.createAccommodationTypeWs();
        mapper.map(pojo, xmlType);
        return xmlType;
    }
}
