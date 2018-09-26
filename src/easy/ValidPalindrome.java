package easy;

/**
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * @author Zhang shaoyang
 * 
 *         2018年9月25日
 */
public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		if (s.isEmpty()) {
			return true;
		}
		int head = 0;
		int tail = s.length() - 1;
		char chead;
		char ctail;
		while (head <= tail) {
			chead = s.charAt(head);
			ctail = s.charAt(tail);
			if (!Character.isLetterOrDigit(chead)) {
				head++;
			} else if (!Character.isLetterOrDigit(ctail)) {
				tail--;
			} else {
				if (Character.toLowerCase(chead) != Character.toLowerCase(ctail)) {
					return false;
				}
				head++;
				tail--;
			}
		}
		return true;
	}

	public boolean isPalindrome1(String s) {
		String actual = s.replaceAll("[^A-Za-z0-9]", "");
		String reverse = new StringBuffer(actual).reverse().toString().toLowerCase();
		return actual.toLowerCase().equals(reverse);
	}
}
