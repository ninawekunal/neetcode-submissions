class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        // We want to first find the row number to search in.
        int start = 0, end = matrix.length;
        while (start < end) {
            int mid = start + (end - start)/2;
            if (matrix[mid][0] >= target) end = mid;
            else start = mid + 1;
        }
        System.out.println("start is: " + start);
        // start -> either the row where the target is present or where matrix[row][0] <= target
        // Then apply binary search to this row and the preceeding row
        // loop breaks when start == end or start > end
        if (start == matrix.length && matrix.length != 0) start -= 1;  
        int left = 0, right = matrix[start].length - 1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (matrix[start][mid] == target) return true;
            else if (matrix[start][mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        // If we still didn't find it here, search in the preceeding row and then conclude
        if (start == 0) return false; // no prceeding row to check
        left = 0;
        right = matrix[start].length - 1;
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (matrix[start - 1][mid] == target) return true;
            else if (matrix[start - 1][mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return false;
    }
}
