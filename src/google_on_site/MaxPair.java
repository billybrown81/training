package google_on_site;

import java.util.PriorityQueue;

public class MaxPair {
	 class Pair {
		int index;
		int value;
		public Pair(int i, int v) {
			index = i;
			value = v;
		}
	}
	
	PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (b.value - a.value));
	
	public boolean isEmpty() {
		return pq.isEmpty();
	}
	
}
