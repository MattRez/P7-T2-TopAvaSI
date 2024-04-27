package br.edu.univas.si7.topicos.Customer.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class CustomerDTO {
	private Integer id;
	private String name;
	private String email;
	private String phoneNumber;
	private boolean active;
	
	/*
	name
	e-mail
	phone
	type
	*/
}
