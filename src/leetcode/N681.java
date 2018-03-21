package leetcode;


public class N681 {
	public  String nextClosestTime(String time) {
		int digits[] = {time.charAt(0) - '0', time.charAt(1) - '0', time.charAt(3) - '0', time.charAt(4) - '0'};
		int now = (digits[0] * 10 + digits[1]) * 60 + digits[2] * 10 + digits[3];
		int[] res = new int[1];
		res[0] = now;
		int path[] = new int[4];
		DFSHelper(res, digits, path, now, 0);
		return String.format("%02d", res[0] / 60) + ":" + String.format("%02d", res[0] % 60);
	}

	private  void DFSHelper(int[] res, int[] digits, int[] path, int now, int depth) {
		if (depth == 4) {
			int path_hour = path[0] * 10 + path[1];
			int path_minute = path[2] * 10 + path[3];
			if (path_hour > 23 || path_minute > 59) return;
			int cur = path_hour * 60 + path_minute;
			if (timeDiff(now, cur) < timeDiff(now, res[0])) {
				res[0] = cur;
			}
			return;
		}
		for (int digit : digits) {
			path[depth] = digit;
			DFSHelper(res, digits, path, now, depth + 1);
		}
		
	}

	private  int timeDiff(int t1, int t2) {
		if (t1 == t2) return Integer.MAX_VALUE;
		if (t1 < t2) return t2 - t1;
		else return t2 - t1 + 24 * 60;
	}
}
