package com.example.agentapp.repository;

import com.example.agentapp.domain.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentRepository extends JpaRepository<Agent, Long>{

    Agent findByUsernameIgnoreCase(String username);

}
