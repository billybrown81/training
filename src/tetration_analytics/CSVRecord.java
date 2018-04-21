package tetration_analytics;

import java.util.Map;

public class CSVRecord {
	//Store values of the record
	private String[] values;
	//Mapping column titles with index number
	private Map<String, Integer> map;
	public CSVRecord(final String[] values, final Map<String, Integer> map) {
		this.values = values != null? values : new String[0];
		this.map = map;
	}
	public String get(int i) {
		return values[i];
	}
	public String get(String column_name) {
		if (map == null) {
            throw new IllegalStateException(
                "The record values can't be accessed by column name");
        }
        final Integer index = map.get(column_name);
        if (index == null) {
            throw new IllegalArgumentException(String.format("Column %s not found, expected one of %s", column_name, map.keySet()));
        }
        try {
            return values[index.intValue()];
        } catch (final ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException(String.format(
                "Index for column '%s' is %d, this record only has %d values.", column_name, index, size()));
        }
	}
	public int size() {
		return values.length;
	}
}
