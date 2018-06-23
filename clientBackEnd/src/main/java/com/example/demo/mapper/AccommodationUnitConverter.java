package com.example.demo.mapper;

import com.example.demo.model.AccommodationUnit;
import com.example.demo.model.AdditionalServices;
import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import rs.ac.uns.ftn.agenti.AccommodationUnitWs;
import rs.ac.uns.ftn.agenti.AdditionalServicesWs;
import rs.ac.uns.ftn.agenti.ObjectFactory;

import java.util.List;
import java.util.stream.Collectors;

public class AccommodationUnitConverter {

//    private static final ObjectFactory objectFactory = new ObjectFactory();
//    private static final DozerBeanMapper mapper = new DozerBeanMapper();

    private static final ObjectFactory objectFactory;
    private static final DozerBeanMapper mapper;
    private static BeanMappingBuilder builder;

    static {
        objectFactory = new ObjectFactory();
        mapper = new DozerBeanMapper();
        builder = new BeanMappingBuilder() {
            @Override
            protected void configure() {
                mapping(AccommodationUnit.class, AccommodationUnitWs.class)
                        .exclude("accommodationType")
                        .exclude("category")
                        .exclude("additionalServices")
                        .exclude("agent");
            }
        };
        mapper.addMapping(builder);
    }

    public static AccommodationUnit fromXMLTypeToPojo(AccommodationUnitWs xmlType) {
        AccommodationUnit pojo = new AccommodationUnit();
        mapper.map(xmlType, pojo);

        pojo.setCategory(AccommodationCategoryConverter.fromXMLTypeToPojo(xmlType.getCategory()));
        pojo.setAccommodationType(AccommodationTypeConverter.fromXMLTypeToPojo(xmlType.getAccommodationType()));
        pojo.setAgent(AgentConverter.fromXMLTypeToPojo(xmlType.getAgent()));
        List<AdditionalServices> services = xmlType.getAdditionalServices()
                .stream()
                .map(xmlT -> AdditionalServiceConverter.fromXMLTypeToPojo(xmlT))
                .collect(Collectors.toList());
        pojo.setAdditionalServices(services);

        return pojo;
    }

    public static AccommodationUnitWs fromPojoToXMLType(AccommodationUnit pojo) {
        AccommodationUnitWs xmlType = objectFactory.createAccommodationUnitWs();
        mapper.map(pojo, xmlType);

        xmlType.setCategory(AccommodationCategoryConverter.fromPojoToXMLType(pojo.getCategory()));
        xmlType.setAccommodationType(AccommodationTypeConverter.fromPojoToXMLType(pojo.getAccommodationType()));
        xmlType.setAgent(AgentConverter.fromPojoToXMLType(pojo.getAgent()));
        pojo.getAdditionalServices()
                .stream()
                .forEach(p -> {
                    AdditionalServicesWs additionalServicesWs = AdditionalServiceConverter.fromPojoToXmlType(p);
                    xmlType.getAdditionalServices().add(additionalServicesWs);
                });

        return xmlType;
    }
}
