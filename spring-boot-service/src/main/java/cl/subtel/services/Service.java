package cl.subtel.services;

import java.util.List;
import java.util.Map;

import cl.subtel.dao.DAO;

public interface Service {
	
	public List<Map<String, Object>> getList(String request);
	public void setDao(DAO dao);
}
