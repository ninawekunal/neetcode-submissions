class Solution {
    public boolean isValidSudoku(char[][] board) {
        // We'll use keys here for each cell.
        // Make 3 sets for row, column, and box
        // We need to create keys for each cell - one for row, col and box each.
        // If any key isn't able to go in -> not a valid sudoku

        Set<String> seen = new HashSet<>();
        for (int i=0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char value = board[i][j];
                if (value == '.') continue;

                String rowKey = value + " in row " + i;
                String colKey = value + " in col " + j;
                String boxKey = value + " in box " + (i/3) + "-" + (j/3);

                if (!seen.add(rowKey) || !seen.add(colKey) || !seen.add(boxKey)) {
                    return false;
                }
            }
        }
        return true;
    }
}
