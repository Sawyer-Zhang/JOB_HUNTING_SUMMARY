package easy;

import util.ListNode;

/**
 * Input: 1->2->3->4->5->NULL Output: 5->4->3->2->1->NULL
 * 
 * @author Zhang shaoyang
 * 
 *         2018年11月29日
 */
public class ReverseLinkedList {
	/**
	 * debug了很长时间才理解这个是什么意思（这么简单的代码需要用这么久，我也是够笨了）
	 * 其实就是每次拿出一个结点，将他的next设置为结果串的头结点（改变的是引用，而不是值，结点本身没变）
	 * 
	 * @param head
	 * @return
	 */
	public ListNode reverseList(ListNode head) {
		if (head == null)
			return null;
		ListNode resultNode = null;
		while (head != null) {
			ListNode next = head.getNext();
			head.setNext(resultNode);
			resultNode = head;
			head = next;
		}
		return resultNode;
	}

	public ListNode reverseList1(ListNode head) {
		return reverseList1(head, null);
	}

	private ListNode reverseList1(ListNode head, ListNode newHead) {
		if (head == null)
			return newHead;
		ListNode next = head.getNext();
		head.setNext(newHead);
		return reverseList1(next, head);
	}
}
