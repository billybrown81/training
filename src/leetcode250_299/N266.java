package leetcode250_299;
import java.util.HashSet;
import java.util.Set;

public class N266 {
    public boolean canPermutePalindrome(String s) {
        if (s.length() <= 1) return true;
        Set<Character> set = new HashSet<>();
        for (char c : s.toCharArray()) {
			if (set.contains(c)) {
				set.remove(c);
			} else {
				set.add(c);
			}
		}
        return set.size() <= 1;
    }
}
