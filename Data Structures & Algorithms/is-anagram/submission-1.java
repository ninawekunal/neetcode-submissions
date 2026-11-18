class Solution {
    public boolean isAnagram(String s, String t) {
        // Anagram - a string a is an anagram of b, if a contains exact same characters as string b.
        // Should each character's occurence in s = t? Let's assume, yes
        if (s.length() != t.length()) {
            return false;
        }
        if (s.equals(t)) {
            return true;
        }
        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();
        // O(n) time to traverse s, and we can traverse t at the same time too I guess? 
        // 1. Build 2 maps for each string, and tally the count for each character.
        // Traversal would be O(n), and O(n) again for map traversal
        
        for (int i = 0; i < s.length(); i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
            tMap.put(t.charAt(i), tMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        for (Map.Entry<Character, Integer> entry : sMap.entrySet()) {
            char key = entry.getKey();
            int value = entry.getValue();
            if (value != tMap.getOrDefault(key, 0)) {
                return false;
            }
        }
        return true;
    }
}
