package easy;

import java.util.Scanner;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 * @author Zhang shaoyang
 * 
 * 2018年7月29日
 */
public class LongestCommonPrefix {
	/**
	 *   截取共同的前缀
	 *  开始时出现了两个理解错误的地方
	 * 1、关于subString方法，它截取的是beginIndex到endIndex-1的字符串，代码中prefix.length()-1
	 *  实际上每一次都是舍弃最后一位
	 * 2、因为是查找相同前缀，使用indexOf判断时，不包含返回-1，包含了返回0（从第一位开始）
	 * 这种方法首先是把字符串数组的第一个字符串默认为前缀，和后面的每一个字符串做比对，如果不是，取前n-1位继续比对
	 * @param strs
	 * @return
	 */
	private static String longestCommonPrefix0(String []strs) {
		if (strs.length == 0) {
			return "";
		}
		String prefix = strs[0];
		for (int i = 1; i < strs.length; i++) {
			while(strs[i].indexOf(prefix) != 0) {//不包含该前缀返回-1
				prefix = prefix.substring(0, prefix.length() - 1);//不包含该前缀的情况下，截取前n-1位
				if (prefix.isEmpty()) {
					return "";
				}
			}
		}
		return prefix;
	}
	/**
	 * 第二种方法默认共同前缀只有一位字符，使用第一位字符和每一个字符串的第一位字符相比
	 * 如果第一位字符都相同，那么比对第二位字符...以此类推（比较暴力）
	 * @param strs
	 * @return
	 */
	private static String longestCommonPrefix1(String []strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		for (int i = 0; i < strs[0].length(); i++) {
			char c = strs[0].charAt(i);
			for (int j = 1; j < strs.length; j++) {
				if (strs[j].length() == i || strs[j].charAt(i) != c) {
					return strs[0].substring(0 , i);
				}
			}
		}
		return strs[0];
	}
	/**
	 * 递归
	 * 可以基本理解为将整个字符串数组分为2个一组，进行比较，之后将每一组得到的结果进行比较最后得到结果
	 * @param strs
	 * @return
	 */
	private static String longestCommonPrefix2(String []strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		return longestCommonPrefix2(strs, 0, strs.length - 1);
	}
	private static String longestCommonPrefix2(String []strs , int left , int right) {
		if (left == right) {
			return strs[left];
		}else {
			int mid = (left + right)/2;
			String commonPrefixLeft = longestCommonPrefix2(strs , left , mid);
			String commonPrefixRight = longestCommonPrefix2(strs , mid + 1, right);
			return commonPrefix(commonPrefixLeft , commonPrefixRight);
		}
	}
	private static String commonPrefix(String commonPrefixLeft , String commonPrefixRight) {
		int minLength = Math.min(commonPrefixLeft.length(), commonPrefixRight.length());
		for (int i = 0; i < minLength; i++) {
			if (commonPrefixLeft.charAt(i) != commonPrefixRight.charAt(i)) {
				return commonPrefixLeft.substring(0 , i);
			}
		}
		return commonPrefixLeft.substring(0 , minLength);
	}
	/**
	 * 二分法,将字符串数组中的第一个字符串进行二分，判断前半部分是不是前缀
	 * 如果是，low = middle + 1继续判断
	 * @param strs
	 * @return
	 */
	private static String longestCommonPrefix3(String []strs) {
		if (strs == null || strs.length == 0) {
			return "";
		}
		int minLength = Integer.MAX_VALUE;
		for (int i = 0; i < strs.length; i++) {
			minLength = Math.min(minLength, strs[i].length());
		}
		int low = 1;
		int high = minLength;
		while (low <= high) {
			int middle = (low + high)/2;
			if (isCommonPrefix(strs, middle)) {
				low = middle + 1;
			}else {
				high = middle - 1;
			}
		}
		return strs[0].substring(0, (low + high)/2);
	}
	private static boolean isCommonPrefix(String []strs , int middle) {
		String judgeCommonPrefix = strs[0].substring(0, middle);
		for (int i = 1; i < strs.length; i++) {
			if (!strs[i].startsWith(judgeCommonPrefix)) {
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String strLine = sc.nextLine();
		String []strs = strLine.split(",");
		sc.close();
		System.out.println(longestCommonPrefix0(strs));
		System.out.println(longestCommonPrefix1(strs));
		System.out.println(longestCommonPrefix2(strs));
		System.out.println(longestCommonPrefix3(strs));
	}

}
