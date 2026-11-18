class Solution {
    public int longestConsecutive(int[] nums) {

        // We will use a Set to remove duplicates and enable O(1) lookup
        // We only care about numbers where the num - 1 doesn't exist -> indicates start of the sequence.
        // Start counting until we see num + 1 doesn't exist
        
        Set<Integer> set = new HashSet<>();
        for (int num: nums) set.add(num);

        int best = 0;
        // [0,3,2,5,4,6,1]
        // current = 1
        // length = 1
        for (int num: set) {
            int current = num;
            int length = 1;
            if (!set.contains(current - 1)) {
                // start of the sequence found
                while (set.contains(current + 1)) {
                    current++;
                    length++;
                }
                best = Math.max(best, length);
            }
        }
        return best;
    }
}
