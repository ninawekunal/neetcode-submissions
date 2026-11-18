class Solution {
    public int lengthOfLongestSubstring(String s) {
        int longest = Integer.MIN_VALUE;
        if (s.length() == 0) {
            return 0;
        }
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();

        // "zxyzxyz", map: { x:1, y: 1 }, longest = 3
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            
            while(map.containsKey(c)) {
                // needs to be shrunk from the left.
                if (map.merge(s.charAt(left), -1, Integer::sum) == 0) {
                    map.remove(s.charAt(left));
                }
                left++;
            }
            map.merge(c, 1, Integer::sum);
            longest = Math.max(longest, right - left + 1);
            // now window will be valid and the new character can be added safely.
        }
        return longest != Integer.MIN_VALUE ? longest: -1;
    }
}
