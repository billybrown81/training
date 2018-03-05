import java.util.ArrayList;
import java.util.List;

public class N113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        	List<List<Integer>> res = new ArrayList<List<Integer>>();
    		List<Integer> path = new ArrayList<Integer>();
    		Helper(res, root, path, sum);
    		return res;
    }

	private void Helper(List<List<Integer>> res, TreeNode root, List<Integer> path, int sum) {
   		if (root == null) return;
		if (root.left == null & root.right == null) {
			if (root.val == sum) {
				path.add(root.val);
				res.add(new ArrayList<Integer>(path));
				path.remove(path.size() - 1);
			}
			return;
		}
		path.add(root.val);
		sum -= root.val;
		Helper(res, root.left, path, sum);
		Helper(res, root.right, path, sum);
		path.remove(path.size() - 1);
		sum += root.val;
	}
}
