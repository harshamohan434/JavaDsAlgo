package DynamicProgramming;

import java.util.Collections;
import java.util.List;
/*

Given a triangle array, return the minimum path sum from top to bottom.

For each step, you may move to an adjacent number of the row below. More formally, if you are on index i on the current row, you may move to either index i or index i + 1 on the next row.



Example 1:

Input: triangle = [[2],[3,4],[6,5,7],[4,1,8,3]]
Output: 11
Explanation: The triangle looks like:
   2
  3 4
 6 5 7
4 1 8 3
The minimum path sum from top to bottom is 2 + 3 + 5 + 1 = 11 (underlined above).

 */

public class MinTrianglePath {
    public int minimumTotal(List<List<Integer>> triangle) {

        for (int row=1; row< triangle.size(); row++){
            for (int col = 0 ; col < row+1; col++){
                int smallest_above = Integer.MAX_VALUE;
                if (col > 0){
                    smallest_above = triangle.get(row-1).get(col-1);
                }
                if (col < row){
                    smallest_above = Math.min(smallest_above,
                            triangle.get(row-1).get(col));
                }

                int current_small = smallest_above + triangle.get(row).get(col);
                triangle.get(row).set(col, current_small);
            }
        }

        return Collections.min(triangle.get(triangle.size()-1));

    }
}
