import java.util.ArrayList;
import java.util.List;

public class N199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        rightSideView(res, root, 0);
        return res;
    }

	private void rightSideView(List<Integer> res, TreeNode root, int cur) {
		if (root == null) return;
		if (res.size() == cur) res.add(root.val);
		rightSideView(res, root.right, cur + 1);
		rightSideView(res, root.left, cur + 1);
	}
}
