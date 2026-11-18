class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (p.length() > s.length()) return res;
        int[] pCount = new int[26];
        
        for (char pChar: p.toCharArray()) {
            pCount[pChar - 'a']++;
        }
        String toFind = Arrays.toString(pCount);

        int[] sCount = new int[26];
        int l = 0;
        int r = 0;
        while (r < s.length()) {
            char ch = s.charAt(r);
            int len = r - l + 1;
            sCount[ch - 'a']++;
            if (len == p.length()) {
                String curr = Arrays.toString(sCount);
                if (curr.equals(toFind)) res.add(l);
                sCount[s.charAt(l) - 'a']--;
                l++;
            }
            r++;
        }
        return res;
    }
}
