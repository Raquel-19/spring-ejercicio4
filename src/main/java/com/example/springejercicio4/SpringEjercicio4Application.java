package com.example.springejercicio4;

import com.example.springejercicio4.model.User;
import com.example.springejercicio4.repository.BusinessRepository;
import com.example.springejercicio4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringEjercicio4Application {

	@Autowired
	private UserRepository repositoryUser;

	@Autowired
	private BusinessRepository repositoryBusiness;

	public static void main(String[] args) {
		SpringApplication.run(SpringEjercicio4Application.class, args);
	}
}
