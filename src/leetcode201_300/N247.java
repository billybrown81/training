package leetcode201_300;
import java.util.ArrayList;
import java.util.List;

public class N247 {
	private String[] odd = {"0", "1", "8"};
	private String[] even = {"00", "11", "69", "88", "96"};
    public List<String> findStrobogrammatic(int n) {
        List<String> res = new ArrayList<>();
        if (n == 0) return res;
        DFSHelper(res, "", n);
        return res;
    }

	private void DFSHelper(List<String> res, String path, int n) {
		if (n == 0) {
			res.add(path);
			return;
		}
		if (n % 2 == 1) {
			for (int i = 0; i < odd.length; i++)
				DFSHelper(res, odd[i], n - 1);
		} else {
			int i = n == 2? 1 : 0;
			while (i < even.length) {
				DFSHelper(res, even[i].charAt(0) + path + even[i].charAt(1), n - 2);
				i++;
			}
		}
	}
}
