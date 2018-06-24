package com.example.agentapp.controller;

import com.example.agentapp.domain.Agent;
import com.example.agentapp.domain.security.AuthUser;
import com.example.agentapp.event.OnLoginSuccessEvent;
import com.example.agentapp.service.AgentService;
import com.example.agentapp.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    ApplicationEventPublisher applicationEventPublisher;

    @Autowired
    AgentService agentService;

    @Autowired
    AuthenticationService authenticationService;

    @PostMapping
    public boolean login(@RequestBody Agent agent) {

        Authentication authentication = this.authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                    agent.getEmail(),
                    agent.getPassword()
            )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        if (!SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
            return false;
        } else {
            AuthUser authUser = (AuthUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Agent authAgent = new Agent(authUser.getId(), authUser.getEmail(), authUser.getPassword(), authUser.getName(),
                                            authUser.getSurname(), authUser.getRegNumber());
            Agent saved = agentService.save(authAgent);

            applicationEventPublisher.publishEvent(new OnLoginSuccessEvent(saved));
            return true;
        }
    }


    @GetMapping
    public String getLoggedInEmail() {
        return authenticationService.getLoggedInEmail();
    }

}
