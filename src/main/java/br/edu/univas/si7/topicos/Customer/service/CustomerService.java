package br.edu.univas.si7.topicos.Customer.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import br.edu.univas.si7.topicos.Customer.dtos.CustomerDTO;
import br.edu.univas.si7.topicos.Customer.entities.CustomerEntity;
import br.edu.univas.si7.topicos.Customer.repositories.CustomerRepository;
import br.edu.univas.si7.topicos.Customer.support.CustomerException;
import br.edu.univas.si7.topicos.Customer.support.ObjectNotFoundException;
import br.edu.univas.si7.topicos.Customer.util.CustomerEntityConverter;

@Service
public class CustomerService {

	private CustomerRepository repo;

	@Autowired
	private CustomerEntityConverter converter;

	@Autowired
	public CustomerService(CustomerRepository repo) {
		this.repo = repo;
	}

	public List<CustomerDTO> findAll() {
		return repo.findAll().stream().map(CustomerEntityConverter::toDTO).collect(Collectors.toList());
	}

	public CustomerEntity findById(Integer id) {
		Optional<CustomerEntity> obj = repo.findById(id);
		CustomerEntity entity = obj.orElseThrow(() -> new ObjectNotFoundException("Object not found: " + id));
		return entity;
	}

	public List<CustomerDTO> findByActive(boolean b) {
		return repo.findByActive(true).stream().map(CustomerEntityConverter::toDTO).collect(Collectors.toList());
	}

	public void createCustomer(CustomerDTO product) {
		repo.save(converter.toEntity(product));
	}

	public void updateCustomer(CustomerDTO customer, Integer id) {
		if (id == null || customer == null || !id.equals(customer.getId())) {
			throw new CustomerException("Invalid product code.");
		}
		CustomerEntity existingObj = findById(id);
		updateData(existingObj, customer);
		repo.save(existingObj);
	}

	private void updateData(CustomerEntity existingObj, CustomerDTO newObj) {
		existingObj.setName(newObj.getName());
		existingObj.setEmail(newObj.getEmail());
		existingObj.setPhoneNumber(newObj.getPhoneNumber());
		existingObj.setActive(newObj.isActive());
		existingObj.setDocumentNumber(newObj.getDocumentNumber());
	}

	public void deleteCustomer(Integer code) {
		if (code == null) {
			throw new CustomerException("Product code can not be null.");
		}
		CustomerEntity obj = findById(code);
		try {
			obj.setActive(false);
			repo.save(obj);
		} catch (DataIntegrityViolationException e) {
			throw new CustomerException("Can not delete a Product with dependencies constraints.");
		}
	}
}
