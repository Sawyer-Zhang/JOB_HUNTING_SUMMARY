package easy;

/**
 * 
 * @description 字符串格式判断问题
 * 
 * @author Zhang shaoyang
 * 
 * @date 2019年2月26日
 */
public class DetectCapital {
	public boolean detectCapitalUse(String word) {
		/**
		 * 全小写、全大写、第一位是大写，后面是小写
		 */
		return word.equals(word.toLowerCase()) || word.equals(word.toUpperCase())
				|| Character.isUpperCase(word.charAt(0)) && word.substring(1).equals(word.substring(1).toLowerCase());
	}
}
