package leetcode;
import java.util.HashMap;
import java.util.Map;

public class N76 {
    public String minWindow(String s, String t) {
         if (s == null || t == null || s.length() < t.length()) return "";
         Map<Character, Integer> map = new HashMap();
         for (char c : s.toCharArray()) {
			map.put(c, 0);
		 }
         for (char c : t.toCharArray()) {
			if (map.containsKey(c)) map.put(c, map.get(c) + 1);
			else return "";
		 }
         int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = t.length();
         while (end < s.length()) {
			char c = s.charAt(end);
			if (map.get(c) > 0) counter--;
			map.put(c, map.get(c) - 1);
			end++;
			while (counter == 0) {
				int len = end - start;
				if (len < minLen) {
					minLen = len;
					minStart = start;
				}
				char c1 = s.charAt(start);
				map.put(c1, map.get(c1) + 1);
				if (map.get(c1) > 0) {
					counter++;
				}
				start++;
			}	
		}
         return minLen == Integer.MAX_VALUE? "" : s.substring(minStart, minStart + minLen);
    }
    
    public String minWindow2(String s, String t) {
    		if (s == null || t == null || s.length() < t.length()) return "";
    		int[] map = new int[128];
    		for (char c : t.toCharArray()) map[c]++;
    		int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = t.length();
    		while (end < s.length()) {
    				char c = s.charAt(end);
				if (map[c] > 0) counter--;
				map[c]--;
				end++;
				while (counter == 0) {
					if (end - start < minLen) {
						minStart = start;
						minLen = end - start;
					}
					char c1 = s.charAt(start);
					map[c1]++;
					if (map[c1] > 0) counter++;
					start++;
				}
			}
    		return minLen == Integer.MAX_VALUE? "" : s.substring(minStart, minStart + minLen);
    }
}
