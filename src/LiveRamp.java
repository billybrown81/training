import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LiveRamp {
    public int solution(int[] T) {
        if (T == null || T.length == 0) return 0;
        Set<Integer> set = new HashSet<Integer>();
        for (int type : T)
			set.add(type);
        return Math.min(set.size(), T.length / 2);
    }
    
    public int solution2(int[] A) {
        if (A == null || A.length == 0) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int loc : A) {
    			map.put(loc, 1);
        }
        int start = 0, end = 0, minLen = A.length, counter = map.size();
        while (end < A.length) {
			int loc = A[end];
			if (map.get(loc) > 0) {
				counter--;
			}
			map.put(loc, map.get(loc) - 1);
			end++;
			while (counter == 0) {
				if (end - start < minLen) {
					minLen = end - start;
				}
				int locStart = A[start];
				map.put(locStart, map.get(locStart) + 1);
				if (map.get(locStart) > 0) {
					counter++;
				}
				start++;
			}
		}
        return minLen;
    }
}
