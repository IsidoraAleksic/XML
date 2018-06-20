package com.example.agentapp.domain.factory;

import com.example.agentapp.domain.Agent;
import com.example.agentapp.domain.security.AuthUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import java.util.Collection;

public class AuthUserFactory {

    public static AuthUser create(Agent user) {

        Collection<? extends GrantedAuthority> authorities;
        try {
            authorities = AuthorityUtils.commaSeparatedStringToAuthorityList(user.getAuthorities());
        } catch (Exception e) {
            authorities = null;
        }

        return new AuthUser(user.getId(), user.getUsername(), user.getPassword(), authorities);
    }
}
