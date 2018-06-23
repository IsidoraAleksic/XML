package com.example.demo.mapper;

import com.example.demo.model.AccommodationUnit;
import com.example.demo.model.Message;
import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import rs.ac.uns.ftn.agenti.AccommodationUnitWs;
import rs.ac.uns.ftn.agenti.MessageWs;
import rs.ac.uns.ftn.agenti.ObjectFactory;

public class MessageConverter {

    private static final ObjectFactory objectFactory;
    private static final DozerBeanMapper mapper;
    private static BeanMappingBuilder builder;

    static {
        objectFactory = new ObjectFactory();
        mapper = new DozerBeanMapper();
        builder = new BeanMappingBuilder() {
            @Override
            protected void configure() {
                mapping(Message.class, MessageWs.class)
                        .exclude("reservation");
            }
        };
        mapper.addMapping(builder);
    }
    public static Message fromXMLTypeToPojo(MessageWs xmlType) {
        Message pojo = new Message();
        mapper.map(xmlType, pojo);
        return pojo;
    }

    public static MessageWs fromPojoToXMLType(Message pojo) {
        MessageWs xmlType = objectFactory.createMessageWs();
        mapper.map(pojo, xmlType);
        return xmlType;
    }
}
