package leetcode;
import java.util.ArrayList;
import java.util.Currency;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class N49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        for(String cur : strs) {
        		boolean added = false;
        		for (int i = 0; i < res.size(); i++) {
				String cmpr = res.get(i).get(0);
				if (isAnagrams(cur, cmpr)) {
					res.get(i).add(cur);
					added = true;
					break;
				}
			}
        		if (!added) {
        				List<String> newLine = new ArrayList<String>();
        				newLine.add(cur);
					res.add(newLine);
				}
        }
        
        return res;
    }

	private boolean isAnagrams(String cur, String cmpr) {
		if (cur.length() == cmpr.length()) {
			StringBuilder cmprSb = new StringBuilder(cmpr);
			for (int i = 0; i < cur.length(); i++) {
				char c = cur.charAt(i);
				int index = cmprSb.indexOf(String.valueOf(c));
				if (index >= 0) {
					cmprSb.deleteCharAt(index);
				} else {
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	public List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        if (strs == null || strs.length == 0) {
			return res;
		}
        int[] prime = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97, 101, 103};
        Map<Integer, List<String>> map = new HashMap<Integer, List<String>>();
        for (String cur : strs) {
			int key = 1;
			char[] chr = cur.toCharArray();
			for (int i = 0; i < chr.length; i++) {
				key *= prime[chr[i] - 'a'];
			}
			List<String> list;
			if (map.containsKey(key)) {
				list = map.get(key);
			}else {
				list = new ArrayList<String>();
				res.add(list);
				map.put(key, list);
			}
			list.add(cur);
		}
        
        return res;
    }
}
