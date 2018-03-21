package leetcode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class N140 {
    public List<String> wordBreak(String s, List<String> wordDict) {
    		List<String> res = new ArrayList<String>();
        if (s == null || s.length() == 0) return res;
        DFSHelper(res, s, new StringBuilder(), 0 ,wordDict);
        return res;
    }

	private void DFSHelper(List<String> res, String s, StringBuilder sb, int index, List<String> wordDict) {
		if (index == s.length()) res.add(sb.toString());
		for (int i = index; i < s.length(); i++) {
			String word = s.substring(index, i + 1);
			if (wordDict.contains(word)) {
				if (index != 0) sb.append(" ");
				sb.append(word);
				DFSHelper(res, s, sb, i + 1, wordDict);
				sb.delete(sb.length() - word.length(), sb.length());
				if (index != 0) sb.deleteCharAt(sb.length() - 1);
			}
		}
    }
	
    public List<String> wordBreak2(String s, List<String> wordDict) {
    		return DFS(s, wordDict, new HashMap<String, LinkedList<String>>());
    }

	private List<String> DFS(String s, List<String> wordDict, HashMap<String, LinkedList<String>> map) {
		if (map.containsKey(s)) return map.get(s);
		LinkedList<String> res = new LinkedList<String>();
		if (s.length() == 0) return res;
		for (String word : wordDict) {
			if (s.startsWith(word)) {
				List<String> subList = DFS(s.substring(word.length()), wordDict, map);
				for (String string : subList) {
					res.add(word + " " + string);
				}
			}
		}
		if (res.size() != 0) map.put(s, res);
		return res;
	}
}
