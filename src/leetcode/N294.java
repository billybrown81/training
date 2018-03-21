package leetcode;
import java.util.HashMap;
import java.util.Map;

public class N294 {
    public boolean canWin(String s) {
        Map<String, Boolean> map = new HashMap<>();
        return Helper(s, map);
    }

	private boolean Helper(String s, Map<String, Boolean> map) {
		if (map.containsKey(s)) {
			return map.get(s);
		}
		for (int i = 0; i < s.length() - 1; i++) {
			if (s.startsWith("++", i)) {
				String t = s.substring(0, i) + "--" + s.substring(i + 2); 
				if (!Helper(t, map)) {
					map.put(s, true);
					return true;
				}
			}
		}
		map.put(s, false);
		return false;
	}
}
