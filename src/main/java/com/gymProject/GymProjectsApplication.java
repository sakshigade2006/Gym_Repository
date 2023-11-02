package com.gymProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.gymProject.property.FileStorageProperties;

@SpringBootApplication
@EnableConfigurationProperties({
	FileStorageProperties.class
	
})
public class GymProjectsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GymProjectsApplication.class, args);
	}

}
