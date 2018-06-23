package com.example.demo.service;

import com.example.demo.model.Message;
import com.example.demo.model.Reservation;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MessageService {

    void delete(Long reservationId);
    List<Message> getByReservation(Long reservationId);

    void save(Message message);

    void send(Message message);

}
