class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 1) return true;
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (!isAlphaNumeric(s.charAt(left))) left++; 
            else if (!isAlphaNumeric(s.charAt(right))) right--;
            else {
                char leftC = Character.toLowerCase(s.charAt(left++));
                char rightC = Character.toLowerCase(s.charAt(right--));
                if (leftC != rightC) return false; 
            }
        }
        return true;
    }

    public boolean isAlphaNumeric(char c) {
        return Character.isDigit(c) || Character.isLetter(c);
    }
}
