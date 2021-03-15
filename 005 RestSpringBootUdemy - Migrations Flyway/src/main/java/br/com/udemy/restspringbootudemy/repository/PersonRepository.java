package br.com.udemy.restspringbootudemy.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.udemy.restspringbootudemy.data.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long>{

}
