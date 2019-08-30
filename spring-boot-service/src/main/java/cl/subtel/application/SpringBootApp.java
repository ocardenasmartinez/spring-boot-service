package cl.subtel.application;

import java.util.Arrays;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import cl.subtel.services.Service;
import cl.subtel.services.ServiceImpl;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@ComponentScan(basePackages = { "cl.subtel.controllers" })
public class SpringBootApp {

	public static void main(String[] args) {
		String[] beanNames = SpringApplication.run(SpringBootApp.class, args).getBeanDefinitionNames();
		Arrays.sort(beanNames);
		Arrays.asList(beanNames).forEach(System.out::println);
	}

	@Bean
	public Service getService() {
		return new ServiceImpl();
	}

	@Bean
	public DataSource getDataSource() {
		BasicDataSource dataSource = new BasicDataSource();
		dataSource.setDriverClassName("");
		dataSource.setUrl("");
		dataSource.setUsername("postgres");
		dataSource.setPassword("123456");
		return dataSource;
	}

}
