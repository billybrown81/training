package leetcode100_149;
import java.util.ArrayList;
import java.util.List;

public class N118 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
    		if (numRows == 0) return res;
    		List<Integer> path = new ArrayList<Integer>();
    		for (int i = 1; i <= numRows; i++) {
    			path.add(1);
    			if (i >= 3) {
				for (int j = 1; j <= i - 2 ; j++) {
					path.remove(j);
					path.add(j, res.get(res.size() - 1).get(j - 1) + res.get(res.size() - 1).get(j));
				}
			}
    			res.add(new ArrayList<Integer>(path));		
		}
    		return res;
    }
}
