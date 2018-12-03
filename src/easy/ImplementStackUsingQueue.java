package easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * 
 * @author Zhang shaoyang
 * 
 *         2018年12月3日
 */
public class ImplementStackUsingQueue {
	Queue<Integer> queue = null;

	public ImplementStackUsingQueue() {
		queue = new LinkedList<Integer>();
	}

	/** Push element x onto stack. */
	public void push(int x) {
		queue.add(x);
		for (int i = 1; i < queue.size(); i++) {
			queue.add(queue.remove());
		}
	}

	/** Removes the element on top of the stack and returns that element. */
	public int pop() {
		return queue.remove();
	}

	/** Get the top element. */
	public int top() {
		return queue.peek();
	}

	/** Returns whether the stack is empty. */
	public boolean empty() {
		return queue.isEmpty();
	}
}