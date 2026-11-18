class Solution {
    public int[] productExceptSelf(int[] nums) {
        // product = 48;
        // nums = [1,2,4,6]
        //         - 
        // Output: [48,24,12,8]

        // nums=[-1,0,1,2,3]
        // product = 0
        // products = [0, -6, 0, 0, 0]

        /** 
            prefix = [0, ]
        */

        int num_zeros = 0;
        int product = 1;
        for (int num: nums) {
            if (num == 0) {
                num_zeros++;
            } else {
                product *= num;
            }
        }
        if (num_zeros > 1) {
            Arrays.fill(nums, 0);
            return nums;
        }
        
        int[] result = new int[nums.length];
        if (num_zeros == 0) {
            for (int i=0;i<nums.length;i++) {
                result[i] = product / nums[i];
            }
        } else {
            for (int i=0;i<nums.length;i++) {
                result[i] = nums[i] == 0 ? product:0;
            }
        }

        return result;
    }
}  
