package cl.subtel.application;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cl.subtel.services.Service;
import cl.subtel.services.ServiceImpl;

@Configuration
public class ApplicationConfiguration {
	
	@Bean
	public Service getService() {
		return new ServiceImpl();
	}

}
