package leetcode201_300;
import java.util.HashMap;
import java.util.HashSet;

public class N205 {
    public boolean isIsomorphic(String s, String t) {
        if (s == null || t == null) return true;
        if (s.length() != t.length()) return false;
        if (s.length() <= 1) return true;
        HashMap<Character, Integer> map = new HashMap();
        HashSet<Character> set = new HashSet();
        char[] ss = s.toCharArray(), ts = t.toCharArray();
        for (int i = 0; i < ts.length; i++) {
			if (!map.containsKey(ss[i])) {
				if (!set.contains(ts[i])) {
					map.put(ss[i], ts[i] - ss[i]);
					set.add(ts[i]);
				}
				else return false;
			}
			else {
				if (ss[i] + map.get(ss[i]) != ts[i]) return false;
			}
		}
        return true;
    }
}
