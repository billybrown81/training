package leetcode;
import java.util.ArrayList;
import java.util.List;

public class N119 {
    public List<Integer> getRow(int rowIndex) {
        int[] res = new int[rowIndex + 1];
        res[0] = 1;
        for (int i = 1; i < rowIndex + 1; i++) {
			for (int j = i; j >= 1; j--) {
				res[j] += res[j - 1];
			}
		}
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < res.length; i++) {
			result.add(res[i]);
		}
        return result;
    }
}
