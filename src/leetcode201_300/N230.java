package leetcode201_300;

import leetcode.TreeNode;

public class N230 {
	int count = 0, result = 0;
    public int kthSmallest(TreeNode root, int k) {
    		count = k;
        DFSHelper(root);
        return result;
    }

	private void DFSHelper(TreeNode root) {
		if (root.left != null) DFSHelper(root.left);
		if (--count == 0) {
			result = root.val;
			return;
		}
		if (root.right != null) DFSHelper(root.right);
	}
}
