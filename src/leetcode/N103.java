package leetcode;
import java.util.ArrayList;
import java.util.List;

public class N103 {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        DFSHelper(res, root, 0);
        return res;
    }

	private void DFSHelper(List<List<Integer>> res, TreeNode root, int index) {
		if (root == null) return;
		if (res.size() - 1 < index) res.add(new ArrayList<Integer>());
		if (index % 2 == 0) res.get(index).add(root.val);
		else res.get(index).add(0, root.val);
		DFSHelper(res, root.left, index + 1);
		DFSHelper(res, root.right, index + 1);
    }
}
