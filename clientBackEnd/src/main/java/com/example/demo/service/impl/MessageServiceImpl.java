package com.example.demo.service.impl;

import com.example.demo.exceptions.BadRequestException;
import com.example.demo.model.Message;
import com.example.demo.model.Reservation;
import com.example.demo.repository.MessageRepository;
import com.example.demo.repository.ReservationRepository;
import com.example.demo.service.AuthenticationService;
import com.example.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    MessageRepository messageRepository;
    @Autowired
    ReservationRepository reservationRepository;
    @Autowired
    AuthenticationService authenticationService ;

    @Override
    public void delete(Long reservationId) {
        Reservation reservation = reservationRepository.getById(reservationId);
        if(reservation==null)
            throw new BadRequestException("Reservation does not exist");
        List<Message> messages = messageRepository.getByReservation(reservation);
        messageRepository.deleteAll(messages);
    }

    @Override
    public List<Message> getByReservation(Long reservationId) {
        Reservation reservation = reservationRepository.getById(reservationId);
        return messageRepository.getByReservation(reservation);
    }

    @Override
    public void send(Message message) {

        if(message.getMessage()==null || message.getMessage().equals("")){
            throw new BadRequestException("Message content cannot be null");

        }
        System.out.println("Reservation: " + message.getReservation());
        if(authenticationService.getLoggedInUser()==null)
            throw new BadRequestException("User cannot be null");
        if(message.getReservation()==null)
            throw new BadRequestException("Reservation does not exist");
        if(reservationRepository.getById(message.getReservation().getId())==null)
            throw new BadRequestException("Reservation does not exist");

        messageRepository.save(message);
    }
}
