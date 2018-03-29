package leetcode250_299;
import java.util.Stack;

public class N255 {
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<>();
        int low = Integer.MIN_VALUE;
        for (int node : preorder) {
        		if (node < low) return false;
        		while (!stack.isEmpty() && node > stack.peek()) {
					low = stack.pop();
				}
			stack.push(node);
		}
        return true;
    }
}
