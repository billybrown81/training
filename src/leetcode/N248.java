package leetcode;
import java.util.ArrayList;
import java.util.List;

public class N248 {
	private String[] odd = {"0", "1", "8"};
	private String[] even = {"00", "11", "69", "88", "96"};
	private int count = 0;
    public int strobogrammaticInRange(String low, String high) {
        DFSHelper("");
        return count;
    }

	private void DFSHelper(String path) {
	}
}
