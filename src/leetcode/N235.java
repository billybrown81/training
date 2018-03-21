package leetcode;

public class N235 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p == null || q == null) return null;
        while ((root.val - p.val) * (root.val - q.val) > 0) 
        		root = root.val < p.val? root.right : root.left;
        return root;
    }
}
