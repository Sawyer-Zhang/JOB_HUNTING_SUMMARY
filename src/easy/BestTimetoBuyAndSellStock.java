package easy;

/**
 * Say you have an array for which the ith element is the price of a given stock
 * on day i.
 * 
 * If you were only permitted to complete at most one transaction (i.e., buy one
 * and sell one share of the stock), design an algorithm to find the maximum
 * profit.
 * 
 * @author Zhang shaoyang
 * 
 *         2018年9月24日
 */
public class BestTimetoBuyAndSellStock {
	/**
	 * 比较简答的一道题，将下一道题的答案也放在这里，因为没有什么难度
	 * 
	 * @param prices
	 * @return
	 */
	public int maxProfit(int[] prices) {
		if (prices.length == 0 || prices == null) {
			return 0;
		}
		int max = 0;
		int premin = prices[0];
		for (int i = 0; i < prices.length; i++) {
			if (prices[i] > premin) {
				max = Math.max(max, prices[i] - premin);
			} else {
				premin = prices[i];
			}
		}
		return max;
	}

	/**
	 * 122. Best Time to Buy and Sell Stock II
	 * 
	 * @param prices
	 * @return
	 */
	public int maxProfit1(int[] prices) {
		if (prices.length == 0 || prices == null) {
			return 0;
		}
		int max = 0;
		for (int i = 0; i < prices.length - 1; i++) {
			if (prices[i + 1] > prices[i]) {
				max = max + (prices[i + 1] - prices[i]);
			}
		}
		return max;
	}
}
