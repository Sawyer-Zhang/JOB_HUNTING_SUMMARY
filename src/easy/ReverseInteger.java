package easy;

import java.util.Scanner;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 * @author Zhang shaoyang
 * 
 * 2018年7月28日
 */
public class ReverseInteger {
	public static int reverse(int x) {
		int rev = 0;
		while(x != 0) {
			int begin = x % 10;//个位数
			x = x / 10;
			if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && begin > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && begin < -8)) return 0;
			rev = rev * 10 + begin;
		}
		return rev;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		sc.close();
		int result = reverse(a);
		System.out.println(result);
	}
}
