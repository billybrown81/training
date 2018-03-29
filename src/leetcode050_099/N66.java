package leetcode050_099;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N66 {
    public int[] plusOne(int[] digits) {
        int extra = 1, i;
    		for (i = digits.length - 1; i >= 0; i--) {
    			if (extra == 0) {
				break;
			}
    			int sum = digits[i] + extra;
			digits[i] = sum % 10;
			extra = sum / 10;
		}
    		if (i == -1 && extra == 1) {
    			int[] res = new int[digits.length + 1];
    			res[0] = extra;
			System.arraycopy(digits, 0, res, 1, digits.length);
			return res;
		}
    		return digits;
    }
}
