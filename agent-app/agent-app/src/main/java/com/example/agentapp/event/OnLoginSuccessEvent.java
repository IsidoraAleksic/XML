package com.example.agentapp.event;

import com.example.agentapp.domain.Agent;
import org.springframework.context.ApplicationEvent;

public class OnLoginSuccessEvent extends ApplicationEvent {

    private Agent loggedInAgent;

    public OnLoginSuccessEvent(Agent agent) {
        super(agent);
        this.loggedInAgent = agent;
    }

    public Agent getLoggedInAgent() {
        return loggedInAgent;
    }

}
