package org.dbondin.xml2map;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Xml2MapDataImpl implements Xml2MapData {

	private Map<String, List<Map<String, String>>> data = new HashMap<String, List<Map<String, String>>>();

	public Map<String, List<Map<String, String>>> getData() {
		return data;
	}

	@Override
	public Map<String, String> getOne(String rootTag) {
		List<Map<String, String>> list = data.get(rootTag);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public List<Map<String, String>> getAll(String rootTag) {
		return data.get(rootTag);
	}

	public String toString() {
		return "[" + Xml2MapDataImpl.class.getSimpleName() + "/" + data.keySet().size() + "]";
	};
}
