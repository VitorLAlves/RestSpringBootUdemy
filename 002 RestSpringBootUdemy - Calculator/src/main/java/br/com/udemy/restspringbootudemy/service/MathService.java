package br.com.udemy.restspringbootudemy.service;

import org.springframework.stereotype.Service;

import br.com.udemy.restspringbootudemy.excpetion.MathException;
import br.com.udemy.restspringbootudemy.excpetion.NegativeNumberException;
import br.com.udemy.restspringbootudemy.excpetion.SubException;

@Service
public class MathService {
	
	public Double soma(String numberOne , String numberTwo)
	{
		if(!isNumeric(numberOne) || !isNumeric(numberTwo))
		{
			throw new MathException("Indique dois numeros para a soma");
		}
		Double sum = convertToDouble(numberOne) + convertToDouble(numberTwo);
		return sum;
	}
	
	public Double subtracao(String numberOne, String numberTwo)
	{
		if(!isNumeric(numberOne) || !isNumeric(numberTwo))
		{
			throw new SubException("Indique dois numeros para a subtração");
		}
		double sub = convertToDouble(numberOne) - convertToDouble(numberTwo);
		if(sub < 0) throw new NegativeNumberException("Resultado nao pode ser negativo");
		return sub;
	}
	
	public Double convertToDouble(String texto) {
		if(texto == null) return 0D;
		String number = texto.replaceAll(",", ".");
		double convertNumber = Double.parseDouble(number);
		return convertNumber;
	}

	public boolean isNumeric(String strNumber) {
		if(strNumber == null)
		{
			return false;
		}
		try {
			strNumber.replaceAll(",", ".");
			Double.parseDouble(strNumber);
		}
		catch(NumberFormatException nfe) {
			return false;
		}
		return true;
	}

}
