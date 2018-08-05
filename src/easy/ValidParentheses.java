package easy;

import java.util.Scanner;
import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']'
 * determine if the input string is valid.
 * 
 * @author Zhang shaoyang
 * 
 * 2018年7月30日
 */
public class ValidParentheses {
	/**
	 *  使用栈，如果改成switch case方式去完成更好
	 * @param s
	 * @return
	 */
	private boolean isValid(String s) {
		char leftParenthesis = '(';
		char rightParenthesis = ')';
		char leftSquareBracket = '[';
		char rightSquareBracket = ']';
		char leftAngleBracket = '{';
		char rightAngleBracket = '}';
		char []parentheses = s.toCharArray();
		Stack<Character> charStack = new Stack<Character>();
		/* 将括号压入栈中 */
		if ("".equals(s) || s.length()%2 == 1) {
			return false;
		}
		for (int i = 0; i < parentheses.length; i++) {
			if (parentheses[i] == leftParenthesis ||
					parentheses[i] == leftSquareBracket || parentheses[i] == leftAngleBracket) {
				charStack.push(parentheses[i]);
			}else {
				if (charStack.isEmpty()) {
					return false;
				}else if (parentheses[i] == rightParenthesis) {
					if (charStack.isEmpty() || charStack.peek() != leftParenthesis) {
						return false;
					}else {
						charStack.pop();
					}
				}else if (parentheses[i] == rightSquareBracket) {
					if (charStack.isEmpty() || charStack.peek() != leftSquareBracket) {
						return false;
					}else {
						charStack.pop();
					}
				}else if (parentheses[i] == rightAngleBracket) {
					if (charStack.isEmpty() || charStack.peek() != leftAngleBracket) {
						return false;
					}else {
						charStack.pop();
					}
				}
			}
		}
		if (!charStack.isEmpty()) {
			return false;
		}
		return true;
	}
	private boolean isValid1(String s) {
		Stack<Character> charStack = new Stack<Character>();
		for (char c : s.toCharArray()) {
			if (c == '(') {
				charStack.push(')');
			}else if (c == '{') {
				charStack.push('}');
			}else if (c == '[') {
				charStack.push(']');
			}else if (charStack.isEmpty() || charStack.pop() != c) {
				return false;
			}
		}
		return charStack.isEmpty();
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		ValidParentheses vp = new ValidParentheses();
		sc.close();
		System.out.println(vp.isValid1(s));
	}

}
