package leetcode;
import java.util.HashMap;
import java.util.Map;

public class N220 {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k <= 0 || t < 0) return false;
        Map<Long, Long> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
			long mappednum =  nums[i];
			long bucket = mappednum / (t + 1);
			if (map.containsKey(bucket) ||
					map.containsKey(bucket - 1) && mappednum - map.get(bucket - 1) <= t ||
					map.containsKey(bucket + 1) && map.get(bucket + 1) - mappednum <= t) {
				return true;
			}
			if (i >= k) {
				long lastbucket = (nums[i - k]) / (t + 1);
				map.remove(lastbucket);
			}
			map.put(bucket, mappednum);
		}
        return false;
    }
}
