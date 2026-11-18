class Solution {
    public int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        
        dp[0] = 0;
        // dp[i] -> fewest coins needed to make amount i;
        for (int i = 0; i <= amount; i++) {
            if (i == 0) continue;
            
            int minCoins = amount + 1;
            for (int coin: coins) {
                if (coin > i) continue;
                int total = 1 + dp[i - coin];
                minCoins = Math.min(minCoins, total);
            }
            dp[i] = minCoins;
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
