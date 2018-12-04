package easy;

import java.util.Stack;

/**
 * 
 * @description 用栈实现队列
 * 
 * @author Zhang shaoyang
 * 
 * @date 2018年12月4日
 */
public class ImplementQueueUsingStack {
	Stack<Integer> input;
	Stack<Integer> output;

	public ImplementQueueUsingStack() {
		input = new Stack<Integer>();
		output = new Stack<Integer>();
	}

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
		/*
		 * 当输出的栈为空的时候才从输入的栈中取出，防止错乱
		 */
		if (output.isEmpty()) {
			while (!input.isEmpty()) {
				output.push(input.pop());
			}
		}
		return output.peek();
	}

	/** Returns whether the queue is empty. */
	public boolean empty() {
		return input.isEmpty() && output.isEmpty();
	}
}
