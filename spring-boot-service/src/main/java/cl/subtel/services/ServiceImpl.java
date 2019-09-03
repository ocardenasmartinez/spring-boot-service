package cl.subtel.services;

import java.util.Map;

import cl.subtel.dao.DAO;

public class ServiceImpl implements Service {

	private DAO dao;

	public void setDao(DAO dao) {
		this.dao = dao;
	}

	@Override
	public String saveUser(Map<String, Object> request) {
		return dao.saveUser(request);
	}

}
