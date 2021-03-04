package br.com.udemy.restspringbootudemy.excpetion;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class NegativeNumberException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public NegativeNumberException(String exception)
	{
		super(exception);
	}

}
