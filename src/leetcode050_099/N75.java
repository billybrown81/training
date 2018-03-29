package leetcode050_099;

public class N75 {
	  	public void sortColors(int[] nums) {
	        int start = 0 , end = nums.length - 1;
	  		for (int i = 0; i <= end; i++) {
				if (nums[i] == 0 && i != start) {
					swap(nums, start++, i--);
				}
				if (nums[i] == 2 && i != end) {
					swap(nums, end--, i--);
				}
			}
	    }
	  	
		private void swap(int[] nums, int index, int i) {
			int temp = nums[index];
			nums[index] = nums[i];
			nums[i] = temp;
		}
}
