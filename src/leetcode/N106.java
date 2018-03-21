package leetcode;

public class N106 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) return null;
    		return buildTreeHelper(preorder, 0, preorder.length - 1, inorder, 0 ,inorder.length - 1);
    }

	private TreeNode buildTreeHelper(int[] preorder, int pstart, int pend, int[] inorder, int istart, int iend) {
		TreeNode root = new TreeNode(preorder[pstart]);
		int index = findRoot(root.val, inorder, istart, iend);
		root.left = (index > istart)? buildTreeHelper(preorder, pstart + 1, pstart + index - istart , inorder, istart, index - 1) : null;
		root.right = (index < iend)? buildTreeHelper(preorder, pend - (iend - index) + 1, pend, inorder, index + 1, iend) : null;
		return root;
	}

	private int findRoot(int val, int[] inorder, int istart, int iend) {
		for (int i = istart; i <= iend; i++) {
			if (inorder[i] == val) return i;
		}
		return -1;
	}
}
