import java.util.ArrayList;
import java.util.List;

public class N229 {
	    public List<Integer> majorityElement(int[] nums) {
	    		List<Integer> res = new ArrayList();
	    		if (nums == null || nums.length == 0) return res;
	    		int candidate1 = 0, candidate2 = 1, c1 = 0, c2 = 0;
	    		for (Integer n : nums) {
				if (n == candidate1) c1++;
				else if (n == candidate2) c2++;
				else if (c1 == 0) {
					candidate1 = n; c1 = 1;
				}
				else if (c2 == 0) {
					candidate2 = n; c2 = 1;
				}
				else {
					c1--; c2--;
				}
			}
	    		c1 = 0; c2 = 0;
	    		for (Integer n : nums) {
				if (n == candidate1) c1++;
				if (n == candidate2) c2++;
			}
	    		if (c1 > nums.length / 3) res.add(candidate1);
	    		if (c2 > nums.length / 3) res.add(candidate2);
	    		return res;
	    }
}
