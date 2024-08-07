package com.like;

import java.util.TimeZone;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

import jakarta.annotation.PostConstruct;

@ConfigurationPropertiesScan
@SpringBootApplication
public class ConnectBoot33Application {

	public static void main(String[] args) {
		SpringApplication.run(ConnectBoot33Application.class, args);
	}
	
	@PostConstruct
	void started() {
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Seoul"));
	}

}
