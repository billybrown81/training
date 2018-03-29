package leetcode100_149;

import leetcode.TreeNode;

public class N100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
    		if (p == null && q == null) return true;
    		if (p != null && q != null && p.val == q.val) return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    		return false;
    }
}
