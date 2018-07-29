package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * Symbol       Value
	I             1
	V             5
	X             10
	L             50
	C             100
	D             500
	M             1000
 * Given a roman numeral, convert it to an integer. 
 * Input is guaranteed to be within the range from 1 to 3999.
 * @author Zhang shaoyang
 * 
 * 2018年7月29日
 */
public class RomanToInteger {
	private static int romanToInt(String s) {
		Map<Character, Integer> map = assembleNumber();
		int count = 0;//最终结果
		for(int i = 0; i < s.length() ; i++) {
			int a = map.get(s.charAt(i));
			if (i == s.length() - 1) {
				count = count + a;
				break;
			}
			int b = map.get(s.charAt(i + 1));
			if (a > b || a == b) {
				count = count + a;
			}else {
				count = count - a;
			}
		}
		return count;
	
	}
	private static Map<Character, Integer> assembleNumber() {
		Map<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);
		return map;
	}
	public static void main(String[] args) {
		System.out.println(romanToInt("LVIII"));
	}
}
