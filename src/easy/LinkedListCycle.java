package easy;

/**
 * 
 * 
 * @author Zhang shaoyang
 * 
 *         2018年9月26日
 */
public class LinkedListCycle {

	private static class ListNode {
		int val;
		ListNode next;

		public ListNode(int x) {
			val = x;
			next = null;
		}
	}

	public boolean hasCycle(ListNode head) {
		if (head == null) {
			return false;
		}
		ListNode walker = head;
		ListNode runner = head;
		while (null != runner.next && null != runner.next.next) {
			walker = walker.next;
			runner = runner.next.next;
			if (walker == runner) {
				return true;
			}
		}
		return false;
	}
}
