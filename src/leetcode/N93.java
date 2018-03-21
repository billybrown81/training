package leetcode;
import java.util.ArrayList;
import java.util.List;

public class N93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        if (s.length() < 4 || s.length() > 12) return res;
        StringBuilder sb = new StringBuilder(s);
        DFSHelper(res, sb, 0, 0);
        return res;
    }

	private void DFSHelper(List<String> res, StringBuilder sb, int index, int ipIndex) {
		if (ipIndex == 3) {
			if (sb.charAt(index) == '0' && index != sb.length() - 1) return;
			if (Integer.valueOf(sb.substring(index, sb.length())) <= 255) {
				res.add(sb.toString());
			}
			return;
		}
		if (sb.charAt(index) == '0') {
			if (index == sb.length() - 1) return;
			sb.insert(index + 1, ".");
			DFSHelper(res, sb, index + 2, ipIndex + 1);
		}
		for (int i = index; i < index + 3; i++) {
			if (i == sb.length() - 1) break;
			if (i - index == 2 && Integer.valueOf(sb.substring(index, i + 1)) > 255) break;
			sb.insert(i + 1, ".");
			DFSHelper(res, sb, i + 2, ipIndex + 1);
			sb.deleteCharAt(i + 1);
		}
	}
}
