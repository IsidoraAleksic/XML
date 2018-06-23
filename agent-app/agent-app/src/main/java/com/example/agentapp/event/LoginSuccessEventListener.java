package com.example.agentapp.event;

import com.example.agentapp.domain.Agent;
import com.example.agentapp.service.ws.impl.AccommodationUnitWSGet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class LoginSuccessEventListener implements ApplicationListener<OnLoginSuccessEvent> {


    @Autowired
    private AccommodationUnitWSGet accommodationUnitWSGet;

    @Override
    public void onApplicationEvent(OnLoginSuccessEvent onLoginSuccessEvent) {
        Agent loggedInAgent = onLoginSuccessEvent.getLoggedInAgent();

        accommodationUnitWSGet.getAccommodationParameters();
        accommodationUnitWSGet.getAllAccommodationUnits(loggedInAgent.getId());
        //TODO:
        //get all messages
        //get all reservations
    }
}
