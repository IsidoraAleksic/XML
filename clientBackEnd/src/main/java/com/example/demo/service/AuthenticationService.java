package com.example.demo.service;

import com.example.demo.model.User;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService {
    User authenticateUser(String username, String password);
    String registerUser(User user);
    void saveUser(User user);
    void deleteUser(Long id);
    void setLoggedInUser(User user);
    User getLoggedInUser();
    boolean updateUser(User user);
}
