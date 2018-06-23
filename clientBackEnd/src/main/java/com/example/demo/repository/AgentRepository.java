package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.AdditionalServices;
import com.example.demo.model.Agent;
import org.springframework.stereotype.Repository;

@Repository
public interface AgentRepository extends JpaRepository<Agent,Long>{

    Agent getByEmailIgnoreCase(String email);

    Agent getById(Long agentId);
}
