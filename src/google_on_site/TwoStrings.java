package google_on_site;

import java.util.LinkedList;
import java.util.List;

public class TwoStrings {
	public List<String> generate(String s1, String s2) {
		List<String> res = new LinkedList<>();
		res.add("");
		for (int i = 0; i < s1.length(); i++) {
			int size = res.size();
			for (int j = 0; j < size; j++) {
				String tmp = res.get(0);
				res.remove(0);
				for (int k = s1.charAt(i) - 'a'; k <= s2.charAt(i) - 'a'; k++) {
					res.add(tmp + String.valueOf((char)('a' + k)));
				}
			}
		}
		return res;
	}
}
