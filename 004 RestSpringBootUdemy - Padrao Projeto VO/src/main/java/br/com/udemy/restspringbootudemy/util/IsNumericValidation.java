package br.com.udemy.restspringbootudemy.util;

import org.springframework.stereotype.Service;

@Service
public class IsNumericValidation {
	
	public boolean isNumeric(String texto) {
		if(texto == null)
		{
			return false;
		}
		try {
			texto.replaceAll(",", ".");
			Double.parseDouble(texto);
		}
		catch(NumberFormatException nfe) {
			return false;
		}
		return true;
	}

	public Long convertToLong(String id) {
		String number = id.replaceAll(",", ".");
		Long convertNumber = Long.parseLong(number);
		return convertNumber;
	}

}
