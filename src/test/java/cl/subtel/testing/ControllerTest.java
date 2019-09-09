package cl.subtel.testing;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

import cl.subtel.application.ApplicationConfigurationWebMock;
import cl.subtel.controllers.entities.SaveUser;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = ApplicationConfigurationWebMock.class)
public class ControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void saveUser() throws Exception {
		SaveUser request = new SaveUser();
		this.mockMvc.perform(
			post("/saveuser")
				.contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(request)))
					.andDo(print())
					.andExpect(status().isOk())
					.andExpect(jsonPath("$.status").value("ok"))
	        		.andExpect(jsonPath("$.error").isEmpty())
	        		.andExpect(jsonPath("$.data").value("ok"));;
	}

}
