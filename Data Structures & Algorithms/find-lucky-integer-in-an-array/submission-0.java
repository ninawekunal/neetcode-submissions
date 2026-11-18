class Solution {
    public int findLucky(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num: arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        int lucky = -1;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            int num = entry.getKey();
            int freq = entry.getValue();

            if (freq == num) {
                lucky = Math.max(freq, lucky);
            }
        }
        return lucky;
    }
}