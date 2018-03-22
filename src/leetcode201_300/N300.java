package leetcode201_300;
//300. Longest Increasing Subsequence

public class N300 {
    public int lengthOfLIS(int[] nums) {
    		int[] tails = new int[nums.length];
    		int size = 0;
    		for (int x : nums) {
			int start = 0, end = size;
			while (start != end) {
				int mid = (end + start) / 2;
				if (tails[mid] < x) {
					start = mid + 1;
				} else {
					end = mid;
				}
			}
			tails[start] = x;
			if (start == size) size++;
		}
    		return size;
    }
}
