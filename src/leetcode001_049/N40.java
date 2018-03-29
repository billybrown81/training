package leetcode001_049;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N40 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        calculate(candidates, ans, target, new ArrayList<Integer>(), 0);
        
        return ans;
    }

	private void calculate(int[] candidates, List<List<Integer>> ans, int target, ArrayList<Integer> curr, int start) {
		if (target == 0) {
			ans.add(new ArrayList<Integer>(curr));
		}else if (target > 0) {
			for (int i = start; i < candidates.length && target >= candidates[i]; i++) {
				if (i > start && candidates[i] == candidates [i - 1]) {
					continue;
				}
				curr.add(candidates[i]);
				calculate(candidates, ans, target - candidates[i], curr, i + 1);
				curr.remove(curr.size() - 1);
			}
		}
    }
}
