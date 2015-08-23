package org.dbondin.xml2map;

import java.io.InputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class Xml2MapSAXImpl implements Xml2Map {

	private Set<String> rootTagSet;

	private SAXParser saxParser;

	private String tagSeparator;

	public void setTagSeparator(String tagSeparator) {
		this.tagSeparator = tagSeparator;
	}

	public String getTagSeparator() {
		return tagSeparator;
	}

	public Xml2MapSAXImpl(final String rootTag, final String... rootTags) {
		try {
			saxParser = SAXParserFactory.newInstance().newSAXParser();
		} catch (Throwable t) {
			/* Ignore it here. Will handle in parse() */
		}
		rootTagSet = new HashSet<String>();
		if (rootTag != null) {
			rootTagSet.add(rootTag);
		}
		if (rootTags != null) {
			rootTagSet.addAll(Arrays.asList(rootTags));
		}
	}

	@Override
	public Xml2MapData parse(InputStream xmlInputStream) throws Xml2MapException {

		if (saxParser == null) {
			throw new Xml2MapException("ERROR: SAX parser is not initialized");
		}

		try {
			Xml2MapDataImpl result = new Xml2MapDataImpl();
			saxParser.parse(xmlInputStream,
					new Xml2MapSAXImplDefaultHandler(result.getData(), rootTagSet, tagSeparator));
			return result;
		} catch (Throwable t) {
			throw new Xml2MapException(t);
		} finally {
			if (saxParser != null) {
				saxParser.reset();
			}
		}
	}
}
