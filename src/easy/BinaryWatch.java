package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @description 二进制手表，小时用1/2/4/8四个数字的加和表示，分钟用1/2/4/8/16/32加和表示
 * 
 * @author Zhang shaoyang
 * 
 * @date 2018年12月20日
 */
public class BinaryWatch {
	public List<String> readBinaryWatch(int num) {
		List<String> probTime = new ArrayList<String>();
		for (int hour = 0; hour < 12; hour++) {
			for (int minute = 0; minute < 60; minute++) {
				if (Integer.bitCount(hour) + Integer.bitCount(minute) == num) {
					probTime.add(String.format("%d:%02d", hour, minute));
				}
			}
		}
		return probTime;
	}
}
