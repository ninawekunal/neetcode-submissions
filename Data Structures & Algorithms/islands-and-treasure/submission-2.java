class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> queue = new ArrayDeque<>();

        // Fill queue with all the starting positions (land cells)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                    // marking them visited?
                }
            }
        }

        if (queue.isEmpty()) return;


        int dist = 0;
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int x = cell[0];
            int y = cell[1];
            for (int[] d: dirs) {
                int dx = x + d[0];
                int dy = y + d[1];
                if (!isValid(dx, dy, grid) || grid[dx][dy] != Integer.MAX_VALUE) continue;
                queue.add(new int[] {dx, dy});
                grid[dx][dy] = grid[x][y] + 1;
            }
        }

    }
    private boolean isValid(int i, int j, int[][] grid) {
        return (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length);
    }
}
