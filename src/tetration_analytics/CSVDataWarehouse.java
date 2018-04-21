package tetration_analytics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class CSVDataWarehouse {
	//CSV file path
	private String CSV_file_path;
	//Store the list of CSV records
	private List<CSVRecord> list;
	//Mapping column titles with index number
	private Map<String, Integer> map;
	//Store column titles
	private String[] columnTitles;
	
	private int get_size = 12;
	
	public CSVDataWarehouse(String url) {
		CSV_file_path = url;
	}
	
	public void init() throws IOException {
		try {
            File f = new File(CSV_file_path);
            BufferedReader br = new BufferedReader(new FileReader(f));
            String first = br.readLine();
            Map<String, Integer> map = new HashMap<>();
            columnTitles = first.split(",");
            for (int i = 0; i < columnTitles.length; i++) {
            		if (!map.containsKey(columnTitles[i])) {
					map.put(columnTitles[i], i);
				}
			}
            this.map = map;
            String line = null;
            while ((line = br.readLine()) != null) {
				CSVRecord record = new CSVRecord(line.split(","), map);
				list.add(record);
			}
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public List<CSVRecord> getCSVRecords() {
		if (list == null) {
			throw new IllegalArgumentException("No available CSVRecords");
		}
		return list;
	}
	
	public JSONArray getYoungestDozenFromAZipCode(String zipCode) throws JSONException {
		List<CSVRecord> csv_record_list = getYoungestDozenFromAZipCodeHelper(zipCode);
		//Transforming to JSON format
		JSONArray jArray = new JSONArray();
		for (CSVRecord record : csv_record_list) {
			JSONObject jsonObject = new JSONObject();
			for (int i = 0; i < csv_record_list.size(); i++) {
				jsonObject.append(columnTitles[i], record.get(i));
			}
			jArray.put(jsonObject);
		}
		return jArray;
	}
	
	//Get a list of CSV records according to zip code and age
	private List<CSVRecord> getYoungestDozenFromAZipCodeHelper(String zipCode) {
		if (list == null) {
			throw new IllegalArgumentException("No available CSVRecords");
		}
		int index_zip = map.get("zipCode");
		int index_age = map.get("age");
		//Max Heap
		PriorityQueue<CSVRecord> pq = new PriorityQueue<>((a, b) -> (Integer.parseInt(b.get(index_age)) - Integer.parseInt(a.get(index_age))));
		for (CSVRecord csvRecord : list) {
			if (csvRecord.get(index_zip).equals(zipCode)) {
				pq.offer(csvRecord);
			}
			//If size > 12, poll the CSV record with the largest age
			if (pq.size() > get_size) {
				pq.poll();
			}
		}
		List<CSVRecord> result = new LinkedList<>();
		while (!pq.isEmpty()) {
			result.add(0, pq.poll());
		}
		return result;
	}
	
	
}
