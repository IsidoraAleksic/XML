package com.example.demo.mapper;

import com.example.demo.model.Agent;
import org.dozer.DozerBeanMapper;
import org.dozer.loader.api.BeanMappingBuilder;
import rs.ac.uns.ftn.agenti.AgentWs;
import rs.ac.uns.ftn.agenti.ObjectFactory;

public class AgentConverter {

    private static final ObjectFactory objectFactory;
    private static final DozerBeanMapper mapper;
    private static BeanMappingBuilder builder;

    static {
        objectFactory = new ObjectFactory();
        mapper = new DozerBeanMapper();
        builder = new BeanMappingBuilder() {
            @Override
            protected void configure() {
                mapping(Agent.class, AgentWs.class)
                        .exclude("authorities");
            }
        };
        mapper.addMapping(builder);
    }

    public static Agent fromXMLTypeToPojo(AgentWs xmlType) {
        Agent pojo = new Agent();
        mapper.map(xmlType, pojo);
        return pojo;
    }

    public static AgentWs fromPojoToXMLType(Agent pojo) {
        AgentWs xmlType = objectFactory.createAgentWs();
        mapper.map(pojo, xmlType);
        return xmlType;
    }
}
