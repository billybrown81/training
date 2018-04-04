package google_on_site;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Presidency {
	Map<String, Integer> map;
	String curWinner;
	int count;
	List<Vote> criticalVotes;
	public Presidency() {
		map = new HashMap<>();
		count = 0;
		criticalVotes = new ArrayList<>();
	}
	
	public void build(List<Vote> list) {
		for (Vote vote : list) {
			map.put(vote.name, map.getOrDefault(vote.name, 0) + 1);
			if (map.get(vote.name) > count) {
				count = map.get(vote.name);
				curWinner = vote.name;
				criticalVotes.add(vote);
			}
		}
	}
	
	public String currentWinner(int time) {
		int start = 0, end = criticalVotes.size() - 1;
		while (start < end) {
			int mid = (start + end) / 2;
			int midTime = criticalVotes.get(mid).time;
			if (midTime <= time) {
				if (mid == end || criticalVotes.get(mid + 1).time > time) {
					return criticalVotes.get(mid).name;
				}
				start = mid + 1;
			} else {
				end = mid - 1;
			}
		}
		return criticalVotes.get(start).name;
		
	}
}
