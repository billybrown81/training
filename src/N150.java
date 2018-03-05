import java.util.Stack;

public class N150 {
    public int evalRPN(String[] tokens) {
    		int a, b;
    		Stack<Integer> stack = new Stack<Integer>();
    		for (String s : tokens) {
    			switch (s) {
				case "+": stack.add(stack.pop() + stack.pop());
					break;
				case "-": b = stack.pop();
				a = stack.pop();
				stack.add(a - b);
				break;
				
				case "*": stack.add(stack.pop() * stack.pop());
				break;
				case "/": b = stack.pop();
				a = stack.pop();
				stack.add(a / b);
				break;

				default: stack.add(Integer.parseInt(s));
					break;
				}
		}
    		return stack.pop();
    }
}
