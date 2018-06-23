package com.example.agentapp.service;

import com.example.agentapp.domain.Message;

import java.util.List;

public interface MessageService {

    void saveMessages(List<Message> messages);

    void saveMessage(Message message);

    List<Message> getByReservation(Long reservationId);

    List<Message> getAll();

    Message send(Message message);
}
