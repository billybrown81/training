package leetcode;
import java.time.format.ResolverStyle;

public class N31 {
    public void nextPermutation(int[] nums) {
    	int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i+1]) {
			i--;
		}
        if (i >= 0) {
			int j = nums.length - 1;
			while (j > i && nums[i] >= nums[j]) {
				j--;
			}
			swap(nums, i, j);
		}
        reverse(nums, i);
    }

	private void reverse(int[] nums, int i) {
		int start = i + 1, end = nums.length - 1;
		while (start < end) {
			swap(nums, start, end);
			start++;
			end--;
		}
		
	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;		
	}
}
