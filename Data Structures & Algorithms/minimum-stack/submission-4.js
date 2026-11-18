class MinStack {
    stack;
    minStack;

    constructor() {
        this.stack = [];
        this.minStack = [];
    }

    push(val) {
        const toPush = this.minStack.length === 0 ? val: this.minStack.at(-1) > val ? val : this.minStack.at(-1);
        this.minStack.push(toPush); 
        this.stack.push(val);
    }

    pop() {
        if (this.stack.length > 0) {
            this.stack.pop();
            this.minStack.pop();
        }
        // [2, 0, 3], [2, 0, 0]
    }

    top() {
        return this.stack.at(-1);
    }

    getMin() {
        return this.minStack.at(-1);
    }
}
