package br.com.udemy.restspringbootudemy.serialization.converterYml;

import org.springframework.http.MediaType;
import org.springframework.http.converter.json.AbstractJackson2HttpMessageConverter;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

public final class YamlToHttpMessageConverter extends AbstractJackson2HttpMessageConverter{

	public YamlToHttpMessageConverter() {
		super(new YAMLMapper(), MediaType.parseMediaType("application/x-yaml"));
	}
	
	

}
