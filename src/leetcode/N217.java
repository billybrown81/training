package leetcode;
import java.util.HashSet;
import java.util.Set;

public class N217 {
    public boolean containsDuplicate(int[] nums) {
    		if (nums == null || nums.length == 0) return false;
        Set<Integer> set = new HashSet<Integer>();
        for (Integer number : nums) {
			if (set.contains(number)) return true;
			set.add(number);
		}
        return false;
    }
}
