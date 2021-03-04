package br.com.udemy.restspringbootudemy.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.udemy.restspringbootudemy.service.MathService;

@RestController
public class MathController {
	
	private MathService service = new MathService();
	
	@RequestMapping(value = "/calculator/sum/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double sumCalculator(@PathVariable(value="numberOne") String numberOne, @PathVariable(value="numberTwo") String numberTwo) {
		
		
		return service.soma(numberOne, numberTwo);	
	}
	
	@RequestMapping(value = "/calculator/sub/{numberOne}/{numberTwo}", method = RequestMethod.GET)
	public Double subtracaoCalculator(@PathVariable(value = "numberOne") String numberOne, @PathVariable(value = "numberTwo") String numberTwo)
	{
		return service.subtracao(numberOne, numberTwo);	
	}

}
