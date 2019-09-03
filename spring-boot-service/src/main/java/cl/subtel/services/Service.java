package cl.subtel.services;

import java.util.Map;

import cl.subtel.dao.DAO;

public interface Service {
	
	public String saveUser(Map<String, Object> request);
	public void setDao(DAO dao);
}
