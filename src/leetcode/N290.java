package leetcode;
import java.util.HashMap;
import java.util.Map;

public class N290 {
    public static boolean wordPattern(String pattern, String str) {
        if (pattern == null || str == null) return false;
        String s[] = str.split(" ");
        if (pattern.length() != s.length) return false;
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < pattern.length(); i++) {
			char cur = pattern.charAt(i);
			if (!map.containsKey(cur) && !map.containsValue(s[i])) {
				map.put(cur, s[i]);
			} else if (map.containsKey(cur)) {
				if (!map.get(cur).equals(s[i])) return false;
			} else {
				return false;
			}
		}
        return true;
    }
}
