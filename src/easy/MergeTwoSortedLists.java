package easy;

import util.ListNode;

/**
 * Merge two sorted linked lists and return it as a new list. The new list
 * should be made by splicing together the nodes of the first two lists.
 * 
 * @author Zhang shaoyang
 * 
 *         2018年8月4日
 */
public class MergeTwoSortedLists {

	public static String print(ListNode ln) {
		StringBuilder sb = new StringBuilder();
		if (ln == null) {
			return null;
		}
		sb.append(ln.getVal());
		while (ln.getNext() != null) {
			sb.append(ln.getNext().getNext());
			ln = ln.getNext();
		}
		return sb.toString();
	}

	/**
	 * 常规操作将两个链表合并到一个新的链表当中
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null || l2 == null) {
			return l1 == null ? l2 : l1;
		}
		ListNode head = new ListNode(0);
		ListNode current = head;
		while (l1 != null && l2 != null) {
			if (l1.getVal() <= l2.getVal()) {
				current.setNext(l1);
				l1 = l1.getNext();
			} else {
				current.setNext(l2);
				l2 = l2.getNext();
			}
			current = current.getNext();
		}
		while (l1 != null) {
			current.setNext(l1);
			l1 = l1.getNext();
			current = current.getNext();
		}
		while (l2 != null) {
			current.setNext(l2);
			l2 = l2.getNext();
			current = current.getNext();
		}
		return head.getNext();
	}

	/**
	 * 递归方法，很精彩，很喜欢
	 * 
	 * @param l1
	 * @param l2
	 * @return
	 */
	public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		if (l1.getVal() < l2.getVal()) {
			l1.setNext(mergeTwoLists1(l1.getNext(), l2));
			return l1;
		} else {
			l2.setNext(mergeTwoLists1(l1, l2.getNext()));
			return l2;
		}
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(1);
		ListNode l3 = new ListNode(2);
		ListNode l4 = new ListNode(3);
		ListNode l5 = new ListNode(4);
		ListNode l6 = new ListNode(4);
		l1.setNext(l3);
		l3.setNext(l5);
		l2.setNext(l4);
		l4.setNext(l6);
		System.out.println(print(l1));
		System.out.println(print(l2));
		MergeTwoSortedLists mtsl = new MergeTwoSortedLists();
		ListNode result = mtsl.mergeTwoLists1(l1, l2);
		System.out.println(print(result));
	}
}
