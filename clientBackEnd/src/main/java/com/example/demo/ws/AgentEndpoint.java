package com.example.demo.ws;

import com.example.demo.model.Agent;
import com.example.demo.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import rs.ac.uns.ftn.agenti.LoginAgentRequest;
import rs.ac.uns.ftn.agenti.LoginAgentResponse;


@Endpoint
public class AgentEndpoint {
    private static final String NAMESPACE_URI = "http://www.ftn.uns.ac.rs/agenti";

    @Autowired
    AgentRepository agentRepository;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "loginAgentRequest")
    @ResponsePayload
    public LoginAgentResponse loginAgent(@RequestPayload LoginAgentRequest request){
        Agent agent = agentRepository.getByEmailIgnoreCase(request.getEmail());
        LoginAgentResponse response = new LoginAgentResponse();
        response.setId(agent.getId());
        response.setEmail(agent.getEmail());
        response.setName(agent.getName());
        response.setSurname(agent.getSurname());
        response.setPassword(agent.getPassword());
        response.setRegNumber(agent.getRegNumber());
        return response;
    }
}
