class Solution {
    public int rob(int[] nums) {
        Map<Integer, Integer> memo = new HashMap();
        return robHouse(nums, 0, memo);
    }
    
    int robHouse(int[] nums, int i, Map<Integer, Integer> memo) {
        if (memo.containsKey(i)) return memo.get(i);
        if (i >= nums.length) return 0;

        int robSecond = robHouse(nums, i + 1, memo);
        int robThird = robHouse(nums, i + 2, memo);
        int robCurrent = Math.max(nums[i] + robThird, robSecond);
        memo.put(i, robCurrent);
        return robCurrent;
    }
}
