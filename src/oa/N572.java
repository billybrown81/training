package oa;

import leetcode.TreeNode;

//572. Subtree of Another Tree
public class N572 {
    public boolean isSubtree(TreeNode s, TreeNode t) {
    		if (s == null) return false;
    		if (isSameTree(s, t)) return true;
    		return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

	private boolean isSameTree(TreeNode s, TreeNode t) {
		if (s == null && t == null) return true;
		if (s == null || t == null || s.val != t.val) return false;
		return isSameTree(s.left, t.left) && isSameTree(s.right, t.right);
	}
}
