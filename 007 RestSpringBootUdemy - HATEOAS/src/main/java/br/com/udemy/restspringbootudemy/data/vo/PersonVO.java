package br.com.udemy.restspringbootudemy.data.vo;

import java.io.Serializable;

import org.springframework.hateoas.RepresentationModel;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.github.dozermapper.core.Mapping;

@JsonPropertyOrder({"key","firtsName","lastName","adress","gender"})
public class PersonVO extends RepresentationModel<PersonVO> implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Mapping("Id")
	private Long Key;
	
	@JsonProperty("Nome")
	private String firtsName;

	@JsonProperty("Sobrenome")
	private String lastName;
	
	@JsonProperty("Endereco")
	private String adress;
	
	@JsonProperty("Genero")
	private String gender;
	
	public PersonVO() {
		
	}


	public Long getKey() {
		return Key;
	}


	public void setKey(Long key) {
		Key = key;
	}


	public String getFirtsName() {
		return firtsName;
	}

	public void setFirtsName(String firtsName) {
		this.firtsName = firtsName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((Key == null) ? 0 : Key.hashCode());
		result = prime * result + ((adress == null) ? 0 : adress.hashCode());
		result = prime * result + ((firtsName == null) ? 0 : firtsName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonVO other = (PersonVO) obj;
		if (Key == null) {
			if (other.Key != null)
				return false;
		} else if (!Key.equals(other.Key))
			return false;
		if (adress == null) {
			if (other.adress != null)
				return false;
		} else if (!adress.equals(other.adress))
			return false;
		if (firtsName == null) {
			if (other.firtsName != null)
				return false;
		} else if (!firtsName.equals(other.firtsName))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		return true;
	}

}
