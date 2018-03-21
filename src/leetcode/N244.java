package leetcode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class N244 {
	private Map<String, List<Integer>> map;
    public N244(String[] words) {
    		map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
        		String word = words[i];
        		
			if (map.containsKey(word))
				map.get(word).add(i);
			else {
				List<Integer> tmp = new ArrayList<>();
				tmp.add(i);
				map.put(word, tmp);
			}
		}
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> l1 = map.get(word1), l2 = map.get(word2);
        int min = Integer.MAX_VALUE, i = 0, j = 0;
        while (i < l1.size() && j < l2.size()) {
			int index1 = l1.get(i), index2 = l2.get(j);
			if (index1 < index2) {
				min = Math.min(min, index2 - index1);
				i++;
			} else {
				min = Math.min(min, index1 - index2);
				j++;
			}
			if (min == 1) return min;
		}
        return min;
    }
}
