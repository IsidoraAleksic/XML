package com.example.agentapp.service.impl;

import com.example.agentapp.domain.Message;
import com.example.agentapp.repository.MessageRepository;
import com.example.agentapp.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageRepository messageRepository;

    @Override
    public void saveMessages(List<Message> messages) {
        messageRepository.saveAll(messages);
    }

    @Override
    public void saveMessage(Message message) {
        messageRepository.save(message);
    }

    @Override
    public List<Message> getByReservation(Long reservationId) {
        return messageRepository.findByReservation_IdAndAgentFalse(reservationId);
    }

    @Override
    public List<Message> getAll() {
        return messageRepository.findByAgentFalse();
    }

    @Override
    public Message send(Message message) {
        return messageRepository.save(message);
    }
}
