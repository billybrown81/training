package leetcode001_049;

public class N33 {
    public int search(int[] nums, int target) {
        int length = nums.length;
        if (length <= 0) {
			return -1;
		}
        int minId = findMinIndex(nums);
        if (target == nums[minId]) {
			return minId;
		}
        if (target < nums[minId] || minId > 0 && target > nums[minId - 1] || minId == 0 && target > nums[length - 1]) {
			return - 1;
		}
        int start = (target <= nums[length - 1])? minId : 0;
        int end = (target <= nums[length - 1])? length - 1 : minId;
        int mid;
        while (start <= end) {
        		mid = start + (end - start) / 2;
        		if (target == nums[mid]) {
					return mid;
				}
        		else if (target > nums[mid]) {
				start = mid + 1;
			}else {
				end = mid - 1;
			}
        }
        
        return -1;
    }

	private int findMinIndex(int[] nums) {
		int start = 0, end = nums.length - 1, mid;
		while (start < end) {
			mid = start + (end - start) / 2;
			if (nums[mid] > nums[end]) {
				start = mid + 1;
			}else {
				end = mid;
			}
		}
		return start;
	}
}
