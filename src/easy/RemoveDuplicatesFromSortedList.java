package easy;

import util.ListNode;

/**
 * Given a sorted linked list, delete all duplicates such that each element
 * appear only once.
 * 
 * @author Zhang shaoyang
 * 
 *         2018年8月18日
 */
public class RemoveDuplicatesFromSortedList {
	public ListNode removeDuplicatesFromSortesList(ListNode head) {
		ListNode temp = head;
		while (temp != null) {
			if (temp.getNext() == null) {
				break;
			}
			if (temp.getVal() == temp.getNext().getVal()) {
				temp.setNext(temp.getNext().getNext());
			} else {
				temp = temp.getNext();
			}
		}
		return head;
	}

	public static String print(ListNode ln) {
		StringBuilder sb = new StringBuilder();
		if (ln == null) {
			return null;
		}
		sb.append(ln.getVal());
		while (ln.getNext() != null) {
			sb.append(ln.getNext().getVal());
			ln = ln.getNext();
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(1);
		ListNode l3 = new ListNode(2);
		ListNode l4 = new ListNode(3);
		ListNode l5 = new ListNode(4);
		ListNode l6 = new ListNode(4);
		l1.setNext(l2);
		l2.setNext(l3);
		l3.setNext(l4);
		l4.setNext(l5);
		l5.setNext(l6);
		System.out.println(print(l1));
		RemoveDuplicatesFromSortedList rdfsa = new RemoveDuplicatesFromSortedList();
		ListNode result = rdfsa.removeDuplicatesFromSortesList(l1);
		System.out.println(print(result));
	}
}
