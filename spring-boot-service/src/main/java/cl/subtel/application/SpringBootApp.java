package cl.subtel.application;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import cl.subtel.services.Service;
import cl.subtel.services.ServiceImpl;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@ComponentScan(basePackages = { "cl.subtel.controllers" })
@EntityScan("cl.subtel.dao.entities")
@EnableJpaRepositories("cl.subtel.dao.repositories")
public class SpringBootApp {

	public static void main(String[] args) {
		String[] beanNames = SpringApplication.run(SpringBootApp.class, args).getBeanDefinitionNames();
		Arrays.sort(beanNames);
		Arrays.asList(beanNames).forEach(System.out::println);
	}
	
	@Bean
	public Service getService() {
		Service service = new ServiceImpl();
		return service;
	}
	
}
