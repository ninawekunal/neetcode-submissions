class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Input: nums = [1,2,2,3,3,3], k = 2
        // We need to return the top 2 elements in an array who are frequently occurring
        /**
            1. We first need to sort the elements based on their occurrence
            2. Return the top two elements in a 2D array.

            Q. How do we sort the elements?
            -> Max Heap is where the highest value would be on top.

            But if I didn't know max heap, how would I solve it? 

            Map to store the counts?
            But map doesn't allow ordering of elements.

            Since we don't need the original values, 
            perhaps we can modify the first k elements to match the result -> Needs two pointers.

            Q. Do we care about the array being sorted?
            Q. How does negative numbers affect the algo? 
            Q. k could be almost equal to the size of the array.
        */
        if (k == 1 & nums.length == 1) { 
            return new int[]{nums[0]};
        }
        
        /**
            Or we could just fill the map with count of each number.
            Iterating over the map
            {1: 1, 2: 2, 3: 3, 4: 1, 5: 3, 6: 6}
            p1 = 0
            nums = [1,2,2,3,3,3], k = 2
            maxCount = 0;
            maxCount > map.get() && nums[i++] != map.getKey() => 0 > 1? no, so put nums[p1++] = map.getKey()
            maxCount = map.get() -> 1
            [1,2,2,3,3,3,4,5,5,5,6,6,6,6,6,6,6]
        */
        Map<Integer, Integer> map = new HashMap<>();
        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Collections.reverseOrder(Map.Entry.comparingByValue()));
        for (int i = 0; i < k; i++) {
            nums[i] = list.get(i).getKey(); 
        }
        return Arrays.copyOfRange(nums, 0, k);
    }
}
