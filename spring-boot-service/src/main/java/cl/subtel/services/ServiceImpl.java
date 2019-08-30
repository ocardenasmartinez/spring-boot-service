package cl.subtel.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ServiceImpl implements Service {

	@Override
	public List<Map<String, Object>> getList(String request) {
		List<Map<String, Object>> out = new ArrayList<>();
		Map<String, Object> map1 = new HashMap<>();
		map1.put("numero", 3);
		out.add(map1);
		return out;
	}

}
