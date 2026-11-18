class Solution {
    public int evalRPN(String[] tokens) {
        // tokens = ["1","2","+","3","*","4","-"]
        // stack = [9, 4], sum = 3; product = 9; sum = ;
        // If numbers, then push to stack
        // If operand, keep popping from stack
        // push result back to stack and proceed
        // We need to ensure that stack needs to always have two elements.
        // Q. What happens if stack only has 1 element?
        // I want to have FIFO, LinkedList.

        Stack<Integer> stack = new Stack();
        for (String token: tokens) {
            if (token.equals("+")) {
                stack.push(stack.pop() + stack.pop());
            } else if (token.equals("*")) {
                stack.push(stack.pop() * stack.pop());
            } else if (token.equals("/")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a/b);
            } else if (token.equals("-")) {
                int b = stack.pop();
                int a = stack.pop();
                stack.push(a-b);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
