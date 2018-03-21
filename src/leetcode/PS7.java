package leetcode;

public class PS7 {
	public static int countPalindrome(String s) {
		int count = 0, len = s.length();
		if (s == null || len == 0) return count;
		int start = 0, end = 0;
		for (int i = 0; i < len; i++) {
			start = end = i;
			do {
				count++;
				start--; end++;
			} while (start >= 0 && end < len && s.charAt(start) == s.charAt(end));
			if (i < len - 1) {
				start = i; end = i + 1;
				while (start >= 0 && end < len && s.charAt(start) == s.charAt(end)) {
					count++;
					start--; end++;
				}
			}
		}
		return count;
	}
    static int count_palindromes(String S) {
    		int count = 0 ,len = S.length();
    		if (S == null || len == 0) return 0;
    		int start, end;
    		for (int i = 0; i < len; i++) {
			start = end = i;
			//Count single digit and find odd-number-length palindromes
			do {
				count++;
				start--; end++;
			} while (start >= 0 && end < len && S.charAt(start) == S.charAt(end));
			start = i; end = i + 1;
			//Count even-number-length palindromes
			while (start >= 0 && end < len && S.charAt(start) == S.charAt(end)) {
				count++;
				start--;end++;
			}
		}
    		return count;
    }
}
