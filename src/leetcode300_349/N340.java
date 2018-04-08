package leetcode300_349;
//340. Longest Substring with At Most K Distinct Characters
//Given a string, find the length of the longest substring T that contains at most k distinct characters.
//
//For example, Given s = “eceba” and k = 2,
//
//T is "ece" which its length is 3.

import java.util.HashMap;
import java.util.Map;

public class N340 {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int start = 0, end = 0;
        Map<Character, Integer> map = new HashMap<>();
        int count = 0, max = 0;
        while (end < s.length()) {
        		char cur = s.charAt(end);
			if (map.containsKey(cur)) {
				map.put(cur, map.get(cur) + 1);
				max = Math.max(max, end - start + 1);
			} else {
				map.put(cur, 1);
				count++;
				while (count > k) {
					char tmp = s.charAt(start);
					map.put(tmp, map.get(tmp) - 1);
					if (map.get(tmp) == 0) {
						map.remove(tmp);
						count--;
					}
					start++;
				}
				max = Math.max(max, end - start + 1);
			}
			end++;
		}
        return max;
    }
}
