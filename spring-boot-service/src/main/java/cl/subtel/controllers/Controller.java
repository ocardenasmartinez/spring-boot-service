package cl.subtel.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.subtel.services.Service;

@RestController
public class Controller {
	
	@Autowired
	Service service;

	@RequestMapping("/")
	public List<Map<String, Object>> getList() {		
		return service.getList("1");
	}

}
