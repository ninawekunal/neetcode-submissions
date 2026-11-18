class Solution {
    public boolean hasDuplicate(int[] nums) {
        // [1, 2, 3, 4, 4, 5, 5, 5]
        // Maintain a hashmap and loop through the array once to fill it.
        // While filling it, if I'm incrementing at any point, return true, else false.
        // O(n) time

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            if (map.get(nums[i]) > 1) {
                return true;
            }
        }
        return false;
    }
}