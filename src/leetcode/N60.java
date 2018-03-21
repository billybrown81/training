package leetcode;
import java.util.ArrayList;
import java.util.List;

public class N60 {
    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
			factorial[i] = factorial[i - 1] * (i + 1);
		}
        List<Integer> number = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
			number.add(i);
		}
        
        for (int i = 0; i < n; i++) {
        		int index;
        		if (n - i - 2 < 0) {
					index = 0;
				} else {
					index = (k - 1) / factorial[n - i - 2];
				}
			
			sb.append(number.get(index));
			number.remove(index);
			if (n - i - 2 >= 0) {
				k -= index * factorial[n - i - 2];
			}

		}
        
        return sb.toString();
    }
}
