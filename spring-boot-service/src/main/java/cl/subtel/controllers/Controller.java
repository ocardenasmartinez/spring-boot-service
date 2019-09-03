package cl.subtel.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import cl.subtel.controllers.entities.SaveUser;
import cl.subtel.controllers.entities.ServiceResponse;
import cl.subtel.services.Service;

@RestController
public class Controller {
	
	@Autowired
	Service service;

	@RequestMapping(value = "/", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ServiceResponse<String> saveUser(@RequestBody SaveUser saveUser) {
		ServiceResponse<String> response = new ServiceResponse<>();
		Map<String, Object> request = new HashMap<>();
		request.put("name", saveUser.getName());
		request.put("lastname", saveUser.getLastname());
		request.put("brirthname", saveUser.getBrirthname());
		request.put("contactNumber", saveUser.getContactNumber());
		request.put("address", saveUser.getAddress());
		request.put("email", saveUser.getEmail());
		request.put("country", saveUser.getCountry());
		response.setError(null);
		response.setStatus("ok");
		response.setData(service.saveUser(request));
		return response;
	}

}
