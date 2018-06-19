package com.example.demo.service.impl;

import com.example.demo.model.User;
import com.example.demo.model.type.Role;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    UserRepository userRepository;


    public User authenticateUser(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user == null)
            return null;
        if (user.getPassword().matches(password))
            return user;
        return null;

    }

    public void saveUser(User user) {
        userRepository.save(user);    }

    public void deleteUser(Long id) {
        User user = userRepository.getOne(id);
            userRepository.delete(user);
    }

    public void setLoggedInUser(User user) {
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().toString()));
        Authentication authentication = new PreAuthenticatedAuthenticationToken(user.getId(), null, authorities);
        SecurityContextHolder.getContext().setAuthentication(authentication);
    }

    public User getLoggedInUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication==null)
            return null;

        System.out.println(authentication.getName());
        System.out.println("principal: " + authentication.getPrincipal());
        if (authentication.getName().equals("anonymousUser"))
            return null;
        System.out.println(authentication.getAuthorities());
        System.out.println(authentication.getDetails());
        System.out.println(authentication.getCredentials());
        Long id = Long.parseLong(authentication.getName());
        User user = userRepository.getOne(id);
        return user;
    }

    @Override
    public boolean updateUser(User user) {
        User u = userRepository.findByEmail(user.getEmail());
        if(u==null)
            return false;
        if (user.getPassword() == null || user.getFirstName() == null ||
                user.getPassword().equals("")|| user.getFirstName().equals("")|| user.getLastName() == null ||
                user.getLastName().equals("")){
            return false;
        }
        u.setLastName(user.getLastName());
        u.setFirstName(user.getFirstName());
        u.setPassword(user.getPassword());
        userRepository.save(u);
        return true;
    }

    @Override
    public String registerUser(User user) {

        if (user.getPassword() == null || user.getFirstName() == null ||
                user.getLastName() == null ||
                user.getEmail() == null )
            return null;

        if (userRepository.findByEmail(user.getEmail()) != null)
            return "exists";
        user.setRole(Role.GUEST);
        return "registered";
    }

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findRegisteredByEmail(String email) {
		return userRepository.findByEmail(email);
	}

}
