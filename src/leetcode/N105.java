package leetcode;

public class N105 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (postorder == null || postorder.length == 0) return null;
    		return buildTreeHelper(postorder, 0, postorder.length - 1, inorder, 0 ,inorder.length - 1);
    }

	private TreeNode buildTreeHelper(int[] postorder, int pstart, int pend, int[] inorder, int istart, int iend) {
		TreeNode root = new TreeNode(postorder[pend]);
		int index = findRoot(root.val, inorder, istart, iend);
		root.left = (index > istart)? buildTreeHelper(postorder, pstart, pstart + index - istart - 1, inorder, istart, index - 1) : null;
		root.right = (index < iend)? buildTreeHelper(postorder, pend - (iend - index), pend - 1, inorder, index + 1, iend) : null;
		return root;
	}

	private int findRoot(int val, int[] inorder, int istart, int iend) {
		for (int i = istart; i <= iend; i++) {
			if (inorder[i] == val) return i;
		}
		return -1;
	}
}
