package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Agent;
import com.example.demo.repository.AgentRepository;
import com.example.demo.service.AgentService;

@Service
public class AgentServiceImpl implements AgentService{

	@Autowired
	private AgentRepository agentRepository;
	
	@Override
	public Agent save(Agent agent) {
		return agentRepository.save(agent);
	}

}
