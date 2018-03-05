import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class N56 {

	public class Interval {
		      int start;
		      int end;
		      Interval() { start = 0; end = 0; }
		      Interval(int s, int e) { start = s; end = e; }
		  }
	
	private class IntervalComparator implements Comparator<Interval>{
		@Override
		public int compare(Interval a, Interval b) {
			return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
		}
	}
	
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
			return intervals;
		}
        if (intervals.size() == 1) {
			return intervals;
		}
        Collections.sort(intervals, new IntervalComparator());
        int position = 0;
        int end = intervals.get(0).end, start = intervals.get(0).start;
        while (position < intervals.size()) {
        		int newstart, newend;
        		if (position == intervals.size() - 1) {
				intervals.get(position).start = start;
				intervals.get(position).end = end;
				position++;
			}else {
        			newstart = intervals.get(position + 1).start;
        			newend = intervals.get(position + 1).end;
        			if (end >= newstart) {
        				intervals.remove(position);
        				start = Math.min(start, newstart);
        				end = Math.max(end, newend);
        			} else {
        				intervals.get(position).start = start;
        				intervals.get(position).end = end;
        				position++;
        				start = intervals.get(position).start;
        				end = intervals.get(position).end;
        			}
			}
		}
        return intervals;
    }
    
    public List<Interval> merge2(List<Interval> intervals) {
    		int size = intervals.size();
    		List<Interval> res = new ArrayList<Interval>();
    		int[] start = new int[size];
    		int[] end = new int[size];
    		for (int i = 0; i < size; i++) {
				start[i] = intervals.get(i).start;
				end[i] = intervals.get(i).end;
			}
    		Arrays.sort(start);
    		Arrays.sort(end);
    		
    		for (int i = 0, j = 0; i < size; i++) {
				if (i == size - 1 || start[i + 1] > end[i]) {
					res.add(new Interval(start[j], end[i]));
					j = i + 1;
				}
			}
    		
    		return res;
    }
}
