package br.com.udemy.restspringbootudemy.excpetion;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class PersonNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public PersonNotFoundException(String msg)
	{
		super(msg);
	}

}
