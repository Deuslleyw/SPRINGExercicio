package com.example.demo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.demo.emtities.Category;
import com.example.demo.emtities.Order;
import com.example.demo.emtities.Product;
import com.example.demo.emtities.User;
import com.example.demo.emtities.enums.OrderStatus;
import com.example.demo.repositories.CategoryRepository;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private OrderRepository orderrespository;

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		
	User u1 = new User(01, "Maria", "maria@gmail.com", "48998473257", "53214");	      //Id null não funcionou<< a verificar"
	User u2 = new User(02, "Aline", "Aline@gmail.com", "54998473277", "50024");	

	
	Order o1 = new Order (null,Instant.parse("2021-06-23T18:54:07Z"),OrderStatus.PAID, u1);
	Order o2 = new Order (null,Instant.parse("2021-06-18T15:47:10Z"),OrderStatus.SHIPPED, u2);	
	Order o3 = new Order (null,Instant.parse("2021-06-21T05:25:14Z"),OrderStatus.CANCELED, u1);	
	
	
	Category cat1 = new Category(01,"Eletronics");
	Category cat2 = new Category(02,"Books");
	Category cat3 = new Category(03,"Computers");
	
	Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, ""); 
	Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, ""); 
	Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, ""); 
	Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, ""); 
	Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, ""); 
	
	
   
	categoryRepository.saveAll(Arrays.asList(cat1, cat2,cat3));

	productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5));
	
	
	
  	userRepository.saveAll(Arrays.asList(u1,u2));
  	orderrespository.saveAll(Arrays.asList(o1,o2,o3));
	}
	
}
