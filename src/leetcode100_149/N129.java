package leetcode100_149;

import leetcode.TreeNode;

public class N129 {
    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;
        return DFSHelper(root, 0);
    }

	private int DFSHelper(TreeNode root, int cur) {
		if (root == null) return 0;
		cur = cur * 10 + root.val;
		if (root.left == null && root.right == null) {
			return cur;
		}
		return DFSHelper(root.left, cur) + DFSHelper(root.right, cur);
	}
}
