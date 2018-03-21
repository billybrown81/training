package leetcode301_400;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class N310 {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    		if (n == 1) return Collections.singletonList(0);
        List<Set<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new HashSet<>());
        for (int[] edge : edges) {
			adj.get(edge[0]).add(edge[1]);
			adj.get(edge[1]).add(edge[0]);
		}
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < n; i++) {
        		if (adj.get(i).size() == 1) leaves.add(i);
		}
        while (n > 2) {
        		n -= leaves.size();
        		List<Integer> newLeaves = new ArrayList<>();
        		for (int leaf : leaves) {
				int parent = adj.get(leaf).iterator().next();
				adj.get(parent).remove(leaf);
				if (adj.get(parent).size() == 1) newLeaves.add(parent);
			}
        		leaves = newLeaves;
		}
        return leaves;
    }
}
