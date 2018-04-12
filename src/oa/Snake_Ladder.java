package oa;

import java.util.LinkedList;
import java.util.Queue;

public class Snake_Ladder {
	class V {
		int v;
		int d;
		public V(int v, int d) {
			this.v = v;
			this.d = d;
		}
	}
	public int minDiceThrows(int moves[]) {
		int n = moves.length;
		Queue<V> queue = new LinkedList<>();
		V v = new V(0, 0);
		queue.offer(v);
		boolean[] visited = new boolean[n];
		visited[0] = true;
		while (!queue.isEmpty()) {
			v = queue.poll();
			int vetrex = v.v;
			if (vetrex == n - 1) break;
			for (int i = vetrex + 1; i <= (vetrex + 6) && i < n; i++) {
				int dis = v.d + 1;
				visited[i] = true;
				int index;
				index = moves[i] == -1? i : moves[i];
				V newV = new V(index, dis);
				queue.offer(newV);
			}
		}
		return v.d;
	}
}
