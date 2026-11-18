class Solution {
    /**
     * @param {number[][]} matrix
     * @return {number[]}
     */
    spiralOrder(matrix) {
        const n = matrix.length;
        const m = matrix[0].length;
        const out = [];
        const seen = Array.from({length: n}, () => Array(m).fill(false));

        // going right, down, left, up
        const dirs = [[0, 1], [1, 0], [0, -1], [-1, 0]];

        const isBlocked = (i, j) => {
            /**
             * Cell is blocked if one of these is true: 
             * 1. It's outside the grid
             * 2. We already visited it.
             */
            return i < 0 || j < 0 || j >= m || i >= n || seen[i][j];
        }

        const dfs = (i, j, d) => {
            /** 
             * Base case - We stop completely when we've collected rows * cols cells, i.e. visited.length = n * m
            */
            out.push(matrix[i][j]);
            seen[i][j] = true;
            if (out.length == n * m) return;

            let [di, dj] = dirs[d];
            if (isBlocked(i + di, j + dj)) {
                // change direction
                d = (d + 1) % 4;
                [di, dj] = dirs[d];
            }
            // this won't be blocked.
            dfs(di + i, dj + j, d);
        }
        dfs(0, 0, 0);
        return out;
    }


}
