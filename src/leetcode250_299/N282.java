package leetcode250_299;

import java.util.ArrayList;
import java.util.List;
//282. Expression Add Operators

public class N282 {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<>();
        if (num == null || num.length() == 0) return res;
        DFSHelper(res, "", num, target, 0, 0, 0);
        return res;
    }

	private void DFSHelper(List<String> res, String path, String num, int target, int pos, long value, long prev) {
		if (pos == num.length()) {
			if (value == target) res.add(path);
			return;
		}
		for (int i = pos; i < num.length(); i++) {
			if (i != pos && num.charAt(pos) == '0') break;
			long cur = Long.parseLong(num.substring(pos, i + 1));
			if (pos == 0) {
				DFSHelper(res, path + cur, num, target, i + 1, cur, cur);
			} else {
				DFSHelper(res, path + "+" + cur, num, target, i + 1, value + cur, cur);
				DFSHelper(res, path + "-" + cur, num, target, i + 1, value - cur, -cur);
				DFSHelper(res, path + "*" + cur, num, target, i + 1, value - prev + prev * cur, prev * cur);
			}
		}
	}
}
