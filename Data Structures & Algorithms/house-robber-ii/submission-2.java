class Solution {
    public int rob(int[] nums) {

        if (nums.length == 1) return nums[0];
        
        Map<Integer, Integer> memo = new HashMap<>();

        int skipFirst = robHousesBetween(nums, 1, nums.length -1, memo);
        memo.clear();
        int skipLast = robHousesBetween(nums, 0, nums.length - 2, memo);
        return Math.max(skipFirst, skipLast);
    }

    int robHousesBetween(int[] nums, int i, int end, Map<Integer, Integer> memo) {
        if (memo.containsKey(i)) return memo.get(i);
        if (i > end) return 0;
        
        int take = nums[i] + robHousesBetween(nums, i+2, end, memo);
        int skip = robHousesBetween(nums, i+1, end, memo);
        int res = Math.max(take, skip); 
        memo.put(i, res);
        return res;
    }
}
