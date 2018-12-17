package easy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * @description 寻找两个数组的交集
 * 
 * @author Zhang shaoyang
 * 
 * @date 2018年12月16日
 */
public class IntersectionOfTwoArrays {
	public int[] intersection(int[] nums1, int[] nums2) {
		if (nums1.length == 0) {
			return nums1;
		}
		if (nums2.length == 0) {
			return nums2;
		}
		Set<Integer> itemSet = new HashSet<Integer>();
		Set<Integer> intersection = new HashSet<Integer>();
		for (int i = 0; i < nums1.length; i++) {
			itemSet.add(nums1[i]);
		}
		for (int i = 0; i < nums2.length; i++) {
			if (itemSet.contains(nums2[i])) {
				intersection.add(nums2[i]);
			}
		}
		int[] result = new int[intersection.size()];
		int i = 0;
		for (Integer num : intersection) {
			result[i++] = num;
		}
		return result;
	}

	public int[] intersection1(int[] nums1, int[] nums2) {
		Map<Integer, Integer> resultMap = new HashMap<Integer, Integer>();
		List<Integer> resultList = new ArrayList<Integer>();
		for (int i = 0; i < nums1.length; i++) {
			if (resultMap.containsKey(nums1[i])) {
				resultMap.put(nums1[i], resultMap.get(nums1[i]) + 1);
			} else {
				resultMap.put(nums1[i], 1);
			}
		}
		for (int i = 0; i < nums2.length; i++) {
			if (resultMap.containsKey(nums2[i]) && resultMap.get(nums2[i]) > 0) {
				resultList.add(nums2[i]);
				resultMap.put(nums2[i], resultMap.get(nums2[i]) - 1);
			}
		}
		int[] result = new int[resultList.size()];
		int i = 0;
		for (Integer num : resultList) {
			result[i++] = num;
		}
		return result;
	}

	/*
	 * 如果数组是有序的可以用这种方法
	 */
	public int[] intersectionSorted(int[] nums1, int[] nums2) {
		List<Integer> result = new ArrayList<Integer>();
		int i = 0;
		int j = 0;
		while (i < nums1.length && j < nums2.length) {
			if (nums1[i] < nums2[j]) {
				i++;
			} else if (nums1[i] > nums2[j]) {
				j++;
			} else {
				result.add(nums1[i]);
				i++;
				j++;
			}
		}
		int[] resultNum = new int[result.size()];
		int start = 0;
		for (Integer item : result) {
			resultNum[start++] = item;
		}
		return resultNum;
	}

	public static void main(String[] args) {
		IntersectionOfTwoArrays iowa = new IntersectionOfTwoArrays();
		int[] test1 = new int[] { 4, 5, 9 };
		int[] test2 = new int[] { 4, 4, 8, 9, 9 };
		for (int i : iowa.intersectionSorted(test1, test2)) {
			System.out.println(i);
		}
	}

}