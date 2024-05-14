package br.edu.univas.si7.topicos.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import br.edu.univas.si7.topicos.Customer.repositories.CustomerRepository;

@SpringBootApplication
public class CustomerApplication {

	/*
	----------------------------------------------------------------
	Trabalho Tópicos Avançados de Sistemas de Informação: 
	----------------------------------------------------------------
	
	1 - Criar a estrutura completa de um endpoint para um CRUD da entidade:
		a) Entity, DTO, repository, service, controller e classes de suport (tratamento de exceptions).
	2 - O sistema deve criar automaticamente o id da entidade no banco.
	3 - Incluir validação dos DTOs nos endpoints.
	4 - Criar os testes de unidade completo para testar a classe de service, includindo:
		a) Mocks
		b) Casos de sucesso e erro
		c) Executar os testes e verificar os resultados
	5 - Executar o projeto e testar usando Postman.
	
	Especificações do endpoint:
	▪ Resource URL: /customers
	▪ Atributos do DTO: name, e-mail, phone e type.
	▪ Operações:
	
	Class Method		Request Body 	Path Variable	HTTP Method		Path Mapping	Response Status
	findAll				- 				-				GET 			-				OK
	findById			-				Integer			GET				/{id}			OK
	createCustomer 		CustomerDTO		-				POST			-				CREATED
	updateCustomer 		CustomerDTO		Integer 		PUT				/{id}			NO_CONTENT
	deleteCustomer 		-				Integer 		DELETE 			/{id}			NO_CONTENT
	*/
	
	@Autowired
	private CustomerRepository repo;

	public static void main(String[] args) {
		SpringApplication.run(CustomerApplication.class, args);
	}

}
