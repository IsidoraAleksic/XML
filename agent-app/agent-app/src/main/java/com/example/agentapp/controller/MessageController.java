package com.example.agentapp.controller;

import com.example.agentapp.domain.Message;
import com.example.agentapp.service.MessageService;
import com.example.agentapp.service.ws.impl.MessageWS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import schema.wsdl.MessageWs;

import java.util.List;

@RestController
@RequestMapping("/message")
public class MessageController {

    @Autowired
    MessageService messageService;

    @Autowired
    MessageWS messageWs;

    @GetMapping(value = "/all")
    public List<Message> getAllForAgent() {
        return messageService.getAll();
    }

    @GetMapping(value = "/all/{resId}")
    public List<Message> getAll(@PathVariable("resId") long resId) {
        return messageService.getByReservation(resId);
    }

    @PostMapping(value = "/send")
    public void sendMessage(@RequestBody Message message) {
        messageWs.sendMessage(message);
    }

}
