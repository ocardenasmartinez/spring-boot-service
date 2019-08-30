package cl.subtel.dao;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

public interface DAO {

	public void setDataSource(DataSource dataSource);
	public List<Map<String, Object>> getList(String request);
	
}
