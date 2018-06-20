package com.example.agentapp;

import com.example.agentapp.service.impl.FileServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.io.File;

@SpringBootApplication
public class AgentAppApplication {

	public static void main(String[] args) {
		new File(FileServiceImpl.uploadingDir).mkdirs();
		SpringApplication.run(AgentAppApplication.class, args);
	}
}
