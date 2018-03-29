package leetcode150_199;

import leetcode.TreeNode;

public class N156 {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null) return root;
        return DFSHelper(root);
    }

	private TreeNode DFSHelper(TreeNode root) {
		if (root.left == null) return root;
		TreeNode newRoot = DFSHelper(root.left);
		root.left.left = root.right;
		root.left.right = root;
		root.left = null;
		root.right = null;
		return newRoot;
	}
	
    public TreeNode upsideDownBinaryTree2(TreeNode root) {
        if (root == null) return root;
        TreeNode cur = root, pre = null, tmp = null, next = null;
        while (cur != null) {
			next = cur.left;
			cur.left = tmp;
			tmp = cur.right;
			cur.right = pre;
			pre = cur;
			cur = next;
		}
        return pre;
    }
}
