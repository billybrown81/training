import java.util.ArrayList;
import java.util.List;

public class ZigzagIterator {
	private List<List<Integer>> list = new ArrayList<>();
	private int row, col;
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
    		if (!v1.isEmpty()) list.add(v1);
    		if (!v2.isEmpty()) list.add(v2);
        row = 0; col = 0;
    }

    public int next() {
    		List<Integer> v = list.get(row);
    		int res = v.get(col);
    		if (col == v.size() - 1) {
    			list.remove(v);
    			row--;
    		}
    		if (row == list.size() - 1) {
				row = 0;
				col++;
		} else {
			row++;
		}
    		return res;
    }

    public boolean hasNext() {
        return !list.isEmpty();
    }
}
