class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        Deque<Integer> queue = new ArrayDeque<>();
        int n = nums.length;
        int[] result = new int[n - k + 1];
        int i = 0;
        for (int r = 0; r < nums.length; r++) {
            // 1. Expire old - index at first <= r - k
            if (!queue.isEmpty() && queue.peekFirst() <= r -k) {
                queue.pollFirst();
            }

            // 2. clean small values at top
            while (!queue.isEmpty() && nums[r] > nums[queue.peekLast()]) {
                queue.pollLast();
            }

            // 3. Add new
            queue.offerLast(r);

            // 4. If window is full -> record answer for this window
            if (r >= k - 1) {
                result[i++] = nums[queue.peekFirst()];
            }
            
        }
        return result;
    }
}
