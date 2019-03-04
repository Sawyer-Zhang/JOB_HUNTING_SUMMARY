package easy;

/**
 * 
 * @author Zhang shaoyang
 * 
 * @date 2019年2月23日
 */
public class FibonacciNumber {
	public int fib(int n) {
		if (n == 0)
			return 0;
		if (n == 1)
			return 1;
		return fib(n - 1) + fib(n - 2);
	}

	public int fibonacci(int n) {
		int a = 0;
		int b = 1;
		if (n == 0)
			return a;
		if (n == 1)
			return b;
		for (int i = 1; i < n; i++) {
			int sum = a + b;
			a = b;
			b = sum;
		}
		return b;
	}
}
