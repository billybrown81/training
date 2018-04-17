package oa;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class GlobalOrder {
	public List<String> getGlobalOrder(List<List<String>> orders) {
		Map<String, Set<String>> map = new HashMap<>();
		Set<String> set = new HashSet<>();
		List<String> res = new ArrayList<>();
		for (List<String> order : orders) {
			if (!map.containsKey(order.get(0))) {
				map.put(order.get(0), new HashSet<>());
				set.add(order.get(0));
			}
			for (int i = 1; i < order.size(); i++) {
				if (!map.containsKey(order.get(i))) {
					map.put(order.get(i), new HashSet<>());
					set.add(order.get(i));
				}
				map.get(order.get(i - 1)).add(order.get(i));
			}
		}
		Stack<String> stack = new Stack<>();
		Queue<String> queue = new LinkedList<>();
		Set<String> notVisited = new HashSet<>(set);
		for (String s : set) {
			if (map.get(s).size() == 0) {
				queue.add(s);
				stack.add(s);
				notVisited.remove(s);
			}
		}
		set = notVisited;
		while (!queue.isEmpty()) {
			if (queue.size() > 1) return res;
			String cur = queue.poll();
			Set<String> not = new HashSet<>(set);
			for (String s : set) {
				map.get(s).remove(cur);
				if (map.get(s).size() == 0) {
					queue.add(s);
					stack.add(s);
					not.remove(s);
				}
			}
			set = not;
		}
		if (!set.isEmpty()) {
			return res;
		}
		
		while (!stack.isEmpty()) {
			res.add(stack.pop());
		}
		return res;
	}
}
