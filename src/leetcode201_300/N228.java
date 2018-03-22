package leetcode201_300;
import java.util.ArrayList;
import java.util.List;

public class N228 {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList();
        if (nums == null || nums.length == 0) return res;
        int i = 0, len = nums.length;
        while (i < len) {
			int j = i;
			while (j < len - 1 && nums[j + 1] - nums[j] == 1) j++;
			if (j == i) res.add(String.valueOf(nums[i]));
			else res.add(String.valueOf(nums[i]) + "->" + String.valueOf(nums[j]));
			i = j + 1;
		}
        return res;
    }
}
