package leetcode150_199;
//188. Best Time to Buy and Sell Stock IV
public class N188 {
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        if (k >= n / 2) {
			int max = 0, cur = 0;
			for (int i = 1; i < n; i++) {
				cur = Math.max(0, prices[i] - prices[i - 1]);
				max += cur;
			}
			return max;
		}
        int dp[][] = new int[k + 1][n];
        for (int i = 1; i <= k; i++) {
			int tmpmax = -prices[0];
			for (int j = 1; j < n; j++) {
				dp[i][j] = Math.max(dp[i][j - 1], tmpmax + prices[j]);
				tmpmax = Math.max(tmpmax, dp[i - 1][j - 1] - prices[j]);
			}
		}
        return dp[k][n - 1];
    }
}
