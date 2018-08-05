package easy;
/**
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 * 
 * @author Zhang shaoyang
 * 
 * 2018年8月4日
 */
public class MergeTwoSortedLists {
	private static class ListNode{
		private int value;
		private ListNode next;
		public ListNode(int value) {
			this.value = value;
		}
		public ListNode(int value, ListNode nextNode) {
			this.value = value;
			this.next = nextNode;
		}
		public void setNext(ListNode next) {
			this.next = next;
		}
	}
	public static String print(ListNode ln) {
		StringBuilder sb = new StringBuilder();
		if (ln == null) {
			return null;
		}
		sb.append(ln.value);
		while(ln.next != null) {
			sb.append(ln.next.value);
			ln = ln.next;
		}
		return sb.toString();
	}
	/**
	 *  常规操作将两个链表合并到一个新的链表当中
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
		while(l1 != null && l2 != null) {
			if (l1.value <= l2.value) {
				current.next = l1;
				l1 = l1.next;
			}else {
				current.next = l2;
				l2 = l2.next;
			}
			current = current.next;
		}
		while(l1 != null) {
			current.next = l1;
			l1 = l1.next;
			current = current.next;
		}
		while(l2 != null) {
			current.next = l2;
			l2 = l2.next;
			current = current.next;
		}
		return head.next;
	}
	/**
	 * 递归方法，很精彩，很喜欢
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
		if (l1.value < l2.value) {
			l1.next = mergeTwoLists1(l1.next, l2);
			return l1;
		}else {
			l2.next = mergeTwoLists1(l1, l2.next);
			return l2;
		}
	}
	public static void main(String []args) {
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
