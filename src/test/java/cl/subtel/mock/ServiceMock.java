package cl.subtel.mock;

import java.util.Map;

import cl.subtel.services.Service;

public class ServiceMock implements Service {

	@Override
	public String saveUser(Map<String, Object> request) {
		return "ok";
	}

}
