class Solution {
    
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dfs(0, dp, n);
        return dp[0];
    }

    private int dfs (int i, int[] dp, int n) {
        // DFS at i tells us no. of ways to reach top (n) starting at stair i
        if (i == n) return 1;
        if (i > n) return 0;
        if (dp[i] != 0) return dp[i];
        dp[i] = dfs (i + 1, dp, n) + dfs (i + 2, dp, n);
        return dp[i];
    }
}
