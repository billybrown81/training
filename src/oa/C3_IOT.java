package oa;

import java.util.ArrayList;
import java.util.List;

public class C3_IOT {
	public List<String> permutations(String s) {
		List<String> res = new ArrayList<>();
		int n = s.length();
		Helper(res, s, 0, n - 1);
		return res;
	}

	private void Helper(List<String> res, String s, int l, int r) {
		if (l == r) {
			res.add(s);
		} else {
			for (int i = l; i <= r; i++) {
				s = swap(s, l, i);
				Helper(res, s, l + 1, r);
				s = swap(s, l, i);
			}
		}
	}

	private String swap(String s, int l, int i) {
		char[] ch = s.toCharArray();
		char tmp = ch[l];
		ch[l] = ch[i];
		ch[i] = tmp;
		return String.valueOf(ch);
	}
	
	public int findMinInsertionPalindrome(String s) {
		int n = s.length();
		int[][] dp = new int[n][n];
		for (int l = 1; l < n; l++) {
			for (int i = 0; i + l < n; i++) {
				int j = i + l;
				dp[i][j] = s.charAt(i) == s.charAt(j) ? dp[i + 1][j - 1] : Math.min(dp[i][j - 1], dp[i + 1][j] + 1);
			}
		}
		return dp[0][n - 1];
	}
}
