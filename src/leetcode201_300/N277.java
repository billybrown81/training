package leetcode201_300;

public class N277 {
    public int findCelebrity(int n) {
        if (n <= 1) return -1;
        int candidate = 0;
        for (int i = 1; i < n; i++) {
			if (knows(candidate, i)) {
				candidate = i;
			}
		}
        for (int i = 0; i < n; i++) {
			if (i != candidate && knows(candidate, i) || !knows(i, candidate)) {
				return -1;
			}
		}
        return candidate;
    }
    
    boolean knows(int a, int b) {
    		return false;
    }
}
