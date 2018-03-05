import java.util.LinkedList;
import java.util.List;

public class N89 {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new LinkedList<Integer>();
        for (int i = 0; i < 1<<n; i++) {
			res.add(i ^ i>>1);
		}
        return res;
    }
}
