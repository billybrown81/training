package leetcode150_199;
import java.util.HashMap;
import java.util.Map;

public class N159 {
    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s == null) return 0;
        int start = 0, end = 0, max = -1, counter = 2;
        Map<Character, Integer> map = new HashMap<>();
        while (end < s.length()) {
			char cur = s.charAt(end);
			if (map.containsKey(cur))
				map.put(cur, map.get(cur) + 1);
			else {
				map.put(cur, 1);
				counter--;
			}
			end++;
			if (counter >= 0 && max < end - start)
				max = end - start;
			while (counter < 0) {
				char tmp = s.charAt(start);
				map.put(tmp, map.get(tmp) - 1);
				if (map.get(tmp) == 0) {
					map.remove(tmp);
					counter++;
				}
				start++;
			}
		}
        return max == -1? 0 : max;
    }
}
