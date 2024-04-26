package br.edu.univas.si7.topicos.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.univas.si7.topicos.Customer.repositories.CustomerRepository;

@SpringBootApplication
public class CustomerApplication {
	
	@Autowired
	private CustomerRepository repo;
	
	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

}
