package com.example.agentapp.service.impl;


import com.example.agentapp.domain.Agent;
import com.example.agentapp.domain.factory.AuthUserFactory;
import com.example.agentapp.repository.AgentRepository;
import com.example.agentapp.service.ws.LoginWS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService  {

    @Autowired
    private AgentRepository agentRepository;

    @Autowired
    LoginWS loginWS;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Agent agent = loginWS.sendLoginRequest(s, ""); //ovo je pravi agent sa beka sa tim usernameom ako ga ima

        if (agent == null || agent.getEmail() == null || agent.getEmail().equals("")) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", s));
        } else
            return AuthUserFactory.create(agent);
    }
}
