package leetcode201_300;

public class N278 {
    public int firstBadVersion(int n) {
    		int start = 1, end = n;
    		while (start < end) {
				int mid = start + (end - start) / 2;
				if (isBadVersion(mid)) {
					end = mid;
				} else {
					start = mid + 1;
				}
			}
    		return end;
    }
    
    private boolean isBadVersion(int version) {
    		return false;
    }
}
