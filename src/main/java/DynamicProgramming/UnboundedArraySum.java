package DynamicProgramming;

import java.util.Arrays;

import static DynamicProgramming.UnboundedArraySum.minSubsetToSumK;

public class UnboundedArraySum {
    public static void main(String[] args) {
        int[] nums = {2, 3, 5, 11};
        int k = 9;
        System.out.println(minSubsetToSumK(nums, k));  // Output: 2 (e.g. 3 + 6 or 5 + 4)
    }

    static int minSubsetToSumK(int[] nums, int k){

        int[] dp = new int[k+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int num : nums){
            for (int i=num;i<=k;i++){
                if (dp[i-num] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - num] + 1);
                }
            }
        }

        return dp[k] == Integer.MAX_VALUE ? 0 : dp[k];
    }
}
