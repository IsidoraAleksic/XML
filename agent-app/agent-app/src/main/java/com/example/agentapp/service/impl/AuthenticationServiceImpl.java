package com.example.agentapp.service.impl;

import com.example.agentapp.domain.security.AuthUser;
import com.example.agentapp.service.AuthenticationService;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Override
    public String getLoggedInEmail() {
        if (!SecurityContextHolder.getContext().getAuthentication().isAuthenticated())
            return "noone";
        return SecurityContextHolder.getContext().getAuthentication().getName();
    }

    @Override
    public long getLoggedInId() {
        if (!SecurityContextHolder.getContext().getAuthentication().isAuthenticated())
            return 0;
        AuthUser authUser = (AuthUser) SecurityContextHolder.getContext().getAuthentication();
        return authUser.getId();
    }
}
