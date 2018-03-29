package leetcode200_249;
import java.util.Stack;

public class N227 {
    public int calculate(String s) {
    		if (s == null || s.length() == 0) return 0;
    		Stack<Integer> stack = new Stack();
    		int num = 0;
    		char sign = '+';
    		for (int i = 0; i < s.length(); i++) {
    			char cur = s.charAt(i);
			if (Character.isDigit(cur)) num = num * 10 + cur - '0';
			if (!Character.isDigit(cur) && cur != ' ' || i == s.length() - 1) {
				switch (sign) {
				case '+': stack.push(num); break;
				case '-': stack.push(-num); break;
				case '*': stack.push(stack.pop() * num); break;
				case '/': stack.push(stack.pop() / num); break;
				}
				sign = cur; num = 0;
			}
		}
    		int result = 0;
    		while (!stack.empty()) result += stack.pop();
    		return result;
    }
}
