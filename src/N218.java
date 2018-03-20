import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

//218. The Skyline Problem

public class N218 {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> result = new ArrayList<>(), critical = new ArrayList<>();
        for (int[] h : buildings) {
			critical.add(new int[] {h[0], -h[2]});
			critical.add(new int[] {h[1], h[2]});
		}
        Collections.sort(critical, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				if (a[0] != b[0]) {
					return a[0] - b[0];
				}
				return a[1] - b[1];
			}
		});
        Queue<Integer> queue = new PriorityQueue(new Comparator<Integer>() {

			@Override
			public int compare(Integer arg0, Integer arg1) {
				return arg1 - arg0;
			}
		});
        queue.offer(0);
        int prev = 0;
        for (int[] criticalPoint : critical) {
			if (criticalPoint[1] < 0) {
				queue.offer(-criticalPoint[1]);
			} else {
				queue.remove(criticalPoint[1]);
			}
			int cur = queue.peek();
			if (cur != prev) {
				result.add(new int[] {criticalPoint[0], cur});
				prev = cur;
			}
		}
        return result;
    }
}

