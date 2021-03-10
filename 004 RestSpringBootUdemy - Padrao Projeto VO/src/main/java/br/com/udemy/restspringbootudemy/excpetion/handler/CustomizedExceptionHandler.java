package br.com.udemy.restspringbootudemy.excpetion.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.udemy.restspringbootudemy.excpetion.ExceptionResponse;
import br.com.udemy.restspringbootudemy.excpetion.IncorretFormatIdException;
import br.com.udemy.restspringbootudemy.excpetion.PersonNotFoundException;

@RestController
@ControllerAdvice
public class CustomizedExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request)
	{
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage() , request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(PersonNotFoundException.class)
	public ResponseEntity<ExceptionResponse> handleNotFound(PersonNotFoundException exception, WebRequest request)
	{
		ExceptionResponse response = new ExceptionResponse(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(IncorretFormatIdException.class)
	public ResponseEntity<ExceptionResponse> handleIncorretFormatId(IncorretFormatIdException exception, WebRequest request)
	{
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), exception.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	
}
