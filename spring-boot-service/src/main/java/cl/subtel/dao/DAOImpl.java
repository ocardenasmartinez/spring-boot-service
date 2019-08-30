package cl.subtel.dao;

import java.util.List;
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
	public List<Map<String, Object>> getList(String request) {
		SimpleJdbcCall jdbcCall = new SimpleJdbcCall(this.bdcDataSource)
				.withSchemaName("postgres")
				.withCatalogName("public")
				.withProcedureName("hello_world");
		String response = "";
		SqlParameterSource in = new MapSqlParameterSource().addValue("i", Integer.parseInt(request));
		try {
			Map<String, Object> out = jdbcCall.execute(in);
			response = (String) out.get("PARAMETER_OUT");
		} catch (Exception e) {
			throw e;
		}
		return null;
	}

}
