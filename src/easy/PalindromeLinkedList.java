package easy;

import util.ListNode;

/**
 * 
 * @description Input: 1->2 Output: false
 * 
 *              Input: 1->2->2->1 Output: true
 * 
 * @author Zhang shaoyang
 * 
 * @date 2018年12月6日
 */
public class PalindromeLinkedList {
	public boolean isPalindrome(ListNode head) {
		ListNode fast = head;
		ListNode slow = head;
		while(fast != null && fast.getNext() != null) {
			slow = slow.getNext();
			fast = fast.getNext().getNext();
		}
		/*
		 * 如果是偶数个结点，那么当完成上面的遍历之后，slow指针指向的是前半部分的最后一个，而不是后半部分的第一个
		 */
		if(fast != null) {
			slow = slow.getNext();
		}
		slow = reverse(slow);
		fast = head;
		while(slow != null) {
			if(slow.getVal() != fast.getVal()) {
				return false;
			}else {
				slow = slow.getNext();
				fast = fast.getNext();
			}
		}
		return true;
	}
	private ListNode reverse(ListNode head) {
		ListNode prev = null;
		while(head != null) {
			ListNode next = head.getNext();
			head.setNext(prev);
			prev = head;
			head = next;
		}
		return prev;
	}
}
