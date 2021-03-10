package br.com.udemy.restspringbootudemy.converter;

import java.util.ArrayList;
import java.util.List;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import br.com.udemy.restspringbootudemy.data.model.Person;
import br.com.udemy.restspringbootudemy.data.vo.PersonVO;

public class PersonDozerConverter {
	
	private static Mapper mapper = DozerBeanMapperBuilder.buildDefault();
	
	public static Person PersonVOToPerson(PersonVO personVO) {
		return mapper.map(personVO, Person.class);
				
	}
	
	public static PersonVO PersonToPersonVO(Person person) {
		return mapper.map(person, PersonVO.class);
				
	}
	
	public static List<Person> PersonVOListToPersonList(List<PersonVO> personVOList){
		List<Person> personList = new ArrayList<Person>();
		
		for (PersonVO personVO : personVOList) {
			personList.add(mapper.map(personVO, Person.class));
		}
		
		return personList;
	}
	
	public static List<PersonVO> PersonListToPersonVOList(List<Person> personList){
		List<PersonVO> personListVO = new ArrayList<PersonVO>();
		
		for (Person person : personList) {
			personListVO.add(mapper.map(person, PersonVO.class));
		}
		
		return personListVO;
	}
}
