package leetcode301_400;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

//347. Top K Frequent Elements

public class N347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
        PriorityQueue<Map.Entry<Integer, Integer>> heap = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			heap.offer(entry);
		}
        List<Integer> res = new ArrayList<>();
        while (res.size() < k) {
			res.add(heap.poll().getKey());
		}
        return res;
    }
}
