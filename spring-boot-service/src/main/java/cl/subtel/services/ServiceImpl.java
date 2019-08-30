package cl.subtel.services;

import java.util.List;
import java.util.Map;

import cl.subtel.dao.DAO;

public class ServiceImpl implements Service {

	private DAO dao;

	public void setDao(DAO dao) {
		this.dao = dao;
	}

	@Override
	public List<Map<String, Object>> getList(String request) {
		return dao.getList(request);
	}

}
