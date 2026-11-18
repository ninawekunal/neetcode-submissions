class Solution {

    private char[][] board;
    private String word;
    private int rows, cols;

    public boolean exist(char[][] board, String word) {
        
        int rows = board.length;
        int cols = board[0].length;
        if (word.length() > rows * cols) return false;

        this.board = board;
        this.word = word;
        this.rows = rows;
        this.cols = cols;
        
        int k = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(i, j, k)) return true;
                }
            }
        }
        return false;
    }

    static final int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    boolean dfs(int i, int j, int k) {
        
        if (k == word.length()) return true;
        if (!isCellValid(i, j) || this.board[i][j] != this.word.charAt(k) || this.board[i][j]=='#') return false;
        char cell = this.board[i][j];
        this.board[i][j] = '#';
        
        boolean res = false;
        for (int[] dir: this.dirs) { 
            int x = dir[0];
            int y = dir[1];
            int nx = i + x;
            int ny = j + y;

            res = res || dfs(nx, ny, k + 1);
        }
        this.board[i][j] = cell;
        return res;
    }

    boolean isCellValid(int i, int j) {
        return i >= 0 && i < this.rows && j >= 0 && j < this.cols;
    }
}






