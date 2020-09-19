package com.mongo.springbootMongo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AccessingDataMongoTemplate implements CommandLineRunner {

	@Autowired
	private CustomerDAOImpl customerDAOImpl;

	public static void main(String[] args) {
		SpringApplication.run(AccessingDataMongoTemplate.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Customer customer_1 = new Customer("12", "Abhishek", "Honey", "abhishek.honey@gmail.com", "male", "0.0.0.1");
		customerDAOImpl.insert(customer_1);

		Customer customerById = customerDAOImpl.getCustomerById("12");
		System.out.println(customerById);

		List<Customer> customerByEmail = customerDAOImpl.getCustomerByEmail("abhishek.honey@gmail.com");
		System.out.println(customerByEmail);
	}
}