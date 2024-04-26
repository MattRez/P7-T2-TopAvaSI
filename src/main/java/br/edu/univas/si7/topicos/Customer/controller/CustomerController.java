package br.edu.univas.si7.topicos.Customer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.edu.univas.si7.topicos.Customer.dtos.CustomerDTO;
import br.edu.univas.si7.topicos.Customer.entities.CustomerEntity;
import br.edu.univas.si7.topicos.Customer.service.CustomerService;
import br.edu.univas.si7.topicos.Customer.util.CustomerEntityConverter;

@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService service;
	
	
	@GetMapping("")
	@ResponseStatus(HttpStatus.OK)
	public List<CustomerDTO> getAllCustomers() {
		return service.findAll();
	}
	
	@GetMapping("/{code}")
	public CustomerDTO getProductById(@PathVariable Integer code) {
		CustomerEntity entity = service.findById(code);
		return CustomerEntityConverter.toDTO(entity);
	}
	
	@GetMapping("/active")
	@ResponseStatus(HttpStatus.OK)
	public List<CustomerDTO> getAllProductsActive() {
		return service.findByActive(true);
	}
	
	@PostMapping("")
	@ResponseStatus(HttpStatus.CREATED)
	public void createCustomer(@RequestBody CustomerDTO customer) {
		service.createCustomer(customer);
	}
	
	@PutMapping("/{code}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateCustomer(@RequestBody CustomerDTO dto, @PathVariable Integer code) {
		service.updateCustomer(dto, code);
	}

	@DeleteMapping("/{code}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteCustomer(@PathVariable Integer code) {
		service.deleteCustomer(code);
	}
	
}
