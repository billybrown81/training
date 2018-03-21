package leetcode;
//344. Reverse String
public class N344 {
    public String reverseString(String s) {
        if (s == null || s.length() <= 1) return s;
        char c[] = s.toCharArray();
        int start = 0, end = s.length() - 1;
        while (start < end) {
			char tmp = c[start];
			c[start] = c[end];
			c[end] = tmp;
			start++;
			end--;
		}
        return String.valueOf(c);
    }
}
