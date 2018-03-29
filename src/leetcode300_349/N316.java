package leetcode300_349;
//316. Remove Duplicate Letters

public class N316 {
    public String removeDuplicateLetters(String s) {
        int[] count = new int[26];
        int pos = 0;
        for (int i = 0; i < s.length(); i++) {
			count[s.charAt(i) - 'a']++;
		}
        for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) < s.charAt(pos)) pos = i;
			if (--count[s.charAt(i) - 'a'] == 0) break;
		}
        return s.length() == 0? "" : s.charAt(pos) + removeDuplicateLetters(s.substring(pos + 1).replace(s.charAt(pos) + "", ""));
    }
}
