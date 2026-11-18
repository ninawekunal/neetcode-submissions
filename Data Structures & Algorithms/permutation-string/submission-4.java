class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;

        Map<Character, Integer> s1Count = new HashMap<>();
        for (char ch: s1.toCharArray()) {
            s1Count.put(ch, s1Count.getOrDefault(ch, 0) + 1);
        }
        
        Map<Character, Integer> s2Count = new HashMap<>();
        int left = 0;
        for (int i = 0; i < s2.length(); i++) {
            char current = s2.charAt(i);

            s2Count.put(current, s2Count.getOrDefault(current, 0) + 1);
            // System.out.println("map2 is: " + s2Count.toString());
             
            
            if (i - left + 1 > s1.length()) {
                // delete from left
                char leftChar = s2.charAt(left++);
                if (s2Count.get(leftChar) == 1) s2Count.remove(leftChar);
                else {
                    s2Count.put(leftChar, s2Count.get(leftChar) - 1);
                }
                // System.out.println("map now is: " + s2Count.toString());
            }

            if (i - left + 1 == s1.length()) {
                // check if maps are equal
                // System.out.println("map1: " + s1Count.toString() + " map2: " + s2Count.toString());
                if (s1Count.equals(s2Count)) return true;
            }
            
        }
        return false;

    }


}
