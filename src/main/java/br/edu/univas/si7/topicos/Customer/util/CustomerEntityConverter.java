package br.edu.univas.si7.topicos.Customer.util;

import org.springframework.stereotype.Component;

import br.edu.univas.si7.topicos.Customer.dtos.CustomerDTO;
import br.edu.univas.si7.topicos.Customer.entities.CustomerEntity;

@Component
public class CustomerEntityConverter {

	public static CustomerDTO toDTO(CustomerEntity customer) {
		System.out.println("toDTO: " + customer);
		return new CustomerDTO(customer.getId(), customer.getName(), customer.getEmail(), customer.getPhoneNumber(),
				customer.isActive(), customer.getDocumentNumber());
	}

	public CustomerEntity toEntity(CustomerDTO customer) {
		System.out.println("toEntity: " + customer);
		return new CustomerEntity(customer.getId(), customer.getName(), customer.getEmail(), customer.getPhoneNumber(),
				customer.isActive(), customer.getDocumentNumber());
	}
}
