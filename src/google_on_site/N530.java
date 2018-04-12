package google_on_site;

import leetcode.TreeNode;

//530. Minimum Absolute Difference in BST

public class N530 {
	int prev, min;
    public int getMinimumDifference(TreeNode root) {
    		min = Integer.MAX_VALUE;
    		prev = -1;
    		indorderTraverse(root);
    		return min;
    }
	private void indorderTraverse(TreeNode root) {
		if (root == null) return;
		indorderTraverse(root.left);
		if (prev != -1) min = Math.min(min, root.val - prev);
		prev = root.val;
		indorderTraverse(root.right);
	}
}
