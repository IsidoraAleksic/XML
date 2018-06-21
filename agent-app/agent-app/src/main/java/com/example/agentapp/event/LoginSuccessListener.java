package com.example.agentapp.event;

import com.example.agentapp.domain.Agent;
import com.example.agentapp.service.ws.AccommodationUnitWS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class LoginSuccessListener implements ApplicationListener<OnLoginSuccessEvent> {


    @Autowired
    private AccommodationUnitWS accommodationUnitWS;

    @Override
    public void onApplicationEvent(OnLoginSuccessEvent onLoginSuccessEvent) {
        Agent loggedInAgent = onLoginSuccessEvent.getLoggedInAgent();

        accommodationUnitWS.getAccommodationParameters();
        accommodationUnitWS.getAllAccommodationUnits(loggedInAgent.getId());
    }
}
