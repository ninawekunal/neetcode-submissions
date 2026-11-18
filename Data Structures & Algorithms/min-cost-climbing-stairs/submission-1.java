class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];
        dfs(0, dp, cost.length, cost);
        return Math.min(dp[0], dp[1]);
    }

    private int dfs (int i, int[] dp, int n, int[] cost) {
        // DFS(i) tells us the min cost of reaching the top of the staircase starting at index i 
        // bottom up
        if (i >= n) return 0; 

        if (dp[i] != 0) return dp[i];
        dp[i] = cost[i] + Math.min(dfs(i + 1, dp, n, cost), dfs (i + 2, dp, n, cost));
        return dp[i];
    }
}
