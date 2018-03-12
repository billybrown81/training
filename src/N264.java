
public class N264 {
    public int nthUglyNumber(int n) {
        if (n <= 0) return 0;
        int dp[] = new int[n], t2 = 0, t3 = 0, t5 = 0;
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
			dp[i] = Math.min(Math.min(dp[t2] * 2, dp[t3] * 3), dp[t5] * 5);
			if (dp[i] == dp[t2] * 2) t2++;
			if (dp[i] == dp[t3] * 3) t3++;
			if (dp[i] == dp[t5] * 5) t5++;
		}
        return dp[n - 1];
    }
}
