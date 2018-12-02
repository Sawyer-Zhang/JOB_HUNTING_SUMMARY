package util;

/**
 * 链表工具类
 * 
 * @author Zhang shaoyang
 * 
 *         2018年11月17日
 */
public class ListNode {
	private int val;
	private ListNode next;

	public ListNode(int val) {
		this.val = val;
	}

	public ListNode(int val, ListNode next) {
		this.val = val;
		this.next = next;
	}

	public int getVal() {
		return val;
	}

	public void setVal(int val) {
		this.val = val;
	}

	public ListNode getNext() {
		return next;
	}

	public void setNext(ListNode next) {
		this.next = next;
	}

	public static String toString(ListNode head) {
		if (head == null) {
			return null;
		}
		StringBuilder listNodeStr = new StringBuilder(String.valueOf(head.getVal()));
		while (head.getNext() != null) {
			listNodeStr.append("->");
			listNodeStr.append(String.valueOf(head.getNext().getVal()));
			head = head.getNext();
		}
		return listNodeStr.toString();
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		ListNode sec = new ListNode(2);
		ListNode thr = new ListNode(6);
		ListNode fou = new ListNode(3);
		ListNode fiv = new ListNode(4);
		ListNode six = new ListNode(5);
		ListNode sev = new ListNode(6);
		head.setNext(sec);
		sec.setNext(thr);
		thr.setNext(fou);
		fou.setNext(fiv);
		fiv.setNext(six);
		six.setNext(sev);
		System.out.println(ListNode.toString(head));
	}
}
