package easy;
/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) 
 * which has the largest sum and return its sum.
 * 
 * @author Zhang shaoyang
 * 
 * 2018年8月15日
 */
public class MaximumSubarray {
	/**
	 * 第一种解法是使用了动态规划的方法来实现，本身我是不会动态规划这种解法的，根据讲解
	 * 才能写出代码，后续这种问题可能会比较多，而且一定会用得到，所以有时间学习一下
	 * 
	 * @param nums
	 * @return
	 */
	public int maxSubarray(int []nums) {
		int len = nums.length;
        int []dp = new int[len];
        dp[0] = nums[0];
        int max = dp[0];
        for(int i=1;i<len;i++){
            dp[i] = nums[i] + (dp[i-1]>0?dp[i-1]:0);
            max=Math.max(max,dp[i]);
        }
        return max;
	}
	/**
	 * 第二种方法是使用分治法
	 * 
	 * @param nums
	 * @return
	 */
	public int maxSubArray(int []nums) {
		if(nums.length==0 || nums == null){
            return 0;
        }
        return maxSubArray(nums, 0, nums.length-1);
    }
    private int maxSubArray(int []nums,int left, int right){
        if(left > right) return Integer.MIN_VALUE;
        if(left == right) return nums[left];
        int mid = (left + right)/2;
        int leftResult = maxSubArray(nums, left, mid-1);
        int rightResult = maxSubArray(nums, mid+1, right);
        int leftSum = 0;
        int temp = 0;
        for(int i=mid-1;i>=left;i--){
            temp+=nums[i];
            if(temp>leftSum) leftSum=temp;
        }
        int rightSum=0;
        temp=0;
        for(int i=mid+1;i<=right;i++){
            temp+=nums[i];
            if(temp>rightSum)rightSum=temp;
        }
        return Math.max(Math.max(leftResult,rightResult),leftSum+rightSum+nums[mid]);
    }
}
