package oa;
import java.util.Arrays;
import java.util.Stack;

public class Affirm {	
    static String[] prefixToPostfix(String[] prefixes) {
    		int n = prefixes.length;
    		String res[] = new String[n];
    		for (int i = 0; i < n; i++) {
    			res[i] = transfer(prefixes[i]);
			}
    		return res;
    }
    
    private static String transfer(String prefix) {
		if (prefix.length() == 0) return "";
		Stack<String> stack = new Stack<String>();
		for (int i = prefix.length() - 1; i >= 0; i--) {
			char cur = prefix.charAt(i);
			if (isOperator(cur)) {
				String op1 = stack.pop(), op2 = stack.pop();
				stack.push(op1 + op2 + cur);
			} else stack.push(cur + "");
		}
		return stack.pop();
	}
    
	public static String prefixToPostfix(String pre_exp) {
		if (pre_exp == null || pre_exp.length() == 0) return "";
		Stack<String> stack = new Stack<String>();
		for (int i = pre_exp.length() - 1; i >= 0; i--) {
			char cur = pre_exp.charAt(i);
			if(isOperator(cur)) {
				String op1 = stack.pop(), op2 = stack.pop();
				stack.push(op1 + op2 + cur);
			} else {
				stack.push(cur + "");
			}
		}
		return stack.pop();
	}

	private static boolean isOperator(char c) {
		switch (c) {
			case '+': case '-': case '*': case '/': return true;
		}
		return false;
	}
	
    static long countInversions(int[] nums) {
    		if (nums == null || nums.length < 3) return 0;
    		long res = 0;
    		convert(nums);
    		int n = nums.length, left[] = new int[n], right[] = new int[n], BIT[] = new int[n + 1];
    		for (int i = n - 1; i >= 0; i--) {
                left[i] = count(BIT, nums[i] - 1);
                update(BIT, n, nums[i], 1);
           }
    		BIT = new int[n + 1];
    		for (int i = 0; i < n; i++) {
                right[i] = i - count(BIT, nums[i]);
                update(BIT, n, nums[i], 1);
            }
    		for (int i = 0; i < n; i++) {
				res += left[i] * right[i];
			}
    		return res;
    }

	private static void update(int[] bIT, int n, int i, int num) {
		while (i <= n) {
            bIT[i] += num;
            i += i & (-i);
        }
	}

	private static int count(int[] bIT, int i) {
		int res = 0;
        while (i > 0) {
            res += bIT[i];
            i -= i & (-i);
        }
        return res;
	}

	private static void convert(int[] nums) {
		int n = nums.length;
		int tmp[] = new int[n];
		for (int i = 0; i < n; i++) tmp[i] = nums[i];
		Arrays.sort(tmp);
		for (int i = 0; i < n; i++) nums[i] = Arrays.binarySearch(tmp, nums[i]) + 1;
	}
}
