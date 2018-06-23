package com.example.demo.mapper;

import com.example.demo.model.AdditionalServices;
import org.dozer.DozerBeanMapper;
import rs.ac.uns.ftn.agenti.AdditionalServicesWs;
import rs.ac.uns.ftn.agenti.ObjectFactory;

public class AdditionalServiceConverter {

    private static final ObjectFactory objectFactory = new ObjectFactory();
    private static final DozerBeanMapper mapper = new DozerBeanMapper();

    public static AdditionalServices fromXMLTypeToPojo(AdditionalServicesWs xmlType) {
        AdditionalServices pojo = new AdditionalServices();
        mapper.map(xmlType, pojo);
        return pojo;
    }

    public static AdditionalServicesWs fromPojoToXmlType(AdditionalServices pojo) {
        AdditionalServicesWs xmlType = objectFactory.createAdditionalServicesWs();
        mapper.map(pojo, xmlType);
        return xmlType;
    }

}
