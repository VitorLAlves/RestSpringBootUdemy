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
import br.com.udemy.restspringbootudemy.data.vo.PersonVO;
import br.com.udemy.restspringbootudemy.service.PersonService;

@RestController
@RequestMapping(value = "/api/person/v1")
public class PersonController {
	
	@Autowired
	PersonService service;
	
	@GetMapping(value = "/{id}", produces = {"application/json","application/xml"})
	public PersonVO getPerson(@PathVariable(value = "id") Long id)
	{
		return service.getById(id);
	}
	
	@GetMapping(value = "/all", produces = {"application/json","application/xml"})
	public List<PersonVO> getAll()
	{
		return service.findAll();
	}
	
	@PostMapping(consumes = {"application/json","application/xml"},
			produces = {"application/json","application/xml"})
	public PersonVO createPerson(@RequestBody PersonVO person)
	{
		return service.create(person);
	}
	
	@PutMapping(consumes = {"application/json","application/xml"},
			produces = {"application/json","application/xml"})
	public PersonVO attPerson(@RequestBody PersonVO person)
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
