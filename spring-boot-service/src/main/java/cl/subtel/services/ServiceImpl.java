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
		user.setBirthdate(
			convertToDateViaInstant(
				LocalDate.parse(
					(String) request.get("birthdate"), DateTimeFormatter.ofPattern(DD_MM_YYYY))));
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
	
	private Date convertToDateViaInstant(LocalDate dateToConvert) {
	    return java.util.Date.from(dateToConvert.atStartOfDay()
	      .atZone(ZoneId.systemDefault())
	      .toInstant());
	}

}
