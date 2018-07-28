package easy;

import java.util.Scanner;

/**
 * Determine whether an integer is a palindrome. 
 * An integer is a palindrome when it reads the same backward as forward.
 * @author Zhang shaoyang
 * 
 * 2018年7月28日
 */
public class PalindromeNumber {
	public static boolean isPalidrome(int x) {
		int reverse = 0;
		int temp = x;
		while(temp != 0) {
			int begin = temp % 10;//个位数
			temp = temp / 10;
			if (reverse > Integer.MAX_VALUE/10 || (reverse == Integer.MAX_VALUE / 10 && begin > 7)) return false;
            if (reverse < Integer.MIN_VALUE/10 || (reverse == Integer.MIN_VALUE / 10 && begin < -8)) return false;
			reverse = reverse * 10 + begin;
		}
		if(reverse != x || x < 0) {
			return false;
		}else {
			return true;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		sc.close();
		System.out.println(isPalidrome(a));
	}
}
