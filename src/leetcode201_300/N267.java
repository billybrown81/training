package leetcode201_300;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class N267 {
    public static List<String> generatePalindromes(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        int count = 0;
        String path = "";
        Map<Character, Integer> map = new HashMap<>();
        List<Character> list = new ArrayList<>();
        for (Character cur : s.toCharArray()) {
			if (map.containsKey(cur)) 
				map.put(cur, map.get(cur) + 1);
			else map.put(cur, 1);
			if (map.get(cur) % 2 == 1)
				count++;
			else count--;
		}
        if (count > 1) return res;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
			char key = entry.getKey();
			int val = entry.getValue();
			if (val % 2 == 1) path += key;
			for (int i = 0; i < val / 2; i++) 
				list.add(key);
		}
        DFSHelper(res, list, path, new boolean[list.size()], 0);
        return res;
    }

	private static void DFSHelper(List<String> res, List<Character> list, String path, boolean[] used, int depth) {
		if (depth == list.size()) {
			res.add(path);
			return;
		}
		for (int i = 0; i < list.size(); i++) {
			if (i > 0 && list.get(i) == list.get(i - 1) && !used[i - 1])
				continue;
			if (!used[i]) {
				char c = list.get(i);
				used[i] = true;
				DFSHelper(res, list, c + path + c, used, depth + 1);
				used[i] = false;
			}
		}
	}
}
