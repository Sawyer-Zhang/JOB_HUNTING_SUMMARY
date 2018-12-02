package easy;

import util.ListNode;

/**
 * Input: 1->2->6->3->4->5->6, val = 6 Output: 1->2->3->4->5
 * 
 * @author Zhang shaoyang
 * 
 *         2018年11月28日
 */
public class RemoveLinkedListElements {
	public ListNode removeElements(ListNode head, int val) {
		if (head == null)
			return null;
		head.setNext(removeElements(head.getNext(), val));
		return head.getVal() == val ? head.getNext() : head;
	}

	public ListNode removeElements1(ListNode head, int val) {
		if (head == null)
			return null;
		ListNode curr = head;
		while (curr.getNext() != null) {
			if (curr.getNext().getVal() == val) {
				curr.setNext(curr.getNext().getNext());
			} else {
				curr = curr.getNext();
			}
		}
		return head.getVal() == val ? head.getNext() : head;
	}
}
