package com.example.agentapp.mapper;

import com.example.agentapp.domain.AdditionalService;
import org.dozer.DozerBeanMapper;
import schema.wsdl.AdditionalServicesWs;
import schema.wsdl.ObjectFactory;

public class AdditionalServiceConverter {

    private static final ObjectFactory objectFactory = new ObjectFactory();
    private static final DozerBeanMapper mapper = new DozerBeanMapper();

    public static AdditionalService fromXMLTypeToPojo(AdditionalServicesWs xmlType) {
        AdditionalService pojo = new AdditionalService();
        mapper.map(xmlType, pojo);
        return pojo;
    }

    public static AdditionalServicesWs fromPojoToXmlType(AdditionalService pojo) {
        AdditionalServicesWs xmlType = objectFactory.createAdditionalServicesWs();
        mapper.map(pojo, xmlType);
        return xmlType;
    }

}
