package leetcode;

public class N250 {
	private int count = 0;
    public int countUnivalSubtrees(TreeNode root) {
        DFSHelper(root);
        return count;
    }
	private boolean DFSHelper(TreeNode root) {
		if (root == null) return true;
		boolean l = DFSHelper(root.left), r = DFSHelper(root.right);
		if (l && r) {
			if (root.left != null && root.left.val != root.val) return false;
			if (root.right != null && root.right.val != root.val) return false;
			count++;
			return true;
		}
		return false;
	}
}
