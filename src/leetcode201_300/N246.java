package leetcode201_300;

public class N246 {
    public boolean isStrobogrammatic(String num) {
        int start = 0, end = num.length() - 1;
        while (start <= end) {
			if (!"00 696 88 11".contains(num.charAt(start) + "" + num.charAt(end))) {
				return false;
			}
			start++; end--;
		}
        return true;
    }
}
