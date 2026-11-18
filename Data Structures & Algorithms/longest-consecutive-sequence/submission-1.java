class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num: nums) set.add(num);

        int maxCount = 0;
        for (int num: nums) {
            // start of a sequence
            if (!set.contains(num - 1)) {
                // start counting
                int count = 1;
                int number = num;
                while(set.contains(number + 1)) {
                    number = number + 1;
                    count++;
                }
                // end of of a sequence
                maxCount = Math.max(maxCount, count);
            }
        }
        return maxCount;
    }
}
