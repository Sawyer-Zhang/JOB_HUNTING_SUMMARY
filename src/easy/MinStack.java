package easy;

import java.util.Stack;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 * 
 * push(x) -- Push element x onto stack. pop() -- Removes the element on top of
 * the stack. top() -- Get the top element. getMin() -- Retrieve the minimum
 * element in the stack.
 * 
 * @author Zhang shaoyang
 * 
 *         2018年9月26日
 */
public class MinStack {
	private Stack<Integer> min;
	private Stack<Integer> stack;

	public MinStack() {
		min = new Stack<Integer>();
		stack = new Stack<Integer>();
	}

	public void push(int x) {
		stack.push(x);
		if (min.size() == 0) {
			min.push(x);
		} else if ((int) min.peek() >= x) {
			min.push(x);
		}
	}

	public void pop() {
		int stackPoped = (int) stack.pop();
		if ((int) min.peek() == stackPoped) {
			min.pop();
		}
	}

	public int top() {
		return (int) stack.peek();
	}

	public int getMin() {
		return (int) min.peek();
	}
}
