package br.com.udemy.restspringbootudemy.controller;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

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
	
	@GetMapping(value = "/{id}", produces = {"application/json","application/xml","application/x-yaml"})
	public PersonVO getPerson(@PathVariable(value = "id") Long id)
	{
		PersonVO personVO = service.getById(id);
		personVO.add(linkTo(methodOn(PersonController.class).getPerson(id)).withSelfRel());
		return personVO;
	}
	
	@GetMapping(value = "/all", produces = {"application/json","application/xml","application/x-yaml"})
	public List<PersonVO> getAll()
	{
		List<PersonVO> personVOList = service.findAll();
		personVOList.stream().forEach(p -> p.add(linkTo(methodOn(PersonController.class).getPerson(p.getKey())).withSelfRel()));
		return personVOList;
	}
	
	@PostMapping(consumes = {"application/json","application/xml","application/x-yaml"},
			produces = {"application/json","application/xml","application/x-yaml"})
	public PersonVO createPerson(@RequestBody PersonVO person)
	{
		PersonVO personVO = service.create(person);
		personVO.add(linkTo(methodOn(PersonController.class).getPerson(personVO.getKey())).withSelfRel());
		return personVO;
	}
	
	@PutMapping(consumes = {"application/json","application/xml","application/x-yaml"},
			produces = {"application/json","application/xml","application/x-yaml"})
	public PersonVO attPerson(@RequestBody PersonVO person)
	{
		PersonVO personVO = service.atualizaPerson(person);
		personVO.add(linkTo(methodOn(PersonController.class).getPerson(personVO.getKey())).withSelfRel());
		return personVO;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePerson(@PathVariable(value = "id") Long id)
	{
		service.deletaPerson(id);
		return ResponseEntity.ok().build();
	}

}
