package com.example.agentapp.repository;

import com.example.agentapp.domain.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Agent, Long>{

}
