package org.dbondin.xml2map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import junit.framework.TestCase;

public class Test3 extends TestCase {

	@Test
	public void test3() throws Exception {

		String rootTag = "fm.AlarmInfo";

		Xml2Map x2m = new Xml2MapSAXImpl(rootTag);

		Xml2MapData x2md = x2m.parse(Test3.class.getResourceAsStream("getAlarms.driver.xml"));

		List<Map<String, String>> l = x2md.getAll(rootTag);

		for (int i = 0; i < l.size(); i++) {
			Map<String, String> m = l.get(i);
			if (m != null) {
				System.out.println("--- " + i + " ------------------------------------------------");
				List<String> keyList = new ArrayList<String>(m.keySet());
				Collections.sort(keyList);
				for (String tag : keyList) {
					System.out.println(tag);
					System.out.println("  '" + m.get(tag) + "'");
				}
			}
		}

	}
}
