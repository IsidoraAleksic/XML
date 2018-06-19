package com.example.demo.controller;

import com.example.demo.model.Message;
import com.example.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/message")

public class MessageController {

    @Autowired
    MessageService messageService;

    @PreAuthorize("GUEST")
    @RequestMapping( method = RequestMethod.POST, consumes = "application/json")
    public void send(@RequestBody Message message){
        messageService.send(message);
    }

    @PreAuthorize("GUEST")
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public List<Message> get(@PathVariable("id") Long id){
         return messageService.getByReservation(id);
    }

    @PreAuthorize("GUEST")
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Long id){
        messageService.delete(id);
    }
}
