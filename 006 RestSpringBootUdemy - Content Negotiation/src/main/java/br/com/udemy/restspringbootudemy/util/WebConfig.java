package br.com.udemy.restspringbootudemy.util;

import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import br.com.udemy.restspringbootudemy.serialization.converterYml.YamlToHttpMessageConverter;

@Configuration
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer {
	
	private static final MediaType MEDIA_TYPE_YML = MediaType.valueOf("application/x-yaml");
	
	@Override
	public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
		
		//Via QUERY PARAM. Ex: ?type=json || ?type=xml
		//        configurer
		//        .defaultContentType(MediaType.APPLICATION_JSON)
		//        .parameterName("type")
		//        .favorParameter(true)
		//        .ignoreAcceptHeader(true)
		//        .useRegisteredExtensionsOnly(false)
		//        .mediaType("json", MediaType.APPLICATION_JSON)
		//        .mediaType("xml", MediaType.APPLICATION_XML);

		//Via HEADERS. Ex: Accept: application/xml || application/json
		configurer
		.favorParameter(false)
		.ignoreAcceptHeader(false)
		.useRegisteredExtensionsOnly(false)
		.defaultContentType(MediaType.APPLICATION_JSON)
		.mediaType("json", MediaType.APPLICATION_JSON)
		.mediaType("xml", MediaType.APPLICATION_XML)
		.mediaType("x-yaml", MEDIA_TYPE_YML);
	}
	
	@Override
	public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
		converters.add(new YamlToHttpMessageConverter());
	}

}
