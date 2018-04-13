package google_on_site;
//480. Sliding Window Median

import java.util.Comparator;
import java.util.PriorityQueue;

public class N480 {
	PriorityQueue<Integer> large;
	PriorityQueue<Integer> small;
    public double[] medianSlidingWindow(int[] nums, int k) {
        large = new PriorityQueue<>();
        small = new PriorityQueue<>(new Comparator<Integer>() {

			@Override
			public int compare(Integer a, Integer b) {
				return b.compareTo(a);
			}
		});
        int n = nums.length - k + 1;
        if (n <= 0) return new double[0];
        double[] res = new double[n];
        for (int i = 0; i < nums.length; i++) {
        		add(nums[i]);
        		if (i >= k) remove(nums[i - k]);
        		if (i >= k - 1) res[i - k + 1] = getMedian();
		}
        return res;
    }

	private double getMedian() {
		if (large.size() == 0 && small.size() == 0) return 0;
		if (large.size() == small.size()) return ((double)large.peek() + (double)small.peek()) / 2.0;
		return large.peek();
	}
	private void add(int i) {
		if (i < getMedian()) small.add(i);
		else large.add(i);
		if (small.size() > large.size()) large.add(small.poll());
		if (large.size() - small.size() > 1) small.add(large.poll());
	}
	private void remove(int i) {
		if (i < getMedian()) small.remove(i);
		else large.remove(i);
		if (small.size() > large.size()) large.add(small.poll());
		if (large.size() - small.size() > 1) small.add(large.poll());
	}
}
