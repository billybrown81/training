
public class N101 {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        return isSymmetricHelper(root.left, root.right);
    }

	private boolean isSymmetricHelper(TreeNode left, TreeNode right) {
		if (left == null || right == null) return left == right;
		if (left.val == right.val) return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
		return false;
	}
}
