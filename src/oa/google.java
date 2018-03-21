package oa;
import java.util.TreeSet;

public class google {
    public String solution1(String S) {
        int digits[] = {S.charAt(0) - '0', S.charAt(1) - '0', S.charAt(3) - '0',S.charAt(4) - '0'};
        int now = (digits[0] * 10 + digits[1]) * 60 + digits[2] * 10 + digits[3];
        int result[] = {now};
        int path[] = new int[4];
        boolean used[] = new boolean[4];
        DFSHelper(result, digits, path, used, now, 0);
        return String.format("%02d", result[0] / 60) + ":" + String.format("%02d", result[0] % 60);
    }

	private void DFSHelper(int[] result, int[] digits, int[] path, boolean[] used, int now, int depth) {
		if (depth == 4) {
			int h = path[0] * 10 + path[1];
			int m = path[2] * 10 + path[3];
			if (h > 23 || m > 59) return;
			int cur = h * 60 + m;
			if (timeDifference(now, cur) < timeDifference(now, result[0]))
				result[0] = cur;
			return;
		}
		for (int i = 0; i < 4; i++) {
			if (!used[i]) {
				path[depth] = digits[i];
				used[i] = true;
				DFSHelper(result, digits, path, used, now, depth + 1);
				used[i] = false;
			}
		}
		
	}

	private int timeDifference(int t1, int t2) {
		if (t1 == t2) return Integer.MAX_VALUE;
		if (t1 < t2) return t2 - t1;
		return t2 - t1 + 60 * 24;
	}
	
    public int solution2(int[] P, int K) {
        int n = P.length;
        if (n == 0 || n < K) return -1;
        if (n == K) return n;
        TreeSet<Integer> bst = new TreeSet<>();
        bst.add(0);
        bst.add(n + 1);
        for (int i = n - 1; i >= 0; i--) {
			int cur = P[i];
			bst.add(cur);
			int low = bst.lower(cur);
			int high = bst.higher(cur);
			if (low == cur - K - 1) return i;
			if (high == cur + K + 1) return i;
		}
        return -1;
    }
}
