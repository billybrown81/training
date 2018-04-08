package leetcode300_349;
//486. Predict the Winner
//Given an array of scores that are non-negative integers. Player 1 picks one of the numbers from either end of the array followed by the player 2 and then player 1 and so on. Each time a player picks a number, that number will not be available for the next player. This continues until all the scores have been chosen. The player with the maximum score wins.
//
//Given an array of scores, predict whether player 1 is the winner. You can assume each player plays to maximize his score.


public class N486 {
    public boolean PredictTheWinner(int[] nums) {
    		if (nums == null) return true;
    		int n = nums.length;
    		int dp[] = new int[n];
    		for (int i = n - 1; i >= 0; i--) {
			for (int j = i; j < n; j++) {
				if (i == j) dp[i] = nums[i];
				else dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
			}
		}
    		return dp[n - 1] >= 0;
    }
}
