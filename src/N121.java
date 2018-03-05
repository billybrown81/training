
public class N121 {
    public int maxProfit(int[] prices) {
        int cur = 0, max = 0;
        for (int i = 1; i < prices.length; i++) {
			cur = Math.max(0, cur += prices[i] - prices[i - 1]);
			max = Math.max(max, cur);
		}
        return max;
    }
}
