package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.Agent;

@Service
public interface AgentService {
	
	public Agent save(Agent agent);
}
