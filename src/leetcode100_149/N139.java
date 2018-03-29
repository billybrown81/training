package leetcode100_149;
import java.util.List;

public class N139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s == null || s.length() == 0) return false;
        return DFSHelper(s, 0 ,wordDict);
    }

	private boolean DFSHelper(String s, int index, List<String> wordDict) {
		if (index == s.length()) return true;
		for (int i = s.length() - 1; i >= index; i--) {
			String word = s.substring(index, i + 1);
			if (wordDict.contains(word)) {
				if (DFSHelper(s, i + 1, wordDict)) return true;
			}
		}
		return false;
	}
	
	public boolean wordBreak2(String s, List<String> wordDict) {
        boolean[] res = new boolean[s.length() + 1];
        res[0] = true;
        for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (res[j] && wordDict.contains(s.substring(j, i))) {
					res[i] = true;
					break;
				}
			}
		}
        return res[s.length()];
    }

}
