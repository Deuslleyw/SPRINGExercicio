package com.example.demo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.demo.emtities.Order;
import com.example.demo.emtities.User;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private OrderRepository orderrespository;

	@Override
	public void run(String... args) throws Exception {
		
	User u1 = new User(01, "Maria", "maria@gmail.com", "48998473257", "53214");	      //Id null não funcionou<< a verificar"
	User u2 = new User(02, "Aline", "Aline@gmail.com", "54998473277", "50024");	

	
	Order o1 = new Order (01,Instant.parse("2021-06-23T18:54:07Z"),u1);
	Order o2 = new Order (02,Instant.parse("2021-06-18T15:47:10Z"),u2);	
	Order o3 = new Order (01,Instant.parse("2021-06-21T05:25:14Z"),u1);	
	
	
  	userRepository.saveAll(Arrays.asList(u1,u2));
  	orderrespository.saveAll(Arrays.asList(o1,o2,o3));
	}
	
}
