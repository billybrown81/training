package leetcode300_349;
//309. Best Time to Buy and Sell Stock with Cooldown

public class N309 {
    public int maxProfit(int[] prices) {
    		int sell = 0, prev_sell = 0, buy = Integer.MIN_VALUE, prev_buy;
    		for (int i : prices) {
				prev_buy = buy;
				buy = Math.max(prev_sell - i, prev_buy);
				prev_sell = sell;
				sell = Math.max(prev_buy + i, prev_sell);
			}
    		return sell;
    }
}
