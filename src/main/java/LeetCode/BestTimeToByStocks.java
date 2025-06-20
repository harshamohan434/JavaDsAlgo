package LeetCode;

public class BestTimeToByStocks {
    public static int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[] free = new int[n], hold = new int[n];

        // In order to hold a stock on day 0, we have no other choice but to buy it for prices[0].
        hold[0] = -prices[0];

        for (int i = 1; i < n; i++) {
            hold[i] = Math.max(hold[i - 1], free[i - 1] - prices[i]);
            free[i] = Math.max(free[i - 1], hold[i - 1] + prices[i] - fee);
        }

        return free[n - 1];
    }

    public static void main(String[] args) {
        int[] prices = new int[]{1,3,2,7,9};
        int fee = 2;
        System.out.println(maxProfit(prices, fee));
    }

}
