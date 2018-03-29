package leetcode001_049;
//42. Trapping Rain Water
//Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
//
//For example, 
//Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.

public class N42 {
    public int trap(int[] height) {
        int start = 0, end = height.length - 1;
        int left = 0, right = 0;
        int res = 0;
        while (start <= end) {
			left = Math.max(left, height[start]);
			right = Math.max(right, height[end]);
			if (left < right) {
				res += left - height[start];
				start++;
			} else {
				res += right - height[end];
				end--;
			}
		}
        return res;
    }
}
