package easy;

/**
 * 
 * @description 输入：cont = [3, 2, 0, 2] 输出：[13, 4] 解释：原连分数等价于3 + (1 / (2 + (1 /
 *              (0 + 1 / 2))))。注意[26, 8], [-13, -4]都不是正确答案。
 * 
 * 
 * @author Zhang shaoyang
 * 
 * @date 2019年11月11日
 */
public class Fraction {
	public int[] solution(int[] cont) {
		int result[] = new int[] { 1, cont[cont.length - 1] };
		for (int i = cont.length - 2; i >= 0; i--) {
			result[0] += cont[i] * result[1];
			swap(result);
		}
		return swap(result);
	}

	private int[] swap(int[] arr) {
		int temp = arr[0];
		arr[0] = arr[1];
		arr[1] = temp;
		return arr;
	}
}
