package leetcode;

public class N34 {
    public int[] searchRange(int[] nums, int target) {
        int start = 0, end = nums.length - 1, mid = 0;
        int ans[] = {-1, -1};
        boolean hasTarget = false;
        while (start <= end) {
			mid = start + (end - start) / 2;
			if (target == nums[mid]) {
				hasTarget = true;
				break;
			}
			else if (target > nums[mid]) {
				start = mid + 1;
			}
			else {
				end = mid - 1;
			}
		}
        if (hasTarget) {
        	start = mid;
            end = mid;
            while (start >= 0 && target == nums[start]) {
    			ans[0] = start;
    			start--;
    		}
            while (end <= nums.length - 1 && target == nums[end]) {
    			ans[1] = end;
    			end++;
    		}
		}
        return ans;
    }
}
