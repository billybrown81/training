import java.util.HashSet;
import java.util.Set;

public class GoogleOA {
	static int res;
	public static String nextClosestTime(String time) {
		int now = toMinute(time);
		res = now;
		int path[] = new int[4];
		Set<Integer> set = new HashSet<>();
		set.add(time.charAt(0) - '0');
		set.add(time.charAt(1) - '0');
		set.add(time.charAt(3) - '0');
		set.add(time.charAt(4) - '0');
		DFSHelper(set, path, now, 0);
		return String.valueOf(res / 60) + ":" + String.valueOf(res % 60);
	}

	private static void DFSHelper(Set<Integer> set, int[] path, int now, int depth) {
		if (depth == 4) {
			int path_hour = path[0] * 10 + path[1];
			int path_minute = path[2] * 10 + path[3];
			if (path_hour > 23 || path_minute > 59) return;
			int cur = path_hour * 60 + path_minute;
			if (timeDiff(now, cur) < timeDiff(now, res)) {
				res = cur;
			}
			return;
		}
		for (int digit : set) {
			path[depth] = digit;
			DFSHelper(set, path, now, depth + 1);
		}
		
	}

	private static int timeDiff(int t1, int t2) {
		if (t1 >= t2) return Integer.MAX_VALUE;
		return t2 - t1;
	}

	private static int toMinute(String time) {
		String t[] = time.split(":");
		return Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
	}
}
