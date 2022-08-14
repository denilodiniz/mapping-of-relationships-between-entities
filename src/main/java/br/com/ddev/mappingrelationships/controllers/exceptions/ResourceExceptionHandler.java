package br.com.ddev.mappingrelationships.controllers.exceptions;

import java.time.Instant;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.ddev.mappingrelationships.services.exceptions.ResourceNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<DefaultExceptionBody> resourceNotFound(ResourceNotFoundException e, HttpServletRequest request) {
		String error = "Resource not found.";
		HttpStatus status = HttpStatus.NOT_FOUND;
		DefaultExceptionBody deb = new DefaultExceptionBody(Instant.now(), status.value(), error, e.getMessage() , request.getRequestURI());
		return ResponseEntity.status(status).body(deb);
	}
	
}
