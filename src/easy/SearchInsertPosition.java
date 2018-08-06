package easy;
/**
 * Given a sorted array and a target value, return the index if the target is found. 
 * If not, return the index where it would be if it were inserted in order.
 * @author Zhang shaoyang
 * 
 * 2018年8月5日
 */
public class SearchInsertPosition {
	private int searchInsert(int nums[], int target) {
		int index = 0;
        if(target <= nums[0]){
            return index;
        }
        for(int i = 0;i<nums.length;i++){
            index++;
            if(i == nums.length -1){
                return nums.length;
            }
            if(nums[i] < target &&  nums[i+1] >= target){
                return index;
            }
        }
        return index;
	}
	public static void main(String[] args) {
		int nums[] = {1,3,5,6,7};
		SearchInsertPosition sip = new SearchInsertPosition();
		int result = sip.searchInsert(nums, 0);
		System.out.println(result);
	}

}
