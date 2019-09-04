package cl.subtel.services;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import cl.subtel.dao.entities.User;
import cl.subtel.dao.repositories.UserRepository;

public class ServiceImpl implements Service {

	@Autowired
	UserRepository noteRepository;

	@Override
	public String saveUser(Map<String, Object> request) {
		User user = new User();
		noteRepository.save(user);
		return "ok";
	}

}
