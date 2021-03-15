package br.com.udemy.restspringbootudemy.converter;

import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import br.com.udemy.restspringbootudemy.converter.mocks.MockPerson;
import br.com.udemy.restspringbootudemy.data.model.Person;

public class PersonDozerConverterTest {
	
	MockPerson inputObject;

    @Before
    public void setUp() {
        inputObject = new MockPerson();
    }

    @Test
    public void parseEntityToVOTest() {
        Person output = PersonDozerConverter.PersonVOToPerson(inputObject.mockVO());
        Assert.assertEquals(Long.valueOf(0L), output.getId());
        Assert.assertEquals("First Name Test0", output.getFirtsName());
        Assert.assertEquals("Last Name Test0", output.getLastName());
        Assert.assertEquals("Addres Test0", output.getAdress());
        Assert.assertEquals("Male", output.getGender());
    }
    
    @Test
    public void parserVOListToEntityListTest() {
        List<Person> outputList = PersonDozerConverter.PersonVOListToPersonList(inputObject.mockVOList());
        Person outputZero = outputList.get(0);
        
        Assert.assertEquals(Long.valueOf(0L), outputZero.getId());
        Assert.assertEquals("First Name Test0", outputZero.getFirtsName());
        Assert.assertEquals("Last Name Test0", outputZero.getLastName());
        Assert.assertEquals("Addres Test0", outputZero.getAdress());
        Assert.assertEquals("Male", outputZero.getGender());
        
        Person outputSeven = outputList.get(7);
        
        Assert.assertEquals(Long.valueOf(7L), outputSeven.getId());
        Assert.assertEquals("First Name Test7", outputSeven.getFirtsName());
        Assert.assertEquals("Last Name Test7", outputSeven.getLastName());
        Assert.assertEquals("Addres Test7", outputSeven.getAdress());
        Assert.assertEquals("Female", outputSeven.getGender());
        
        Person outputTwelve = outputList.get(12);
        
        Assert.assertEquals(Long.valueOf(12L), outputTwelve.getId());
        Assert.assertEquals("First Name Test12", outputTwelve.getFirtsName());
        Assert.assertEquals("Last Name Test12", outputTwelve.getLastName());
        Assert.assertEquals("Addres Test12", outputTwelve.getAdress	());
        Assert.assertEquals("Male", outputTwelve.getGender());
    }


}
