class MinStack {

    // [1, 2, 0]
    private Stack<Integer> stack;
    private Stack<Integer> minStack;
    public MinStack() {
        stack = new Stack();
        minStack = new Stack();
    }
    
    public void push(int val) {
        if (!minStack.isEmpty()) {
            int topMin = minStack.peek();
            System.out.println("topMin: " + topMin + " val: " + val);
            minStack.push(Math.min(topMin, val));
        } else minStack.push(val);
        stack.push(val);
    }
    
    public void pop() {
        int val = stack.pop();
        minStack.pop();
    }
    // [0, -1]
    // [0, -1, -1]
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        return minStack.peek();
    }
}
