package com.example.agentapp;

import com.example.agentapp.service.impl.FileServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;

@SpringBootApplication
public class AgentAppApplication {

	public static void main(String[] args) {
		new File(FileServiceImpl.uploadingDir).mkdirs();
		SpringApplication.run(AgentAppApplication.class, args);
	}
}
