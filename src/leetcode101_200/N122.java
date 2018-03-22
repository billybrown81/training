package leetcode101_200;

public class N122 {
    public int maxProfit(int[] prices) {
        int cur = 0, max = 0;
        for (int i = 1; i < prices.length; i++) {
			cur = Math.max(0, prices[i] - prices[i - 1]);
			max += cur;
		}
        return max;
    }
}
