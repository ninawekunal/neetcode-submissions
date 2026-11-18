class Solution {
    public boolean isValid(String s) {
        // The input string is valid only if every opening bracket is closed with the corresponding closing bracket, in the same order
        /**
            We want to use a map of closing brackets mapped to the corresponding opening bracket
            If we see an opening bracket, just push on the stack
            If we see a closing bracket, get the top of the stack (opening b)
            And check if that matches the opening bracket from the map
            At the end if the stack isn't empty, the string isn't valid
            While going through the string, if we see that the closing brackets don't match, again not valid
        */
        if (s.length() == 1) return false;
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> stack = new Stack();
        for (char c: s.toCharArray()) {
            if (map.containsKey(c)) {
                if (!stack.isEmpty() && stack.peek() == map.get(c)) stack.pop();
                else return false;
            } else {
                // When opening bracket is seen
                stack.push(c);
            }
        }
        return stack.isEmpty() ? true: false;
    }
}
