package easy;

import java.util.HashSet;
import java.util.Set;

/**
 * Input: [1,2,3,1] Output: true Input: [1,2,3,4] Output: false
 * 
 * @author Zhang shaoyang
 * 
 *         2018年12月2日
 */
public class ContainsDuplicate {
    public boolean containsDuplicate(int[] nums) {
        if(nums.length == 0) return false;
        Set<Integer> resultSet = new HashSet<Integer>();
        for(int i : nums) {
        	if(!resultSet.add(i)) {
        		return true; 
        	}
        }
        return false;
    }
}
