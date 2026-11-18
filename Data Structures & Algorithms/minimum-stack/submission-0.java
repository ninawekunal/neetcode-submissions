class MinStack {

    // [1, 2, 0]
    private Stack<Integer> stack;
    private PriorityQueue<Integer> minHeap;
    public MinStack() {
        stack = new Stack();
    }
    
    public void push(int val) {
        stack.push(val);
    }
    
    public void pop() {
        stack.pop();
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int getMin() {
        minHeap = new PriorityQueue(stack);
        return minHeap.peek();
    }
}
