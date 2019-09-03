package cl.subtel.dao;

import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

public class DAOImpl implements DAO {
	
	JdbcTemplate jdbcTemplateObject;
	public DataSource bdcDataSource;

	public void setDataSource(DataSource dataSource) {
		this.bdcDataSource = dataSource;
		this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	}

	@Override
	public String saveUser(Map<String, Object> request) {
		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(this.bdcDataSource)
				.withSchemaName("challenge")
				.withProcedureName("add_user");
		SqlParameterSource in = new MapSqlParameterSource()
				.addValue("name", request.get("name"))
				.addValue("lastname", request.get("lastname"))
				.addValue("brirthname", request.get("brirthname"))
				.addValue("contact_number", request.get("contactNumber"))
				.addValue("address", request.get("address"))
				.addValue("email", request.get("email"))
				.addValue("country", request.get("country"));
		try {
			Map<String, Object> out = jdbcCall.execute(in);
			System.out.println((String) out.get("message"));
		} catch (Exception e) {
			throw e;
		}
		return null;
	}

}
