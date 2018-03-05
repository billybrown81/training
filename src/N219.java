import java.util.HashMap;
import java.util.Map;

public class N219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null ||  nums.length == 0) return false;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i])) {
				if (i - map.get(nums[i]) <= k) return true;
				map.replace(nums[i], i); 
			} else {
				map.put(nums[i], i);
			}
		}
        return false;
    }
}
