package com.example.agentapp.ws;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import schema.wsdl.*;


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
}
