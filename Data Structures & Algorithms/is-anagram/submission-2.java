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
        char[] sSorted = s.toCharArray();
        char[] tSorted = t.toCharArray();
        Arrays.sort(sSorted);
        Arrays.sort(tSorted);
        if (Arrays.equals(sSorted, tSorted)) {
            return true;
        }
        return false;
    }
}
