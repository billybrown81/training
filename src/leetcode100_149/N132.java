package leetcode100_149;

public class N132 {
    public int minCut(String s) {
    		if (s == null || s.length() == 0) return 0;
        return DFSHelper(s, 0);
    }

	private int DFSHelper(String s, int index) {
		if (index == s.length()) return -1;
		int minCut = s.length() - 1 - index;
		for (int i = index; i < s.length(); i++) {
			if (isPalindrome(s, index, i)) {
				minCut = Math.min(minCut, DFSHelper(s, i + 1) + 1);
			}
		}
		return minCut;
	}
	
	private boolean isPalindrome(String s, int start, int end) {
		if (start == end) return true;
		while (start < end) {
			if (s.charAt(start) != s.charAt(end)) return false;
			start++; end--;
		}
		return true;
	}
	
    public int minCut2(String s) {
		char[] ch = s.toCharArray();
		int len = ch.length;
		int[] cut = new int[len];
		boolean[][] pal = new boolean[len][len];
		for (int i = 0; i < len; i++) {
			int minCut = i;
			for (int j = 0; j <= i; j++) {
				if (ch[j] == ch[i] && (j + 1 > i - 1 || pal[j + 1][i - 1])) {
					pal[j][i] = true;
					minCut = j == 0 ? 0 : Math.min(minCut, cut[j - 1] + 1);
				}
			}
			cut[i] = minCut;
		}
		return cut[len - 1];
    }
}
