package com.example.agentapp.ws;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;
import schema.wsdl.LoginAgentRequest;
import schema.wsdl.LoginAgentResponse;

public class WSClient extends WebServiceGatewaySupport {

    private static final String PRODUCER_URI = "http://localhost:8080/ws";

    public LoginAgentResponse loginAgent(String email, String password) {
        LoginAgentRequest request = new LoginAgentRequest();
        request.setEmail(email);
        request.setPassword(password);

        LoginAgentResponse response = (LoginAgentResponse) getWebServiceTemplate()
                .marshalSendAndReceive(PRODUCER_URI, request,
                        new SoapActionCallback(PRODUCER_URI+"/loginAgentRequest"));
        return response;
    }
}
