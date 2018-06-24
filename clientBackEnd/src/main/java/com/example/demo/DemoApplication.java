package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurerAdapter() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				super.addCorsMappings(registry);
//				String[] origins = new String[] { "http://192.168.1.115:4200", "http://localhost:4200" };
//
//				registry.addMapping("/**").allowedOrigins(origins).allowCredentials(true);
//				registry.addMapping("/authenticate/*").allowedOrigins(origins).allowCredentials(true);
//			}
//		};
//
//	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
}
