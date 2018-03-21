package leetcode;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class N291 {
    public boolean wordPatternMatch(String pattern, String str) {
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();
        return DFSHelper(pattern, 0, str, 0, map, set);
    }

	private boolean DFSHelper(String pattern, int i, String str, int j, Map<Character, String> map, Set<String> set) {
		if (i == pattern.length() && j == str.length()) return true;
		if (i == pattern.length() || j == str.length()) return false;
		
		char c = pattern.charAt(i);
		if (map.containsKey(c)) {
			String tmp = map.get(c);
			if (!str.startsWith(tmp, j)) return false;
			return DFSHelper(pattern, i + 1, str, j + tmp.length(), map, set);
		}
		
		for (int k = j; k < str.length(); k++) {
			String word = str.substring(j, k + 1);
			if (set.contains(word)) continue;
			map.put(c, word);
			set.add(word);
			if (DFSHelper(pattern, i + 1, str, k + 1, map, set)) {
				return true;
			}
			map.remove(c);
			set.remove(word);
		}
		return false;
	}
}
