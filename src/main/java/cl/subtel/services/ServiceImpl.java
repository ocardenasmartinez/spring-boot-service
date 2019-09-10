package cl.subtel.services;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import cl.subtel.dao.entities.User;
import cl.subtel.dao.repositories.UserRepository;

public class ServiceImpl implements Service {

	private static final String NOK = "nok";
	private static final String OK = "ok";
	private static final String DD_MM_YYYY = "dd/MM/yyyy";
	
	@Autowired
	UserRepository noteRepository;

	@Override
	public String saveUser(Map<String, Object> request) {
		User user = new User();
		user.setName((String) request.get("name"));
		user.setLastname((String) request.get("lastname"));
		user.setBirthdate(convertStringDate((String) request.get("birthdate")));
		user.setContactNumber(((Number) request.get("contactNumber")).longValue());
		user.setCountry((String) request.get("country"));
		user.setAddress((String) request.get("address"));
		user.setEmail((String) request.get("email"));
		user.setCreatedAt(Date.from(Instant.now()));
		user.setUpdatedAt(Date.from(Instant.now()));
		try {
			noteRepository.save(user);
			return OK;
		}catch(Exception e) {
			return NOK;
		}
	}
	
	private static Date convertStringDate(String date) {
		return Date.from(
			LocalDate.parse(
				date, DateTimeFormatter.ofPattern(DD_MM_YYYY)).atStartOfDay().atZone(ZoneId.systemDefault())
					.toInstant());
	}

}
