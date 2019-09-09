package cl.subtel.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import cl.subtel.mock.ServiceMock;
import cl.subtel.services.Service;

@Configuration
@EnableWebMvc
@PropertySource("classpath:application.properties")
@ComponentScan(basePackages = "cl.subtel.controllers")
public class ApplicationConfigurationWebMock implements WebMvcConfigurer  {
	
	@Bean()
	public Service getBusiness() throws Exception {
		return new ServiceMock();
	}

}