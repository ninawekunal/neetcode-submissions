class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        int n = nums.length;
        if (k > n) return new int[]{};
        int[] res = new int[n - k + 1];
        
        int l = 0;
        int r = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        while (r < n) {
            int num = nums[r];
            int winLen = r - l + 1;
            if (!queue.isEmpty() && queue.peekFirst() < l) queue.pollFirst();

            // monotonic deque order 
            while (!queue.isEmpty() && nums[queue.getLast()] < num) queue.removeLast();

            // add r to queue
            queue.addLast(r);
            
            // window equals k
            if (winLen == k) {
                res[l] = nums[queue.peekFirst()];
                l++;
            }
            
            r++;
        }
        return res;
    }
}
