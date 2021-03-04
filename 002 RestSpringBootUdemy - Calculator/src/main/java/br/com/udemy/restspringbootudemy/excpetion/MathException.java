package br.com.udemy.restspringbootudemy.excpetion;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class MathException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public MathException(String excpetion) {
		super(excpetion);
	}

}
