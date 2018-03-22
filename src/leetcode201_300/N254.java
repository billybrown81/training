package leetcode201_300;
import java.util.ArrayList;
import java.util.List;

public class N254 {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        DFSHelper(res, new ArrayList<Integer>(), n, 2);
        return res;
    }

	private void DFSHelper(List<List<Integer>> res, ArrayList<Integer> path, int n, int index) {
			if (path.size() >= 1) {
				path.add(n);
				res.add(new ArrayList<>(path));
				path.remove(path.size()-1);
			}
		for (int i = index; i * i <= n; i++) {
			if (n % i == 0) {
				path.add(i);
				DFSHelper(res, path, n / i, i);
				path.remove(path.size() - 1);
			}
		}
	}
}
