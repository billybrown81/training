package leetcode200_249;

import java.util.ArrayDeque;
import java.util.Deque;

public class N239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0 || nums.length < k) return new int[0];
        int n = nums.length;
        int[] res = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
			while (!deque.isEmpty() && deque.peek() < i - k + 1) {
				deque.poll();
			}
			while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
				deque.pollLast();
			}
			deque.offer(i);
			if (i >= k - 1) {
				res[i - k + 1] = nums[deque.peek()];
			}
		}
        return res;
    }
}
