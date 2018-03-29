package leetcode300_349;
import java.util.LinkedList;
import java.util.Queue;

//346. Moving Average from Data Stream
public class MovingAverage {
	private int count, size, sum;
	private Queue<Integer> queue;
    public MovingAverage(int size) {
        count = 0;
        sum = 0;
        this.size = size;
        queue = new LinkedList<>();
    }
    
    public double next(int val) {
        sum += val;
        count++;
        queue.offer(val);
        if (count > size) {
			count--;
			sum -= queue.remove();
		}
        return sum * 1.0 / count;
    }
}
