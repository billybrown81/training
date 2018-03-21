package oa;
import java.util.Arrays;

public class lino {
    static int[] jobOffers(int[] scores, int[] lowerLimits, int[] upperLimits) {
    		int n = lowerLimits.length;
    		int m = scores.length;
    		int res[] = new int[n];
    		if (scores == null || scores.length == 0) return res;
    		Arrays.sort(scores);
    		for (int i = 0; i < n; i++) {
			int low = lowerLimits[i], high = upperLimits[i];
			if (scores[0] > high || scores[m - 1] < low) {
				res[i] = 0; continue;
			}
			int start = 0, end = m - 1;
			while (start < m && scores[start] < low) start++;
			while (end >= 0 && scores[end] > high) end--;
			res[i] = start > end? 0 : end - start + 1;
		}
    		return res;
    }
}
