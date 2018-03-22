package leetcode101_200;
import java.util.ArrayList;
import java.util.List;

import leetcode.TreeNode;

public class N107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        DFSHelper(res, root, 0);
        return res;
    }

	private void DFSHelper(List<List<Integer>> res, TreeNode root, int index) {
		if (root == null) return;
		if (res.size() - 1 < index) res.add(0, new ArrayList<Integer>());
		res.get(res.size() - 1 - index).add(root.val);
		DFSHelper(res, root.left, index + 1);
		DFSHelper(res, root.right, index + 1);
    }
}
