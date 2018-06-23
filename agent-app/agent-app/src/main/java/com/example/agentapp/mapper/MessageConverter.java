package com.example.agentapp.mapper;

import com.example.agentapp.domain.Message;
import org.dozer.DozerBeanMapper;
import schema.wsdl.MessageWs;
import schema.wsdl.ObjectFactory;

public class MessageConverter {

    private static final ObjectFactory objectFactory = new ObjectFactory();
    private static final DozerBeanMapper mapper = new DozerBeanMapper();

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
