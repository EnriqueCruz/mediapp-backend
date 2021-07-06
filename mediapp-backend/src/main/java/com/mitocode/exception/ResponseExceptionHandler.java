package com.mitocode.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice // estpa anotación escanea los errores en loos paquetes del proyecto y evitar el uso de try catch
@RestController
public class ResponseExceptionHandler extends ResponseEntityExceptionHandler{ // la clase ResponseEntityExceptionHandler implementa métodos de excepción más comunes en servicios rest 

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionResponse> manejarExcepcionesExtraordinarias(ModeloNotFoundException ex, WebRequest request){
		ExceptionResponse exception = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(ModeloNotFoundException.class)
	public ResponseEntity<ExceptionResponse> manejarPacienteNoEncontrado(ModeloNotFoundException ex, WebRequest request){
		ExceptionResponse exception = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(exception, HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionResponse exception = new ExceptionResponse(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
	}
	
}
