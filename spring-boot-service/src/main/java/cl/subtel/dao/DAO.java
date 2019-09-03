package cl.subtel.dao;

import java.util.Map;

import javax.sql.DataSource;

public interface DAO {

	public void setDataSource(DataSource dataSource);
	public String saveUser(Map<String, Object> request);
	
}
