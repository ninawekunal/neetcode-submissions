class Solution {
    public int longestOnes(int[] nums, int k) {
        int longestOnes = 0;
        
        int left = 0;
        int numZerosInWindow = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) numZerosInWindow++;

            while (numZerosInWindow > k) {
                
                if (nums[left] == 0) numZerosInWindow--;
                left++;
            }
            longestOnes = Math.max(longestOnes, i - left + 1);
        }

        return longestOnes;
    }
}