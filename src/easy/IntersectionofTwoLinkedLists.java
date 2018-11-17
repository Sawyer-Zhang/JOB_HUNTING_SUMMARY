package easy;

import util.ListNode;

/**
 * Write a program to find the node at which the intersection of two singly
 * linked lists begins.
 * 
 * @author Zhang Shaoyang
 * @version 1.0 at 2018年9月27日
 */
public class IntersectionofTwoLinkedLists {

	private int listLength(ListNode node) {
		int len = 0;
		if (node == null) {
			return len;
		}
		while (node.getNext() != null) {
			node = node.getNext();
			len++;
		}
		return len;
	}

	/**
	 * 第一种解法首先要求出两个链表的长度，比较麻烦
	 * 
	 * @param headA
	 * @param headB
	 * @return
	 */
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		int lenA = listLength(headA);
		int lenB = listLength(headB);
		if (headA == null || headB == null) {
			return null;
		}
		if (headA.getVal() == headB.getVal()) {
			return headA;
		}
		while (lenA < lenB) {
			headB = headB.getNext();
			lenB--;
		}
		while (lenA > lenB) {
			headA = headA.getNext();
			lenA--;
		}
		while (headA != null && headB != null) {
			if (headA.getVal() == headB.getVal()) {
				return headA;
			}
			headA = headA.getNext();
			headB = headB.getNext();
		}
		return null;
	}

	/**
	 * 第二种解法，在学习别人的解法理解的，只需要一次循环操作，但是实际上是进行了两次循环。 维护两个指针，a和b，a指向第一个链表的开头，b指向第二个
	 * 第一次循环实际上是在完成第一种解法的统一两个链表的长度差，当长度相对短的一个链表遍历到最后一个节点时，节点a会指向长度长的链表的开头，当
	 * 长度相对长的链表遍历到最后一个节点时，指针b指向短链表的开头。此时算第二次循环开始，两个指针会同时遍历到两个链表的结尾
	 * 
	 * @param headA
	 * @param headB
	 * @return
	 */
	public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		ListNode a = headA;
		ListNode b = headB;
		while (a != b) {
			a = a == null ? headB : a.getNext();
			b = b == null ? headA : b.getNext();
		}
		return a;
	}
}
