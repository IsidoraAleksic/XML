package com.example.agentapp.service.impl;

import com.example.agentapp.domain.security.AuthUser;
import com.example.agentapp.service.AuthenticationService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Override
    public Long getLoggedInUserId() {
        AuthUser authUser = (AuthUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return authUser.getId();
    }
}
