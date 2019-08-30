package cl.subtel.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@RequestMapping("/")
	public List<Map<String, Object>> getList() {
		List<Map<String, Object>> out = new ArrayList<>();
		Map<String, Object> map1 = new HashMap<>();
		map1.put("numero", new Integer(1));
		out.add(map1);
		return out;
	}

}
