package easy;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * @author Zhang shaoyang
 * 
 * 2018年8月18日
 */
public class RemoveDuplicatesFromSortedList {
	private static class ListNode{
		private int value;
		private ListNode next;
		public ListNode(int value, ListNode next) {
			this.value = value;
			this.next = next;
		}
		public ListNode(int value) {
			this.value = value;
		}
		public void setNext(ListNode next) {
			this.next = next;
		}
	}
	public ListNode removeDuplicatesFromSortesList(ListNode head) {
		ListNode temp = head;
		while(temp != null) {
			if (temp.next == null) {
				break;
			}
			if (temp.value == temp.next.value) {
				temp.next = temp.next.next;
			}else {
				temp = temp.next;
			}
		}
		return head;
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
	public static void main(String []args) {
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
