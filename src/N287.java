//287. Find the Duplicate Number
public class N287 {
    public int findDuplicate(int[] nums) {
    		int n = nums.length;
    		int fast = n, slow = n;
    		do {
				fast = nums[nums[fast - 1] - 1];
				slow = nums[slow - 1];
			} while (fast != slow);
    		slow = n;
    		while (slow != fast) {
				slow = nums[slow - 1];
				fast = nums[fast - 1];
			}
    		return fast;
    }
}
