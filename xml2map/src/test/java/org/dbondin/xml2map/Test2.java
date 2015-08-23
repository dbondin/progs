package org.dbondin.xml2map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import junit.framework.TestCase;

public class Test2 extends TestCase {

	@Test
	public void test2() throws Exception {

		String rootTag1 = "header";
		String rootTag2 = "fm.AlarmInfo";

		Xml2Map x2m = new Xml2MapSAXImpl(rootTag1, rootTag2);

		Xml2MapData x2md = x2m.parse(Test2.class.getResourceAsStream("jms-00007.xml"));

		Map<String, String> m = x2md.getOne(rootTag1);

		if (m != null) {
			List<String> keyList = new ArrayList<String>(m.keySet());
			Collections.sort(keyList);
			for (String tag : keyList) {
				System.out.println(tag);
				System.out.println("  '" + m.get(tag) + "'");
			}
		}

		m = x2md.getOne(rootTag2);

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
