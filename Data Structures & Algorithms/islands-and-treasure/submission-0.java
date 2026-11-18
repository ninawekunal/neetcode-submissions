class Solution {
    int[][] dirs = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        Queue<int[]> queue = new LinkedList<>();

        // Seed queue with all zeros
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int x = cell[0];
                int y = cell[1];
                for (int[] dir: dirs) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    boolean bounded = isInBounds(nx, ny, m, n);
                    if (bounded && isValidValue(grid[nx][ny])) {
                        System.out.println("for cell: " + grid[x][y] + ", processing neigh: " + grid[nx][ny]);
                        grid[nx][ny] = Math.min(grid[nx][ny], 1 + grid[x][y]);
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }

    private boolean isInBounds(int x, int y, int m, int n) {
        return x >= 0 && y >= 0 && x < m && y < n;
    }

    private boolean isValidValue(int val) {
        return val == Integer.MAX_VALUE;
    }
}
