package leetcode100_149;

import leetcode.TreeNode;

public class N112 {
    public boolean hasPathSum(TreeNode root, int sum) {
    		if (root == null) return false;
    		if (root.left == null && root.right == null) return sum == root.val;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
}
