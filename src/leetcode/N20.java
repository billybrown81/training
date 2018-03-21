package leetcode;
import java.util.Stack;

public class N20 {
    public boolean isValid(String s) {
    	if ((s.length() & 1) == 1) return false;
    	else {
        	Stack<Character> stack = new Stack();
        	for (int i = 0; i < s.length(); i++) {
        		switch (s.charAt(i)) {
				case '(': stack.push(')'); break;
				case '{': stack.push('}'); break;
				case '[': stack.push(']'); break;
				case ')': case '}': case ']': if (stack.isEmpty() || stack.pop() != s.charAt(i)) return false;
				}
    		}
        	return stack.isEmpty();
	}
        
    }
}
