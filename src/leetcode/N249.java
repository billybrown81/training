package leetcode;
import java.util.ArrayList;
import java.util.List;

public class N249 {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>> res = new ArrayList<>();
        if (strings.length == 0) return res;
        boolean isFound = false;
        for (String s : strings) {
        		for (List<String> list : res) {
				String tmp = list.get(0);
				if (isShift(s, tmp)) {
					list.add(s);
					isFound = true;
					break;
				}
			}
        		if (!isFound) {
					List<String> list = new ArrayList<>();
					list.add(s);
					res.add(list);
				}
        		isFound = false;
		}
        return res;
    }

	private boolean isShift(String s, String tmp) {
		if (s.length() == tmp.length()) {
			for (int i = 1; i < s.length(); i++) {
				if ((s.charAt(i) - s.charAt(i - 1) + 26) % 26 != (tmp.charAt(i) - tmp.charAt(i - 1) + 26) % 26) return false;
			}
			return true;
		}
		return false;
	}
}
