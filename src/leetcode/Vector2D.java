package leetcode;
import java.util.Iterator;
import java.util.List;

//251. Flatten 2D Vector

public class Vector2D implements Iterator<Integer>{

	List<List<Integer>> list;
    public Vector2D(List<List<Integer>> vec2d) {
        list = vec2d;
    }

    @Override
    public Integer next() {
    		List<Integer> tmpList = list.get(0);
        int tmp = tmpList.get(0);
        tmpList.remove(0);
        if (tmpList.isEmpty()) {
			list.remove(0);
		}
        return tmp;
    }

    @Override
    public boolean hasNext() {
        while (!list.isEmpty() && list.get(0).isEmpty()) {
    		list.remove(0);
        }
        return !list.isEmpty();
    }
}
