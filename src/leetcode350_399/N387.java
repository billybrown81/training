package leetcode350_399;

import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

//387. First Unique Character in a String
public class N387 {
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
			count[s.charAt(i) - 'a']++;
		}
        for (int i = 0; i < s.length(); i++) {
			if (count[s.charAt(i) - 'a'] == 1) {
				return i;
			}
		}
        return -1;
    }
    
    public int firstUniqChar2(String s) {
        LinkedHashMap<Character, Integer> map = new LinkedHashMap<>();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
        		char tmp = s.charAt(i);
			if (set.contains(tmp)) {
				map.remove(tmp);
			} else {
				set.add(tmp);
				map.put(tmp, i);
			}
		}
        return -1;
    }
}
