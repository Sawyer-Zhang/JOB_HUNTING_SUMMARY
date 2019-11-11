package easy;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @description 寻找一个数组中两个数i < j 且有 (time[i] + time[j]) % 60 == 0共有多少对
 * 
 * @author Zhang shaoyang
 * 
 * @date 2019年11月10日
 */
public class NumPairsDivisibleBy60 {
	/**
	 * 使用一个map用空间换取时间
	 * @param time
	 * @return
	 */
	public int solution(int[] time) {
		int result = 0;
		int len = time.length;
		Map<Integer, Integer> divisibleResult = new HashMap<Integer, Integer>();
		for (int i = 0; i < len; i++) {
			time[i] = time[i] % 60;
		}
		for (int i = 0; i < len; i++) {
			result += divisibleResult.getOrDefault(((60 - time[i]) % 60), 0);
			divisibleResult.put(time[i], divisibleResult.getOrDefault(time[i], 0) + 1);
		}
		return result;
	}

	/**
	 * 双重循环可解，但是超时了
	 * @param time
	 * @return
	 */
	public int solution1(int[] time) {
		int result = 0;
		for (int i = 0; i < time.length; i++) {
			for (int j = i + 1; j < time.length; j++) {
				result += (time[i] + time[j]) % 60 == 0 ? 1 : 0;
			}
		}
		return result;
	}
}
