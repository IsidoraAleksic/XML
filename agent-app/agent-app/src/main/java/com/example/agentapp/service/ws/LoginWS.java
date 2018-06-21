package com.example.agentapp.service.ws;

import com.example.agentapp.domain.Agent;
import com.example.agentapp.ws.WSClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import schema.wsdl.LoginAgentResponse;

@Service
public class LoginWS {

    @Autowired
    private WSClient wsClient;

    public Agent sendLoginRequest(String email, String password) {
        LoginAgentResponse res = wsClient.loginAgent(email, password);
        return new Agent(res.getEmail(), res.getPassword(), res.getName(), res.getSurname(), res.getRegNumber());
    }
}
