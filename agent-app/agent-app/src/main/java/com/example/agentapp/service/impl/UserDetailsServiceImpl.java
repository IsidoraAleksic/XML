package com.example.agentapp.service.impl;


import com.example.agentapp.domain.Agent;
import com.example.agentapp.domain.factory.AuthUserFactory;
import com.example.agentapp.repository.AgentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService  {

    @Autowired
    private AgentRepository agentRepository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Agent agent = agentRepository.findByUsernameIgnoreCase(s);

        if (agent == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", s));
        } else
            return AuthUserFactory.create(agent);
    }
}
