package google_on_site;

import java.util.Arrays;

public class N568 {
    public int maxVacationDays(int[][] flights, int[][] days) {
        int cityNumber = flights.length;
        int weekNumber = days[0].length;
        int[] dp = new int[cityNumber];
        Arrays.fill(dp, Integer.MIN_VALUE);
        dp[0] = 0;
        
        for (int i = 0; i < weekNumber; i++) {
			int[] tmp = new int[cityNumber];
			Arrays.fill(tmp, Integer.MIN_VALUE);
			for (int j = 0; j < cityNumber; j++) {
				for (int k = 0; k < cityNumber; k++) {
					if (k == j || flights[k][j] == 1) {
						tmp[j] = Math.max(tmp[j], dp[k] + days[j][i]);
					}
				}
			}
			dp = tmp;
		}
        int max = 0;
        for (int i : dp) {
			max = Math.max(max, i);
		}
        return max;
    }
}
