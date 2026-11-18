class Solution {
    public int characterReplacement(String s, int k) {
        // "XYYX", k = 2 (Can replace at most k characters)


        // Returning the length of the longest substring given a condition: window should have one distinct character.

        // longest one -> Shrink when invalid, then record.

        int longest = Integer.MIN_VALUE;
        int left = 0;
        Map<Character, Integer> map = new HashMap<>();
        /**
            s = "AAABABB", k = 1, longest = 
            map = { A:1,  }
        */

        int maxFreq = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            int freq = map.merge(c, 1, Integer::sum); // gives new frequency for that character.
            maxFreq = Math.max(maxFreq, freq);

            // window:  A A B A B     size 5
            int subs = (right - left + 1) - maxFreq;
            
            while (subs > k) {
                // window is currently invalid due to too many characters in the window, shrink from left and check again.
                // shrink
                if (map.merge(s.charAt(left), -1, Integer::sum) == 0) {
                    map.remove(s.charAt(left));
                }
                
                
                left++;
                subs = (right - left + 1) - maxFreq;
            }
            // then record the length
            longest = Math.max(longest, right - left + 1);
        }


        return longest == Integer.MIN_VALUE ? 0: longest;
    }
}
