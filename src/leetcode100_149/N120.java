package leetcode100_149;
import java.util.List;

public class N120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        return minPath(triangle, 0, 0, triangle.get(0).get(0));
    }

	private int minPath(List<List<Integer>> triangle, int level, int index, Integer sum) {
		if (level == triangle.size() - 1) return sum;
		int left = minPath(triangle, level + 1, index, sum + triangle.get(level + 1).get(index));
		int right = minPath(triangle, level + 1, index + 1, sum + triangle.get(level + 1).get(index + 1));
		return Math.min(left, right);
	}
	
	public int minimumTotal2(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;
        int size = triangle.size();
        int[] res = new int[size + 1];
        for (int layer = size - 1; layer >= 0; layer--) {
			for (int pos = 0; pos <= layer; pos++) {
				res[pos] = Math.min(res[pos], res[pos + 1]) + triangle.get(layer).get(pos);
			}
		}
        return res[0];
    }
}
