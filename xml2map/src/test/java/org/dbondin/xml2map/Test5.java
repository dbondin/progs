package org.dbondin.xml2map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import junit.framework.TestCase;

public class Test5 extends TestCase {

	@Test
	public void test2() throws Exception {

		String rootTag = "root";

		Xml2Map x2m = new Xml2MapSAXImpl(rootTag);

		Xml2MapData x2md = x2m.parse(Test5.class.getResourceAsStream("amp.xml"));

		Map<String, String> m = x2md.getOne(rootTag);

		if (m != null) {
			List<String> keyList = new ArrayList<String>(m.keySet());
			Collections.sort(keyList);
			for (String tag : keyList) {
				System.out.println(tag);
				System.out.println("  '" + m.get(tag) + "'");
			}
		}

	}
}
