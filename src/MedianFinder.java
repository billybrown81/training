import java.util.PriorityQueue;
import java.util.Queue;

//295. Find Median from Data Stream

public class MedianFinder {
	private Queue<Integer> small, large;
	
    public MedianFinder() {
        small = new PriorityQueue<>();
        large = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        large.add(num);
        small.add(-large.poll());
        if (large.size() < small.size()) {
			large.add(-small.poll());
		}
    }
    
    public double findMedian() {
        if (large.size() > small.size()) {
			return large.peek();
		} else {
			return (large.peek() - small.peek()) / 2.0;
		}
    }
}
