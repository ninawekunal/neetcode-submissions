class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Hashmaps here
        Map<Integer, Integer> map = new HashMap<>();
        // We will traverse the array two times, one from left, one from right.
        // What will we store in hashmap? 
        // [-1, -2, -3, 5], target = 3
        // { -1: 0, -2: 1, -3: 2, 5: 3} -> {element: index}
        // [ 4, 5, 6, -2]
        // traverse the array, and compute this -> target - nums[j]
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int j = 0; j < nums.length; j++) {
            int complement = target - nums[j];
            if (map.containsKey(complement) && map.get(complement) != j) {
                result[0] = j;
                result[1] = map.get(complement);
                Arrays.sort(result);
                return result;
            }
        }
        return new int[] {};
    }
}
