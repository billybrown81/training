package leetcode201_300;
//298. Binary Tree Longest Consecutive Sequence

import leetcode.TreeNode;

public class N298 {
	private int max = 0;
    public int longestConsecutive(TreeNode root) {
    	if (root == null) return max;
        helper(root, 0, root.val);
        return max;
    }
	private void helper(TreeNode root, int i, int target) {
		if (root == null) return;
		if (root.val == target) {
			i++;
		} else {
			i = 1;
		}
		max = Math.max(max, i);
		helper(root.left, i, root.val + 1);
		helper(root.right, i, root.val + 1);
	}
}
