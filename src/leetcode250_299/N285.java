package leetcode250_299;
//285. Inorder Successor in BST

import leetcode.TreeNode;

public class N285 {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) return null;
        if (root.val <= p.val) {
			return inorderSuccessor(root.right, p);
		} else {
			TreeNode left = inorderSuccessor(root.left, p);
			return left == null? root : left;
		}
    }
}
