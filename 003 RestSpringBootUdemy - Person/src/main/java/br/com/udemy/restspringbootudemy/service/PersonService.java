package br.com.udemy.restspringbootudemy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.udemy.restspringbootudemy.excpetion.PersonNotFoundException;
import br.com.udemy.restspringbootudemy.model.Person;
import br.com.udemy.restspringbootudemy.repository.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	PersonRepository repository;
	
	public Person create(Person person) {
		return repository.save(person);
	}
	
	public Person atualizaPerson(Person person) {
		
		Person entity = repository.findById(person.getId()).
				orElseThrow(() -> new PersonNotFoundException("No records found for this ID"));
		
		entity.setFirtsName(person.getFirtsName());
		entity.setLastName(person.getLastName());
		entity.setAdress(person.getAdress());
		entity.setGender(person.getGender());
		
		return repository.save(entity);
	}

	public void deletaPerson(Long id) {
		Person entity = repository.findById(id).
				orElseThrow(() -> new PersonNotFoundException("No records found for this ID"));
		
		repository.delete(entity);
	}
	
	public Person getById(Long id)
	{
		return repository.findById(id).
				orElseThrow(() -> new PersonNotFoundException("No records found for this ID"));		
	}
	
	public List<Person> findAll()
	{
		return repository.findAll();
	}
}
