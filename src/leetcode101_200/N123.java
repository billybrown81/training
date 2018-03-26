package leetcode101_200;

public class N123 {
    public int maxProfit(int[] prices) {
        int first_release = 0, second_release = 0;
        int first_buy = Integer.MIN_VALUE, second_buy = Integer.MIN_VALUE;
        for (int i : prices) {
			second_release = Math.max(second_release, second_buy + i);
			second_buy = Math.max(second_buy, first_release - i);
			first_release = Math.max(first_release, first_buy + i);
			first_buy = Math.max(first_buy, -i);
		}
        return second_release;
    }
}
