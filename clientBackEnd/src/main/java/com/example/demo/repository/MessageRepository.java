package com.example.demo.repository;

import com.example.demo.model.Message;
import com.example.demo.model.Reservation;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository  extends JpaRepository<Message,Long> {

    List<Message> getByReservation(Reservation reservation);
    Message getById(Long id);
}
