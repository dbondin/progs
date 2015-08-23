package org.dbondin.xml2map;

import java.util.List;
import java.util.Map;

public interface Xml2MapData {

	Map<String, String> getOne(String rootTag);
	
	List<Map<String, String>> getAll(String rootTag);
	
}
