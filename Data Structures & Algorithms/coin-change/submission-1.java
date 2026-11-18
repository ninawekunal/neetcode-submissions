class Solution {
    public int coinChange(int[] coins, int amount) {

        if (coins.length == 0) return 0;
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        int remaining = amount;
        dp[0] = 0;
        fewestCoinsForRem(coins, amount, remaining, dp);
        return dp[amount] == Integer.MAX_VALUE || dp[amount] == amount + 1 ? -1: dp[amount];
    }

    int fewestCoinsForRem(int[] coins, int target, int remaining, int[] dp) {
        if (remaining < 0) return target + 1;
        
        if (dp[remaining] != Integer.MAX_VALUE) return dp[remaining];

        int minCoins = target + 1;
        for (int coin: coins) {
            if (coin > remaining) continue;
            int coinsStillNeededAfter = 1 + fewestCoinsForRem(coins, target, remaining - coin, dp);
            minCoins = Math.min(minCoins, coinsStillNeededAfter);
        }
        dp[remaining] = minCoins;
        return minCoins;
    }
}
