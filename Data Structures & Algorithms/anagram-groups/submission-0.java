class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs.length == 1) {
            List<String> anagram = new ArrayList<>();
            anagram.add(strs[0]);
            result.add(anagram);
            return result;
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str: strs) {
            String mapKey = getMapKey(str.toCharArray());
            if (map.containsKey(mapKey)) {
                map.get(mapKey).add(str);
            } else {
                List<String> anagrams = new ArrayList<>();
                anagrams.add(str);
                map.put(mapKey, anagrams);
            }
        }
        // convert map to result output
        for (List<String> value: map.values()) {
            result.add(value);
        }
        return result;
    }

    private String getMapKey(char[] s1) {
        Arrays.sort(s1);
        return String.valueOf(s1);
    }
}
