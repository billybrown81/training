package leetcode050_099;
import java.util.ArrayList;
import java.util.List;

import leetcode.TreeNode;

public class N95 {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<TreeNode>();
    		return genTrees(1, n);
    }

	private List<TreeNode> genTrees(int start, int end) {
		List<TreeNode> res = new ArrayList<TreeNode>();
		if (start > end) {
			res.add(null);
		}
		for (int i = start; i <= end ; i++) {
			List<TreeNode> left = genTrees(start, i - 1);
			List<TreeNode> right = genTrees(i + 1, end);
			for (TreeNode l : left) {
				for (TreeNode r : right) {
					TreeNode root = new TreeNode(i);
					root.left = l;
					root.right = r;
					res.add(root);
				}
			}
		}
		return res;
	}
}
