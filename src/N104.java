
public class N104 {
    public int maxDepth(TreeNode root) {
        return DFSHelper(root, 0);
    }

	private int DFSHelper(TreeNode root, int index) {
		if (root == null) return index;
		return Integer.max(DFSHelper(root.left, index + 1), DFSHelper(root.right, index + 1));
	}
}
