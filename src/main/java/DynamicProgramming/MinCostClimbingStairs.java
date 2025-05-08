package DynamicProgramming;



/*

You are given an integer array cost where cost[i] is the cost of ith step on a staircase. Once you pay the cost, you can either climb one or two steps.

You can either start from the step with index 0, or the step with index 1.

Return the minimum cost to reach the top of the floor.



Example 1:

Input: cost = [10,15,20]
Output: 15
Explanation: You will start at index 1.
- Pay 15 and climb two steps to reach the top.
The total cost is 15.
 */

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        int[] cost = new int[]{1,2,3};
        //dynamic prigramming
        MinCostClimbingStairs minCostClimbingStairs = new MinCostClimbingStairs();
        minCostClimbingStairs.minCostDynamicProgramming(cost);

        //Brute force
        minCostClimbingStairs.getMinCost(cost);

    }

    public int minCostDynamicProgramming(int[] cost){
        int n = cost.length;
        return minSum(cost, n-1);
    }

    public int minSum(int[] subCost, int sn){
        if (sn < 0)
            return 0;
        if (sn == 0 || sn == 1)
            return subCost[sn];
        else return subCost[sn-1]+ Math.min(minSum(subCost, sn-1), minSum(subCost, sn-2));
    }

    public int getMinCost(int[] cost){
        int n = cost.length;
        int[] costCalculate = new int[cost.length];
        costCalculate[0] = cost[0];
        costCalculate[1] = cost[1];

        for (int i=2; i < n; i++){
            costCalculate[i] = cost[i]+ Math.min(cost[n-1], cost[n-2]);
        }

        return Math.min(costCalculate[n-1], costCalculate[n-2]);
    }

    
}
