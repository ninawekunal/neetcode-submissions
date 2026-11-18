class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;

        Map<Character, Integer> s1Count = new HashMap<>();
        for (char ch: s1.toCharArray()) {
            s1Count.put(ch, s1Count.getOrDefault(ch, 0) + 1);
        }
        int left = 0;
        for (int i = 0; i < s2.length(); i++) {
            char current = s2.charAt(i);
            
            if (s1Count.containsKey(current) && i + s1.length() <= s2.length()) {
                // Start of the window.
                Map<Character, Integer> map2 = new HashMap<>();
                String substring = s2.substring(i, i + s1.length());
                
                for (char ch: substring.toCharArray()) {
                    map2.put(ch, map2.getOrDefault(ch, 0) + 1);
                }
                System.out.println("checking str: " + substring + ", map1: " + s1Count.toString() + ", map2: " + map2.toString());
                if (map2.equals(s1Count)) return true;
            }
        }
        return false;

    }


}
