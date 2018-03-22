package leetcode201_300;
import java.util.Arrays;
import java.util.Comparator;

import leetcode.Interval;

public class N252 {
    public boolean canAttendMeetings(Interval[] intervals) {
        if (intervals == null) return true;
        Arrays.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval arg0, Interval arg1) {
				return arg0.start - arg1.start;
			}
		});
        for (int i = 1; i < intervals.length; i++) {
			if (intervals[i].start < intervals[i - 1].end) return false;
		}
        return true;
    }
}
