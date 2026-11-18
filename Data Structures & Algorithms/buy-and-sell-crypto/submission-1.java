class Solution {
    public int maxProfit(int[] prices) {
        int left = 0, right = 1;
        int maxProfit = 0;
        while (right < prices.length) {
            int current = prices[right];
            if (prices[left] < current) {
                int profit = current - prices[left];
                maxProfit = Math.max(maxProfit, profit);
            } else left = right;
            right++;
        }
        return maxProfit;
    }
}
