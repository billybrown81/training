package leetcode100_149;
import java.util.ArrayList;
import java.util.List;

public class N131 {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (s == null || s.length() == 0) return res;
        DFSHelper(res, new ArrayList<String>(), s, 0);
        return res;
    }

	private void DFSHelper(List<List<String>> res, ArrayList<String> path, String s, int index) {
		if (index == s.length()) res.add(new ArrayList<String>(path));
		for (int i = index; i < s.length(); i++) {
			if (isPalindrome(s, index, i)) {
				path.add(s.substring(index, i + 1));
				DFSHelper(res, path, s, i + 1);
				path.remove(path.size() - 1);
			}
		}
	}

	private boolean isPalindrome(String s, int start, int end) {
		if (start == end) return true;
		while (start < end) {
			if (s.charAt(start) != s.charAt(end)) return false;
			start++; end--;
		}
		return true;
	}
}
