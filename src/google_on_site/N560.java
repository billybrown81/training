package google_on_site;

import java.util.HashMap;
import java.util.Map;

//560. Subarray Sum Equals K
public class N560 {
    public int subarraySum(int[] nums, int k) {
    		int n = nums.length, sum = 0;
    		int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for (int i = 0; i < n; i++) {
			sum += nums[i];
			if (map.containsKey(sum - k)) count += map.get(sum - k);
			map.put(sum, map.getOrDefault(sum, 0) + 1);
		}
        return count;
    }
}
