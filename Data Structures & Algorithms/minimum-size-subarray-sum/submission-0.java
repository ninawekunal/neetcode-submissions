class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // shortest length of the subarray matching a condition.
        // cond: subArray sum >= target -> window valid then.
        // For shortest sum, we record first and then shrink.

        int shortest = Integer.MAX_VALUE;
        int left = 0;
        int sum = 0;
        //             l     r 
        // nums = [2,1,5,1,5,3]
        // sum = 9, shortest = 3. Target = 10.
        for (int right = 0; right < nums.length; right++){ 
            sum += nums[right];
            while (sum >= target) {
                // window is valid, can we find something shorter? 
                // Record first then shrink window.
                shortest = Math.min(shortest, right - left + 1);
                sum -= nums[left++];
            }
        }

        return shortest == Integer.MAX_VALUE ? 0: shortest;
    }
}