class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> res = new HashMap<>();

        for (String str: strs) {
            int[] charCounts = new int[26];

            for (char c: str.toCharArray()) {
                charCounts[c - 'a']++;
            }
            String key = Arrays.toString(charCounts);
            res.putIfAbsent(key, new ArrayList<>());
            res.get(key).add(str);
        }

        return new ArrayList<>(res.values());
    }
}
