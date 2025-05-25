package SlidingWIndows;

public class LongestSubArray {
    public int longestSubarray(int[] nums) {
        int zeros = 0,start=0, longestWindowLength = 0;

        for(int i = 0; i< nums.length;i++){
            if (nums[i] == 0) {
                zeros++;
            }

            while (zeros > 1) {
                if (nums[start] == 0) {
                    zeros --;
                }
                start++;
            }

            longestWindowLength = Math.max(longestWindowLength, i-start);
        }

        return longestWindowLength;

    }
}
