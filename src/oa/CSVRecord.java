package oa;

import java.util.Map;

public class CSVRecord {
	private String[] values;
	private Map<String, Integer> map;
	public CSVRecord() {
		// TODO Auto-generated constructor stub
	}
	public String get(int i) {
		return values[i];
	}
	public String get(String column_name) {
		return "";
	}
	public int size() {
		return values.length;
	}
}
