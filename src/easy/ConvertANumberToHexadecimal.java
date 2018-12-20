package easy;

/**
 * 
 * @description 把十进制数字转换为十六进制字符串
 * 
 * @author Zhang shaoyang
 * 
 * @date 2018年12月20日
 */
public class ConvertANumberToHexadecimal {
	public String toHex(int num) {
		if (num == 0)
			return "0";
		char[] map = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
		StringBuilder result = new StringBuilder();
		while (num != 0) {
			result.append(map[num & 15]);
			num = num >>> 4;
		}
		return result.reverse().toString();
	}
}
