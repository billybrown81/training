package leetcode101_200;

import leetcode.TreeNode;

public class N108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return Helper(nums, 0, nums.length - 1);
    }

	private TreeNode Helper(int[] nums, int i, int j) {
		if (i > j) return null;
		int mid = i + (j - i) / 2;
		TreeNode root = new TreeNode(nums[mid]);
		root.left = Helper(nums, i, mid - 1);
		root.right = Helper(nums, mid + 1, j);
		return root;
	}
}
