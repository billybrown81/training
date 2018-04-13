package google_on_site;

import java.util.PriorityQueue;

public class Bench {
	class blank {
		int left, right;
		int dis;
		public blank(int left, int right) {
			this.left = left;
			this.right = right;
			dis = this.right - this.left - 1;
		}
	}
	PriorityQueue<blank> pq;
	Integer[] arr;
	public Bench(Integer[] b2) {
		this.arr = b2;
		pq = new PriorityQueue<>((a, b) -> (b.dis - a.dis));
		int left = -1, right = 0;
		while (right < b2.length) {
			if (b2[right] == 1) {
				pq.offer(new blank(left, right));
				left = right;
			}
			right++;
		}
		pq.offer(new blank(left, b2.length));
	}
	public void addPerson() {
		blank tmp = pq.poll();
		if (tmp.dis <= 0) {
			System.out.println("No more space");
		} else {
			this.arr[tmp.left + (tmp.dis + 1) / 2] = 1;
			pq.offer(new blank(tmp.left, tmp.left + (tmp.dis + 1) / 2));
			pq.offer(new blank(tmp.left + (tmp.dis + 1) / 2, tmp.right));
		}
	}
}
