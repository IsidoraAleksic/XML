package com.example.agentapp.service.ws.impl;

import com.example.agentapp.domain.Message;
import com.example.agentapp.service.MessageService;
import com.example.agentapp.ws.WSClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import schema.wsdl.MessagesResponse;

@Service
public class MessageWS {

    @Autowired
    private WSClient wsClient;

    @Autowired
    private MessageService messageService;

    public void sendMessage(Message message) {
        MessagesResponse response = wsClient.sendMessage(message);
        message.setId(response.getMessage().getId());
        messageService.saveMessage(message);
    }
}
