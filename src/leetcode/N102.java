package leetcode;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class N102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) return res;
        DFSHelper(res, root, 0);
        return res;
    }

	private void DFSHelper(List<List<Integer>> res, TreeNode root, int index) {
		if (root == null) return;
		if (res.size() - 1 < index) res.add(new ArrayList<Integer>());
		res.get(index).add(root.val);
		DFSHelper(res, root.left, index + 1);
		DFSHelper(res, root.right, index + 1);
	}
}
