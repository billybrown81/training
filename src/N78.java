import java.util.ArrayList;
import java.util.List;

public class N78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        res.add(new ArrayList<Integer>());
        int index = 0;
        List<Integer> numslist= new ArrayList<Integer>();
        for (int i = 0; i < nums.length; i++) {
			numslist.add(nums[i]);
		}
        for (int i = 1; i <= nums.length; i++) {
            List<Integer> path = new ArrayList<Integer>();
            DFS(res, path, index, numslist, i);
		}
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
