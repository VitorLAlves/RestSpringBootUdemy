package br.com.udemy.restspringbootudemy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.udemy.restspringbootudemy.model.Person;
import br.com.udemy.restspringbootudemy.service.PersonService;

@RestController
@RequestMapping(value = "/person")
public class PersonController {
	
	@Autowired
	PersonService service;
	
	@GetMapping("/{id}")
	public Person getPerson(@PathVariable(value = "id") Long id)
	{
		return service.getById(id);
	}
	
	@GetMapping("/all")
	public List<Person> getAll()
	{
		return service.findAll();
	}
	
	@PostMapping
	public Person createPerson(@RequestBody Person person)
	{
		return service.create(person);
	}
	
	@PutMapping
	public Person attPerson(@RequestBody Person person)
	{
		return service.atualizaPerson(person);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePerson(@PathVariable(value = "id") Long id)
	{
		service.deletaPerson(id);
		return ResponseEntity.ok().build();
	}

}
