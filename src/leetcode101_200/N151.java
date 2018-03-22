package leetcode101_200;
import java.util.Stack;

public class N151 {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        Stack<String> stack = new Stack<String>();
        int i = 0, j = 0;
        while (i < s.length() && s.charAt(i) == ' ') i++;
        while (i < s.length()) {
			if (s.charAt(i) == ' ') {
				stack.add(s.substring(j, i));
				j = i + 1;
			}
			i++;
			if (i == s.length()) stack.add(s.substring(j, i));
		}

        StringBuilder sb = new StringBuilder();
        if (stack.isEmpty()) return "";
        while (!stack.isEmpty()) sb.append(stack.pop() + " ");
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }
}
