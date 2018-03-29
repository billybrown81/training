package leetcode250_299;

import java.util.Arrays;

public class N261 {
    public boolean validTree(int n, int[][] edges) {
        int parent[] = new int[n];
        Arrays.fill(parent, -1);
        for (int i = 0; i < edges.length; i++) {
			int x = find(parent, edges[i][0]);
			int y = find(parent, edges[i][1]);
			if (x == y) return false;
			parent[x] = y;
		}
        return n - 1 == edges.length;
    }

	private int find(int[] parent, int i) {
		if (parent[i] == -1) return i;
		return find(parent, parent[i]);
	}
}
