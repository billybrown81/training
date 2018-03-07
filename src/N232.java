import java.util.Stack;

public class N232 {
	Stack<Integer> input = new Stack();
	Stack<Integer> output = new Stack();
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        input.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        peek();
        return output.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if (output.empty()) {
        		while (!input.empty()) output.push(input.pop());	
		}
        return output.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return input.empty() && output.empty();
    }
}
