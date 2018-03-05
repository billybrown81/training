import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class N57 {
	public class Interval {
	      int start;
	      int end;
	      Interval() { start = 0; end = 0; }
	      Interval(int s, int e) { start = s; end = e; }
	  }
	
	   public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
	        int size = intervals.size();
			List<Interval> res = new ArrayList<Interval>();
			int[] start = new int[size + 1];
			int[] end = new int[size + 1];
			for (int i = 0; i < size; i++) {
				start[i] = intervals.get(i).start;
				end[i] = intervals.get(i).end;
			}
			start[size] = newInterval.start;
			end[size] = newInterval.end;
			
			Arrays.sort(start);
			Arrays.sort(end);
			
			for (int i = 0, j = 0; i <= size; i++) {
				if (i == size || start[i + 1] > end[i]) {
					res.add(new Interval(start[j], end[i]));
					j = i + 1;
				}
			}
			
			return res;
	    
	    }
}
