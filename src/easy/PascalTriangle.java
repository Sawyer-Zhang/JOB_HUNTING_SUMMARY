package easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-negative integer numRows, generate the first numRows of Pascal's
 * triangle
 * 
 * @author Zhang shaoyang
 * 
 *         2018年9月24日
 */
public class PascalTriangle {
	public List<List<Integer>> generate(int numRows) {
		List<List<Integer>> triangle = new ArrayList<List<Integer>>();
		for (int i = 0; i < numRows; i++) {
			List<Integer> row = new ArrayList<Integer>();
			row.add(1);
			for (int j = 1; j < i; j++) {
				List<Integer> lastRow = triangle.get(i - 1);
				int num = lastRow.get(j) + lastRow.get(j - 1);
				row.add(num);
			}
			if (i == 0) {
				triangle.add(row);
				continue;
			}
			row.add(1);
			triangle.add(row);
		}
		return triangle;
	}
}
