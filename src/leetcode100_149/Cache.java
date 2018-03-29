package leetcode100_149;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Hashtable;
import java.util.PriorityQueue;

public class Cache {
	
	class Node{
		int exp_time;
		int key;
		int value;
	}
	
	private void removeExpiredNodes() {
		int now = (int) (System.currentTimeMillis() - startTime);
		while (pq.peek().exp_time <= now) {
			Node cur = pq.poll();
			cache.remove(cur.key);
		}
		
	}
	
	private Hashtable<Integer, Node> cache = new Hashtable<>();
	private PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> (a.exp_time - b.exp_time));
	
	long startTime;
	public Cache() {
		startTime = System.currentTimeMillis();
	}
	
	public int get(int key) {
		removeExpiredNodes();
		Node node = cache.get(key);
		if (node == null) {
			return -1;
		}
		return node.value;
	}


	public void set(int time, int key, int value) {
		removeExpiredNodes();
		int now = (int) (System.currentTimeMillis() - startTime);
		Node node = cache.get(key);
		if (node != null) {
			node.exp_time = time + now;
			node.value = value;
		} else {
			Node newNode = new Node();
			newNode.exp_time = now + time;
			newNode.key = key;
			newNode.value = value;
			pq.offer(newNode);
			cache.put(key, node);
		}
	}
}
