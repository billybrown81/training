package leetcode350_399;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class N373 {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return res;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] + a[1] - b[0] - b[1]);
        for (int i = 0; i < nums1.length && i < k; i++) pq.offer(new int[] {nums1[i], nums2[0], 0});
        while (k > 0 && !pq.isEmpty()) {
			int cur[] = pq.poll();
			res.add(new int[] {cur[0], cur[1]});
			k--;
			if (cur[2] == nums2.length - 1) continue;
			pq.offer(new int[] {cur[0], nums2[cur[2] + 1], cur[2] + 1});
		}
        return res;
    }
    
    public List<int[]> kSmallestPairs2(int[] nums1, int[] nums2, int k) {
        List<int[]> res = new ArrayList<>();
        if (nums1.length == 0 || nums2.length == 0 || k == 0) return res;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {

			@Override
			public int compare(int[] arg0, int[] arg1) {
				return nums1[arg0[0]] + nums2[arg0[1]] - nums1[arg1[0]] - nums2[arg1[1]];
			}
		});
        for (int i = 0; i < nums1.length && i < k; i++) pq.offer(new int[] {i, 0});
        while (k > 0 && !pq.isEmpty()) {
			int cur[] = pq.poll();
			res.add(new int[] {nums1[cur[0]], nums2[cur[1]]});
			k--;
			if (cur[1] < nums2.length - 1) {
				pq.add(new int[] {cur[0], cur[1] + 1});
			}
		}
        return res;
    }
}
