package com.example.agentapp.ws;

import com.example.agentapp.service.ws.AccommodationUnitWS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class TestBean {

    @Autowired
    private WSClient wsClient;

    @Autowired
    private AccommodationUnitWS accommodationUnitWS;

    @PostConstruct
    private void init() {
//        LoginAgentResponse res = wsClient.loginAgent("agent@gmail.com", "agent");
//        System.out.println("name: " + res.getName() + "\tsurname: " + res.getSurname() + "\temail: " + res.getEmail()
//        + "\tpassword: " + res.getPassword());

//        accommodationUnitWS.getAccommodationParameters();
    }
}
