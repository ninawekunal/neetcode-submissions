class Solution {
    public int numEnclaves(int[][] grid) {
        
        int rows = grid.length, cols = grid[0].length;
        int totalLands = 0;
        int borderLands = 0;
        Set<String> seen = new HashSet<>();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                totalLands += grid[i][j];
                String cell = i + "," + j;
                if (isCellOnBorder(i, j, rows, cols) && !seen.contains(cell) && grid[i][j] == 1) {
                    borderLands += dfs(grid, i, j, seen, rows, cols);
                }
            }
        }
        return totalLands - borderLands;
    }

    int dfs (int[][] grid, int i, int j, Set<String> seen, int m, int n) {
        // dfs (i, j) gives us the total count of land cells starting at that node (i, j)
        // Base case
        String cell = i + "," + j;
        if (!isCellValid(i, j, m, n, grid) || seen.contains(cell)) {
            return 0;
        }
        seen.add(cell);

        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        int total = 1;
        for (int[] dir: dirs) {
            int x = dir[0];
            int y = dir[1];

            int nx = x + i;
            int ny = y + j;

            total+= dfs(grid, nx, ny, seen, m, n);
        }
        return total;
    }

    boolean isCellOnBorder(int i, int j, int m, int n) {
        boolean val = i == 0 || j == 0 || i == m - 1 || j == n - 1;
        return val;
    }

    boolean isCellValid(int i, int j, int m, int n, int[][] grid) {
        return i >= 0 && i < m && j >= 0 && j < n && grid[i][j] == 1;
    }
}