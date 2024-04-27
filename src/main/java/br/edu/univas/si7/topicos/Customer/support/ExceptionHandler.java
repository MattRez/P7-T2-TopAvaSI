package br.edu.univas.si7.topicos.Customer.support;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import br.edu.univas.si7.topicos.Customer.support.ObjectNotFoundException;
import br.edu.univas.si7.topicos.Customer.support.StandardError;
import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ExceptionHandler {

	@org.springframework.web.bind.annotation.ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> handleObjectNotFound(ObjectNotFoundException ex, HttpServletRequest req) {
		StandardError error = new StandardError(ex.getMessage(), HttpStatus.NOT_FOUND.value(), new Date());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}

	@org.springframework.web.bind.annotation.ExceptionHandler(CustomerException.class)
	public ResponseEntity<StandardError> handleObjectNotFound(CustomerException ex, HttpServletRequest req) {
		StandardError error = new StandardError(ex.getMessage(), HttpStatus.BAD_REQUEST.value(), new Date());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
}
