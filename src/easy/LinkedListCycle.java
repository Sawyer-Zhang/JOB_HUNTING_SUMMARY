package easy;

import util.ListNode;

/**
 * 
 * 
 * @author Zhang shaoyang
 * 
 *         2018年9月26日
 */
public class LinkedListCycle {

	public boolean hasCycle(ListNode head) {
		if (head == null) {
			return false;
		}
		ListNode walker = head;
		ListNode runner = head;
		while (null != runner.getNext() && null != runner.getNext().getNext()) {
			walker = walker.getNext();
			runner = runner.getNext().getNext();
			if (walker == runner) {
				return true;
			}
		}
		return false;
	}
}
