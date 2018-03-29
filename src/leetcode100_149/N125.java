package leetcode100_149;

public class N125 {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        int start = findNext(s, 0), end = findNext2(s, s.length() - 1);
        if (start == -1) return true;
        while (start < end) {
        		if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) return false;
			start = findNext(s, start + 1);
			end = findNext2(s, end - 1);
		}
        return true;
    }

	private int findNext2(String s, int end) {
		for (int i = end; i >= 0; i--) {
			if (Character.isLetterOrDigit(s.charAt(i))) return i;
		}
		return -1;
	}

	private int findNext(String s, int start) {
		for (int i = start; i < s.length(); i++) {
			if (Character.isLetterOrDigit(s.charAt(i))) return i;
		}
		return -1;
	}
}
