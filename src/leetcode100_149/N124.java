package leetcode100_149;

import leetcode.TreeNode;

//124. Binary Tree Maximum Path Sum
//Given a binary tree, find the maximum path sum.
//
//For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.
//
//For example:
//Given the below binary tree,
//
//       1
//      / \
//     2   3
//Return 6.

public class N124 {
	int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        helper(root);
        return max;
    }
	private int helper(TreeNode root) {
		if (root == null) return 0;
		int l = Math.max(0, helper(root.left));
		int r = Math.max(0, helper(root.right));
		max = Math.max(max, l + r + root.val);
		return root.val + Math.max(l, r);
	}
}
