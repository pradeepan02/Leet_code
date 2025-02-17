public class Solution {

    // maxProfit method to calculate the maximum profit
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) return 0;

        // b0: buy on day 0, b1: buy on any subsequent day
        int b0 = -prices[0], b1 = b0;
        int s0 = 0, s1 = 0, s2 = 0;
        
        for (int i = 1; i < prices.length; i++) {
            b0 = Math.max(b1, s2 - prices[i]);  // either keep the previous buy state, or buy on current day
            s0 = Math.max(s1, b1 + prices[i]);  // either keep the previous sell state, or sell on current day
            b1 = b0;  // update b1 for the next iteration
            s2 = s1;  // update s2 for the next iteration
            s1 = s0;  // update s1 for the next iteration
        }

        return s0;  // final result is the best profit after selling
    }
}
