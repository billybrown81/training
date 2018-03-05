import java.util.ArrayList;
import java.util.List;

public class N216 {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (n <= 0 || k <= 0) return res;
        DFSHelper(res, new ArrayList<Integer>(), k, n, 1);
        return res;
    }

	private static void DFSHelper(List<List<Integer>> res, ArrayList<Integer> path, int k, int n, int index) {
		if (k == 0 && n == 0) {
			res.add(new ArrayList<Integer>(path));
			return;
		}
		if (k > 0 && n >= index) {
			for (int i = index; i <= 9; i++) {
				if (i > n/k) break;
				path.add(i);
				DFSHelper(res, path, k - 1, n - i, i + 1);
				path.remove(path.size() - 1);
			}
		}
	}
}
