import java.util.Stack;

public class Affirm {
	public static String prefixToPostfix(String pre_exp) {
		if (pre_exp == null || pre_exp.length() == 0) return "";
		Stack<String> stack = new Stack<String>();
		for (int i = pre_exp.length() - 1; i >= 0; i--) {
			char cur = pre_exp.charAt(i);
			if(isOperator(cur)) {
				String op1 = stack.pop(), op2 = stack.pop();
				stack.push(op1 + op2 + cur);
			} else {
				stack.push(cur + "");
			}
		}
		return stack.pop();
	}

	private static boolean isOperator(char c) {
		switch (c) {
			case '+':
			case '-':
			case '*':
			case '/':
			return true;
		}
		return false;
	}
}
