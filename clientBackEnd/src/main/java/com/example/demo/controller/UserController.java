package com.example.demo.controller;

import com.example.demo.model.User;
import com.example.demo.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping(value = "/authenticate")
public class UserController {

    @Autowired
    AuthenticationService authenticationService;


    @RequestMapping(value = "/test", method = RequestMethod.GET, produces = "text/plain")
    public String test(){
        return "hej";
    }
    @RequestMapping(value = "/getUser", method = RequestMethod.GET, produces = "application/json")
    public User getLoggedInUser() {
        User user = authenticationService.getLoggedInUser();
        if (user == null)
            return null;
        return user;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST, produces ="application/json", consumes = "application/json")
    public String loginUser(@RequestBody User user) {
        User loggedIn = authenticationService.authenticateUser(user.getEmail(), user.getPassword());
        if (loggedIn == null)
            return "\"nok\"";
        authenticationService.setLoggedInUser(loggedIn);
        return "\"ok\"";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET,produces ="application/json")
    public String logoutUser(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "\"ok\"";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST, produces = "text/plain", consumes = "application/json")
    public String registerUser(@RequestBody User user, HttpServletRequest request) {
        String registered = authenticationService.registerUser(user);
        if (registered == null)
            return "\"nok\"";
        else if (registered.equals("exists"))
            return "\"exists\"";
       authenticationService.saveUser(user);
      return "\"ok\"";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public User editUser(@RequestBody User user){
        User loggedIn = authenticationService.getLoggedInUser();
        if(loggedIn!=null && loggedIn.getEmail().equals(user.getEmail())){
            authenticationService.updateUser(user);
        }
        return loggedIn;
    }

    @RequestMapping(value ="/{id}",method = RequestMethod.DELETE, produces = "text/plain", consumes = "application/json")
    public void deleteUser(@PathVariable("id") Long id) {
        authenticationService.deleteUser(id);
    }
}
