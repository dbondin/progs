package org.dbondin.xml2map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class Xml2MapSAXImplDefaultHandler extends DefaultHandler {

	private static enum LAST_OP {
		START, END;
	}

	private static final class STATE {

		public String currentRootTag;

		public int currentRootTagIndex;

		public StringBuilder lastValue = new StringBuilder();

		public Map<String, String> currentData;

		public LAST_OP lastOp;

		public STATE() {
			reset();
		}

		public void reset() {
			this.currentData = null;
			this.currentRootTag = null;
			this.currentRootTagIndex = -1;
			this.lastOp = null;
			this.lastValue.setLength(0);;
		}
	}

	public static final String DEFAULT_TAG_SEPARATOR = "/";

	public static final Set<String> DEFAULT_ROOT_TAG_SET = Collections.emptySet();

	private static String getTagListAsString(LinkedList<String> tagList, int beginIndex, int endIndex,
			String tagSeparator) {

		StringBuilder sb = new StringBuilder();

		int index = 0;
		for (String str : tagList) {
			if (index < beginIndex) {
				index++;
				continue;
			}
			if (index >= endIndex) {
				break;
			}

			if (index != beginIndex) {
				sb.append(tagSeparator);
			}
			sb.append(str);
			index++;
		}

		return sb.toString();
	}

	private LinkedList<String> currentTagList = new LinkedList<String>();

	private STATE state = new STATE();

	private Map<String, List<Map<String, String>>> data;

	private Set<String> rootTagSet;

	private String tagSeparator;

	public Xml2MapSAXImplDefaultHandler(Map<String, List<Map<String, String>>> data, Set<String> rootTagSet) {
		this(data, rootTagSet, DEFAULT_TAG_SEPARATOR);
	};

	public Xml2MapSAXImplDefaultHandler(Map<String, List<Map<String, String>>> data, Set<String> rootTagSet,
			String tagSeparator) {

		this.data = data;

		this.rootTagSet = rootTagSet;
		if (this.rootTagSet == null) {
			this.rootTagSet = DEFAULT_ROOT_TAG_SET;
		}

		this.tagSeparator = tagSeparator;
		if (this.tagSeparator == null) {
			this.tagSeparator = DEFAULT_TAG_SEPARATOR;
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		state.lastValue.append(ch, start, length);
	};

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {

		if (qName != null) {

			if (state.currentRootTag != null) {
				if (qName.equals(state.currentRootTag)) {
					if (state.currentRootTagIndex == (currentTagList.size() - 1)) {
						state.reset();
					}
				} else {
					if (state.lastOp == LAST_OP.START) {
						state.currentData.put(getCurrentTagListAsString(), state.lastValue.toString().trim());
					}
				}
			}

			state.lastOp = LAST_OP.END;
			currentTagList.removeLast();
			state.lastValue.setLength(0);

		}
	};

	private String getCurrentTagListAsString() {
		return getTagListAsString(currentTagList, state.currentRootTagIndex + 1, currentTagList.size(), tagSeparator);
	};

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {

		if (qName != null) {

			currentTagList.addLast(qName);

			if (state.currentRootTag == null) {
				if (rootTagSet.contains(qName)) {
					state.currentRootTag = qName;
					state.currentRootTagIndex = currentTagList.size() - 1;
					state.currentData = new HashMap<String, String>();
					List<Map<String, String>> list = this.data.get(qName);
					if (list == null) {
						list = new ArrayList<Map<String, String>>();
						this.data.put(qName, list);
					}
					list.add(state.currentData);
				}
			}

			state.lastOp = LAST_OP.START;
		}
	}
}