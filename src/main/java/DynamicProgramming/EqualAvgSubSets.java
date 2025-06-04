package DynamicProgramming;

import java.util.*;

public class EqualAvgSubSets {
    public boolean splitArraySameAverage(int[] nums) {
        int n = nums.length, total = 0;
        for (int num : nums) total += num;

        Arrays.sort(nums);

        // dp[k] = set of all possible sums using k elements
        Set<Integer>[] dp = new Set[n + 1];
        dp[0] = new HashSet<>();
        dp[0].add(0);

        for (int num : nums) {
            for (int k = n - 1; k >= 0; k--) {
                if (dp[k] == null) continue;
                if (dp[k + 1] == null) dp[k + 1] = new HashSet<>();
                for (int s : dp[k]) {
                    dp[k + 1].add(s + num);
                }
            }
        }

        for (int k = 1; k < n; k++) {
            if ((total * k) % n != 0) continue;
            int target = (total * k) / n;
            if (dp[k] != null && dp[k].contains(target)) return true;
        }

        return false;
    }

    public static void main(String[] args) {
        EqualAvgSubSets sol = new EqualAvgSubSets();
        System.out.println(sol.splitArraySameAverage(new int[]{1, 2, 3, 4, 5, 6, 7, 8})); // true
        System.out.println(sol.splitArraySameAverage(new int[]{3, 1})); // false
    }
}
