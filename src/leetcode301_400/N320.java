package leetcode301_400;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//320. Generalized Abbreviation

public class N320 {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        Set<String> set = new HashSet<>();
        DFSHelper(res, set, word, "", true);
        return res;
    }

	private void DFSHelper(List<String> res, Set<String> set, String word, String path, boolean canNum) {
		int n = word.length();
		if (n == 0) {
			if (!set.contains(path)) {
				res.add(path);
				set.add(path);
			}
			return;
		}
		for (int i = 0; i < n; i++) {
			DFSHelper(res, set, word.substring(i + 1), path + word.substring(0, i + 1), true);
			if (canNum) {
				DFSHelper(res, set, word.substring(i + 1), path + String.valueOf(i + 1), false);
			}
		}
	}
	
	
    public List<String> generateAbbreviations2(String word) {
        List<String> res = new ArrayList<>();
        DFSHelper2(res, word.toCharArray(), 0, new StringBuilder(), 0);
        return res;
    }

	private void DFSHelper2(List<String> res, char[] word, int pos, StringBuilder cur, int count) {
		if (pos == word.length) {
			if (count > 0) cur.append(count);
			res.add(cur.toString());
			return;
		}
		int len = cur.length();
		DFSHelper2(res, word, pos + 1, cur, count + 1);
		cur.setLength(len);
		if (count > 0) cur.append(count);
		DFSHelper2(res, word, pos + 1, cur.append(word[pos]), 0);
		cur.setLength(len);
	}
	
}
