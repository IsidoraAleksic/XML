package com.example.agentapp.ws;

import com.example.agentapp.controller.AccommodationAttributesController;
import com.example.agentapp.domain.AccommodationPricing;
import com.example.agentapp.domain.AccommodationType;
import com.example.agentapp.domain.AccommodationUnit;
import com.example.agentapp.domain.Agent;
import com.example.agentapp.mapper.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import schema.wsdl.*;

import java.util.List;


public class WSClient extends WebServiceGatewaySupport {

    @Value("${producer.default-uri}")
    private String PRODUCER_URI;

    public LoginAgentResponse loginAgent(String email, String password) {
        LoginAgentRequest request = new LoginAgentRequest();
        request.setEmail(email);
        request.setPassword(password);

        LoginAgentResponse response = (LoginAgentResponse) getWebServiceTemplate()
                .marshalSendAndReceive(PRODUCER_URI, request,
                        new SoapActionCallback(PRODUCER_URI+"/loginAgentRequest"));
        return response;
    }

    public GetAccommodationParametersResponse getAccommodationParameters() {
        GetAccommodationParametersRequest request = new GetAccommodationParametersRequest();
        request.setStaos("daj parametre pls");
        GetAccommodationParametersResponse response = (GetAccommodationParametersResponse)getWebServiceTemplate()
                .marshalSendAndReceive(PRODUCER_URI, request,
                        new SoapActionCallback(PRODUCER_URI+"/getAccommodationParametersRequest"));
        return response;
    }

    public GetAccommodationByAgentIdResponse getAccommodationByAgentId(long id) {
        GetAccommodationByAgentIdReguest reguest = new GetAccommodationByAgentIdReguest();
        reguest.setId(id);
        GetAccommodationByAgentIdResponse response = (GetAccommodationByAgentIdResponse)getWebServiceTemplate()
                .marshalSendAndReceive(PRODUCER_URI, reguest,
                        new SoapActionCallback(PRODUCER_URI+"/getAccommodationByAgentIdReguest"));
        return response;
    }

    public CreateAccommodationResponse createAccommodation(AccommodationUnit unit, AccommodationPricing pricing,
                                                           List<String> encodedImages) {
        CreateAccommodationRequest request = new CreateAccommodationRequest();

        AccommodationUnitWs accommodationUnitWs = AccommodationUnitConverter.fromPojoToXMLType(unit);
        Pricing pricingWs = PricingConverter.fromPojoToXMLType(pricing);

        request.setAccommodationUnit(accommodationUnitWs);
        request.setPricing(pricingWs);
        //TODO:
        //dodati listu stringova za image i onda test

        //        AccommodationCategoryWs accommodationCategoryWs = AccommodationCategoryConverter.fromPojoToXMLType(unit.getCategory());
//        AgentWs agentWs = AgentConverter.fromPojoToXMLType(unit.getAgent());
//        AccommodationTypeWs accommodationTypeWs = AccommodationTypeConverter.fromPojoToXMLType(unit.getAccommodationType());
        return null;
    }
}
