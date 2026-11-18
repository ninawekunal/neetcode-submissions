class Solution {
    uniquePaths(m: number, n: number, memo={}): number {
        const key = m + "," + n;
        if (key in memo) return memo[key];
        if (m === 1 && n === 1) return 1;
        if (m < 1 || n < 1) return 0;
        memo[key] = this.uniquePaths(m - 1, n, memo) + this.uniquePaths(m, n - 1, memo);
        return memo[key]; 
    }
}
