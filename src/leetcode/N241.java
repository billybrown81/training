package leetcode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class N241 {
	Map<String, List<Integer>> map = new HashMap();
    public List<Integer> diffWaysToCompute(String input) {
    		List<Integer> res = new ArrayList();
        if (input == null || input.length() == 0) return res;  
        for (int i = 0; i < input.length(); i++) {
			char cur = input.charAt(i);
			if (cur == '+' || cur == '-' || cur == '*') {
				String left = input.substring(0, i);
				String right = input.substring(i + 1, input.length());
				List<Integer> l1 = map.getOrDefault(left, diffWaysToCompute(left));
				List<Integer> l2 = map.getOrDefault(right, diffWaysToCompute(right));
				int result = 0;
				for (Integer n1 : l1) {
					for (Integer n2 : l2) {
						switch (cur) {
						case '+': result = n1 + n2; break;
						case '-': result = n1 - n2; break;
						case '*': result = n1 * n2; break;
						}
						res.add(result);
					}
				}
			}
		}
        if (res.size() == 0) res.add(Integer.parseInt(input));
        map.put(input, res);
        return res;
    }
}
