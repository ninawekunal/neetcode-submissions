class Solution {
    public int search(int[] nums, int target) {
        // Binary Search
        // We can choose to divide the array in half on each search try
        // Use two pointers, one from start, one from end

        int start = 0, end = nums.length - 1;
        
        while (start <= end) {
            int mid = (start + end)/2;
            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) {
                // Search in the right half, since mid is too small
                start = mid + 1;
            } else {
                // Search in the left half, since mid is too large
                end = mid - 1;
            }
        }
        return -1;
    }
}
