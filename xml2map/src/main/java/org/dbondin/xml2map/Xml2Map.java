package org.dbondin.xml2map;

import java.io.InputStream;

public interface Xml2Map {
	
	Xml2MapData parse(InputStream xmlInputStream) throws Xml2MapException;
	
}
