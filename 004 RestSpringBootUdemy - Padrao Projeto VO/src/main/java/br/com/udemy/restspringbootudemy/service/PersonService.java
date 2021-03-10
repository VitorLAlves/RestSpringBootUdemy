package br.com.udemy.restspringbootudemy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.udemy.restspringbootudemy.converter.PersonDozerConverter;
import br.com.udemy.restspringbootudemy.data.model.Person;
import br.com.udemy.restspringbootudemy.data.vo.PersonVO;
import br.com.udemy.restspringbootudemy.excpetion.IncorretFormatIdException;
import br.com.udemy.restspringbootudemy.excpetion.PersonNotFoundException;
import br.com.udemy.restspringbootudemy.repository.PersonRepository;
import br.com.udemy.restspringbootudemy.util.IsNumericValidation;

@Service
public class PersonService {
	
	@Autowired
	PersonRepository repository;
	
	@Autowired
	IsNumericValidation validation;
	
	public PersonVO create(PersonVO personVO) {
		Person person = PersonDozerConverter.PersonVOToPerson(personVO);
		return PersonDozerConverter.PersonToPersonVO(repository.save(person));
	}
	
	public PersonVO atualizaPerson(PersonVO personVO) {
		
		Person person = PersonDozerConverter.PersonVOToPerson(personVO);
		
		repository.findById(person.getId()).
				orElseThrow(() -> new PersonNotFoundException("No records found for this ID"));
		
		person.setFirtsName(person.getFirtsName());
		person.setLastName(person.getLastName());
		person.setAdress(person.getAdress());
		person.setGender(person.getGender());
		
		return PersonDozerConverter.PersonToPersonVO(repository.save(person));
	}

	public void deletaPerson(String id) {
		
		if(!validation.isNumeric(id))
			throw new IncorretFormatIdException("ID na rota precisa ser um valor numerico");
		
		Person entity = repository.findById(validation.convertToLong(id)).
				orElseThrow(() -> new PersonNotFoundException("No records found for this ID"));
		
		repository.delete(entity);
	}
	
	public PersonVO getById(String id)
	{
		if(!validation.isNumeric(id))
			throw new IncorretFormatIdException("ID na rota precisa ser um valor numerico");
		
		return  PersonDozerConverter.PersonToPersonVO(repository.findById(validation.convertToLong(id)).
				orElseThrow(() -> new PersonNotFoundException("No records found for this ID")));		
	}
	
	public List<PersonVO> findAll()
	{
		return PersonDozerConverter.PersonListToPersonVOList(repository.findAll()); 
	}
}
