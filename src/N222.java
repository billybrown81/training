import java.awt.RenderingHints;

public class N222 {
	int count = 0, depth = 0, maxDepth = -1;
    boolean found = false;
    public int countNodes(TreeNode root) { 
        DFSHelper(root);
        int mul = 1, res = 0;
        for (int i = 1; i <= maxDepth - 1; i++) {
			res += mul;
			mul *= 2;
		}
        return res + count / 2;
    }

	private void DFSHelper(TreeNode root) {
		if (root == null) {
			if (depth < maxDepth) found = true;
			else if (depth == maxDepth) count++;
			return;
		}
		depth++;
		if (depth > maxDepth) maxDepth = depth;
		DFSHelper(root.left);
		if (found) return;
		DFSHelper(root.right);
		depth--;
	}
	
	public int countNodes2(TreeNode root) {
		if (root == null) return 0;
		int count = 1;
		TreeNode left = root.left, right = root.left;
		while (right != null) {
			left = left.left;
			right = right.right;
			count = count << 1;
		}
		return count + (left == null? countNodes(root.right) : countNodes(root.left));
	}
}
