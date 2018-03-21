package leetcode;

public class NumArray {
	int[] nums;
	int[] BIT;
	int n;
	
    public NumArray(int[] nums) {
        this.nums = nums;
        n = nums.length;
        BIT = new int[n + 1];
        for (int i = 0; i < n; i++) {
			updateBIT(i, nums[i]);
		}
    }
    
    private void updateBIT(int i, int diff) {
    		i++;
        while (i <= n) {
			BIT[i] += diff;
			i += i & -i;
		}	
	}

	public void update(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;
        updateBIT(i, diff);
    }
    
    public int sumRange(int i, int j) {
        return getSum(j) - getSum(i - 1);
    }

	private int getSum(int i) {
		int sum = 0;
		i++;
		while (i > 0) {
			sum += BIT[i];
			i -= i & -i;
		}
		return sum;
	}
}
