package leetcode300_349;
//323. Number of Connected Components in an Undirected Graph

import java.util.Arrays;

public class N323 {
    public int countComponents(int n, int[][] edges) {
        if (n <= 0) return 0;
        int parent[] = new int[n];
        Arrays.fill(parent, -1);
        int count = n;
        for (int[] edge : edges) {
			int x = find(parent, edge[0]);
			int y = find(parent, edge[1]);
			if (x != y) {
				union(parent, x , y);
				count--;
			}
		}
        return count;
    }

	private void union(int[] parent, int x, int y) {
		int xset = find(parent, x);
		int yset = find(parent, y);
		parent[xset] = yset;
	}

	private int find(int[] parent, int i) {
		if (parent[i] == -1) return i;
		return find(parent, parent[i]);
	}
}
