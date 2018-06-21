package com.example.agentapp.controller;

import com.example.agentapp.domain.Agent;
import com.example.agentapp.domain.security.AuthUser;
import com.example.agentapp.service.AgentService;
import com.example.agentapp.service.ws.LoginWS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    LoginWS loginWS;

    @Autowired
    AgentService agentService;

    @PostMapping
    public boolean login(@RequestBody Agent agent) {

        Authentication authentication = this.authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                    agent.getEmail(),
                    agent.getPassword()
            )
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);

        // ovo ispod je za slucaj da bude trebao u lokalnoj bazi, inace imas ga kao principal
        if (!SecurityContextHolder.getContext().getAuthentication().isAuthenticated()) {
            return false;
        } else {
            AuthUser authUser = (AuthUser)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Agent authAgent = new Agent(authUser.getEmail(), authUser.getPassword(), authUser.getName(),
                                            authUser.getSurname(), authUser.getRegNumber());
            Agent ret = agentService.save(authAgent);
            return true;
        }
    }

}
