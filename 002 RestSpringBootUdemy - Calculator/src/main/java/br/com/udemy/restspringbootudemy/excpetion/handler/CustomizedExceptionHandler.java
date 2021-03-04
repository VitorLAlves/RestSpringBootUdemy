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
import br.com.udemy.restspringbootudemy.excpetion.MathException;
import br.com.udemy.restspringbootudemy.excpetion.NegativeNumberException;
import br.com.udemy.restspringbootudemy.excpetion.SubException;

@RestController
@ControllerAdvice
public class CustomizedExceptionHandler extends ResponseEntityExceptionHandler{
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<ExceptionResponse> handleAllExceptions(Exception ex, WebRequest request)
	{
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage() , request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(MathException.class)
	public final ResponseEntity<ExceptionResponse> handleMathException(MathException ex, WebRequest request)
	{
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), ex.getMessage() , request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(SubException.class)
	public final ResponseEntity<ExceptionResponse> handleSubException(SubException subex, WebRequest request){
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), subex.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NegativeNumberException.class)
	public ResponseEntity<ExceptionResponse> handleNegativeNumberException(NegativeNumberException negativeNumberException, WebRequest request)
	{
		ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), negativeNumberException.getMessage(), request.getDescription(false));
		return new ResponseEntity<>(exceptionResponse,HttpStatus.BAD_REQUEST);
	}
	
	

}
