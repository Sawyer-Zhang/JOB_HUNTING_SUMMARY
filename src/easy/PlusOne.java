package easy;
/**
 * 几道简单题
 * @author Zhang shaoyang
 * 
 * 2018年8月16日
 */
public class PlusOne {
	/**
	 * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
	 * The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.
	 * You may assume the integer does not contain any leading zero, except the number 0 itself.
	 * 
	 * @param digits
	 * @return
	 */
	public int[] plusOne(int []digits) {
		int n = digits.length;
		for (int i = n - 1; i > 0; i--) {
			if (digits[i] < 9) {
				digits[i]++;
				return digits;
			}
			digits[i] = 0;
		}
		int []result = new int[n+1];
		result[0] = 1;
		return result;
	}
	/**
	 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
	 * If the last word does not exist, return 0.
	 * 
	 * @param s
	 * @return
	 */
	public int lengthOfLastWord(String s) {
        s = s.trim();
        int lastIndex = s.lastIndexOf(" ");
        return s.length()-lastIndex-1;
    }
	/**
	 * 开根号取整数位
	 * @param x
	 * @return
	 */
	public int mySqrt(int x) {
        if(x==0)return 0;
        if(x==1)return 1;
        long i = x;
        while(i*i>x){
            i = (i + x/i)/2;
        }
        return (int)i;
    }
	/**
	 * 斐波那契数列非递归
	 * @param n
	 * @return
	 */
	public int climbStairs(int n) {
        int []result = new int[n+1];
        for(int i = 0; i<=n ; i++){
            if(i < 3){
                result[i] = i;
                continue;
            }
            result[i] = result[i-1] + result[i-2];
        }
        return result[n];
    }
}
