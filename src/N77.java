import java.util.ArrayList;
import java.util.List;

public class N77 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (k == 0 || n < k) {
			return res;
		}
        int index = 0;
        List<Integer> path = new ArrayList<Integer>();
        List<Integer> nums= new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
			nums.add(i);
		}
        DFS(res, path, index, nums, k);
        return res;
    }

	private void DFS(List<List<Integer>> res, List<Integer> path, int index, List<Integer> nums, int k) {
		if (path.size() == k) {
			res.add(new ArrayList<Integer>(path));
		}
		for (int i = index; i < nums.size(); i++) {
			int cur = nums.get(i);
			path.add(cur);
			nums.remove(i);
			DFS(res, path, i, nums, k);
			nums.add(i, cur);
			path.remove(path.size() - 1);
		}
	}
}
