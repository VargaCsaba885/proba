package com.csaba.demo;

import com.csaba.demo.model.User;
import com.csaba.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestrestApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(TestrestApplication.class, args);
	}

	@Autowired
	private UserRepository userRepository;
	@Override
	public void run(String... args) throws Exception {
		this.userRepository.save(new User("Varga", "Csaba", "VargaCsaba@gmail.com"));
		this.userRepository.save(new User("Vfsd", "Cfdsfaba", "Vargfdsba@gmail.com"));
		this.userRepository.save(new User("Vghrrga", "Csaghdfa", "Vargdfsaba@gmail.com"));
		this.userRepository.save(new User("Vterta", "Chrtba", "VaerterCsaba@gmail.com"));
	}
}
