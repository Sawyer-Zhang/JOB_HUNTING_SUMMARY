package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Given a non-negative index k where k ≤ 33, return the kth index row of the
 * Pascal's triangle.
 * 
 * Note that the row index starts from 0.
 * 
 * @author Zhang shaoyang
 * 
 *         2018年9月24日
 */
public class PascalTriangle2 {
	/**
	 * 之前写的一种比较啰嗦的解法
	 * 
	 * @param rowIndex
	 * @return
	 */
	public List<Integer> getRow1(int rowIndex) {
        List<Integer> resultRow = new ArrayList<Integer>();
        List<Integer> tempRow = new ArrayList<Integer>();
        for(int i = 0 ; i <= rowIndex ; i++){
            tempRow.add(1);
            for(int j = 1 ; j < i ; j++){
                int nextNum = resultRow.get(j) + resultRow.get(j - 1);
                tempRow.add(nextNum);
            }
            if(i == 0){
                resultRow.addAll(tempRow);
                tempRow.clear();
                continue;
            }
            tempRow.add(1);
            resultRow.clear();
            resultRow.addAll(tempRow);
            tempRow.clear();
        }
        return resultRow;
    }
	/**
	 * 最开始想解法的时候没能理解，想arraylist中添加元素的时候
	 * 后面的元素会依次后移（当然在写业务代码的时候不推荐，会造成额外的操作）
	 * 
	 * @param rowIndex
	 * @return
	 */
	public List<Integer> getRow(int rowIndex) {
		List<Integer> resultRow = new ArrayList<Integer>();
		for (int i = 0; i <= rowIndex; i++) {
			resultRow.add(0, 1);
			for (int j = 1; j < resultRow.size() - 1; j++) {
				resultRow.set(j, resultRow.get(j) + resultRow.get(j + 1));
			}
		}
		return resultRow;
	}  
}
