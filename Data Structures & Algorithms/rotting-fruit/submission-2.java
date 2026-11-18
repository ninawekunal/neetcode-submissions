class Solution {
    int[][] dirs = new int[][] {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    public int orangesRotting(int[][] grid) {
        // Multi source BFS
        
        int fresh = 0;
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) fresh++;
                else if (grid[i][j] == 2) queue.offer(new int[]{i, j});
            }
        }
        if (fresh == 0) return 0;

        int time = 0;
        while (!queue.isEmpty() && fresh > 0) {
            int size = queue.size(); // no of rotting oranges at this level
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                int x = cell[0];
                int y = cell[1];
                for (int[] dir: dirs) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];
                    if (isInBound(nx, ny, grid.length, grid[0].length) && grid[nx][ny] == 1) {
                        fresh--;
                        grid[nx][ny] = 2;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
            time++;
        }
        return fresh > 0 ? -1: time;
    }

    private boolean isInBound (int x, int y, int n, int m) {
        boolean bounded = x >= 0 && y >= 0 && x < n && y < m;
        return bounded;
    }
}
