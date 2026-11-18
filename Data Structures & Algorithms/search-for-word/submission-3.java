class Solution {
    public boolean exist(char[][] board, String word) {
        
        int rows = board.length;
        int cols = board[0].length;
        if (word.length() > rows * cols) return false;
        
        int k = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(board, word, i, j, k, rows, cols)) return true;
                }
            }
        }
        return false;
    }

    boolean dfs(char[][] board, String word, int i, int j, int k, int r, int c) {
        
        if (k == word.length()) return true;
        if (!isCellValid(i, j, r, c) || board[i][j] != word.charAt(k) || board[i][j]=='#') return false;
        char cell = board[i][j];
        board[i][j] = '#';
        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        boolean res = false;
        for (int[] dir: dirs) { 
            int x = dir[0];
            int y = dir[1];
            int nx = i + x;
            int ny = j + y;

            res = res || dfs(board, word, nx, ny, k + 1, r, c);
        }
        board[i][j] = cell;
        return res;
    }

    boolean isCellValid(int i, int j, int r, int c) {
        return i >= 0 && i < r && j >= 0 && j < c;
    }
}






