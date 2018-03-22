package leetcode201_300;
import java.util.ArrayList;
import java.util.List;

import leetcode.TreeNode;

public class N257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null) return res;
        DFSHelper(res, root, "");
        return res;
    }

	private void DFSHelper(List<String> res, TreeNode root, String path) {
		if (root.left == null && root.right == null) {
			res.add(path + root.val);
		}
		if (root.left != null) {
			DFSHelper(res, root.left, path + root.val + "->");
		}
		if (root.right != null) {
			DFSHelper(res, root.right, path + root.val + "->");
		}
	}
}
