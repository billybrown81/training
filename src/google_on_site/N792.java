package google_on_site;
//792. Number of Matching Subsequences

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class N792 {
    public int numMatchingSubseq(String S, String[] words) {
        Map<Character, Queue<String>> map = new HashMap<>();
        for (String w : words) {
			if (!map.containsKey(w.charAt(0))) {
				map.put(w.charAt(0), new LinkedList<>());
			}
			map.get(w.charAt(0)).add(w);
		}
        int count = 0;
        for (char c : S.toCharArray()) {
        		if (!map.containsKey(c)) continue;
			Queue<String> queue = map.get(c);
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				String cur = queue.poll();
				if (cur.length() == 1) {
					count++;
				}
				else {
					if (!map.containsKey(cur.charAt(1))) {
						map.put(cur.charAt(1), new LinkedList<>());
					}
					map.get(cur.charAt(1)).add(cur.substring(1));
				}
			}
		}
        return count;
    }
    
    Map<String, Boolean> cache = new HashMap<>();
    public int numMatchingSubseq2(String S, String[] words) {
    		int count = 0;
    		for (String word : words) {
			if (isSubseq(S, word)) {
				count++;
			}
		}
    		return count;
    }

	private boolean isSubseq(String s, String word) {
		if (cache.containsKey(word)) {
			return cache.get(word);
		}
		int i = 0, j = 0;
		while (i < s.length() && j < word.length()) {
			if (s.charAt(i) == word.charAt(j)) {
				j++;
			} 
			i++;
		}
		if (j == word.length()) {
			cache.put(word, true);
			return true;
		} else {
			cache.put(word, false);
			return false;
		}
	}
}
