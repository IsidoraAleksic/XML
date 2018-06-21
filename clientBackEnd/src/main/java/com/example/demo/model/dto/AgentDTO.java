package com.example.demo.model.dto;

import javax.persistence.Column;

import com.example.demo.model.AdditionalServices;
import com.example.demo.model.Agent;

public class AgentDTO {

	private long id;


	private String password;

	private String name;

	private String surname;

	private String email;

	private String regNumber;

	public AgentDTO() {
		super();
	}

	public AgentDTO(long id,  String name, String surname, String email, String contact,
			String regNumber, String password) {
		super();
		this.id = id;
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.regNumber = regNumber;
		this.password = password;
	}
	
	public Agent createAgent() {
		Agent agent = new Agent();
		agent.setName(name);
		agent.setSurname(surname);
		agent.setEmail(email);
		agent.setRegNumber(regNumber);
		return agent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getRegNumber() {
		return regNumber;
	}

	public void setRegNumber(String regNumber) {
		this.regNumber = regNumber;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
