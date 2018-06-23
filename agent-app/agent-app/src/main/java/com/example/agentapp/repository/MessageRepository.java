package com.example.agentapp.repository;

import com.example.agentapp.domain.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Long> {

    List<Message> findByReservation_IdAndAgentFalse(long resId);

    List<Message> findByAgentFalse();

}
