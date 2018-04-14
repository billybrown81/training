package leetcode001_049;
//10. Regular Expression Matching

public class N10 {
    public boolean isMatch(String s, String p) {
        int m = s.length(), n = p.length();
        char[] sc = s.toCharArray(), pc = p.toCharArray();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 2; i <= n; i++) {
			if (pc[i - 1] == '*') dp[0][i] = dp[0][i - 2];
		}
        for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (sc[i - 1] == pc[i - 1] || pc[i - 1] == '.') 
					dp[i][j] = dp[i - 1][j - 1];
				else if (pc[j - 1] == '*') {
					if (pc[j - 2] == '.' || pc[j - 2] == sc[i - 1]) {
						dp[i][j] = dp[i][j - 1] || dp[i][j - 2] || dp[i - 1][j];
					} else {
						dp[i][j] = dp[i][j - 2];
					}
				} else {
					dp[i][j] = false;
				}
			}
		}
        return dp[m][n];
    }
}
