package leetcode201_300;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

import leetcode.Interval;

public class N253 {
    public int minMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval arg0, Interval arg1) {
				return arg0.start - arg1.start;
			}
		});
        PriorityQueue<Interval> heap = new PriorityQueue<Interval>(intervals.length, new Comparator<Interval>() {

			@Override
			public int compare(Interval arg0, Interval arg1) {
				return arg0.end - arg1.end;
			}
		});
        heap.offer(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
			Interval interval = heap.poll();
			if (intervals[i].start >= interval.end) {
				interval.end = intervals[i].end;
			} else {
				heap.offer(intervals[i]);
			}
			heap.offer(interval);
		}
        return heap.size();
    }
}
