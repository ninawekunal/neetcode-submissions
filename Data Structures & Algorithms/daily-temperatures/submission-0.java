class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // temperatures = [30,38,30,36,35,40,28]
        //                [ 0, 1, 2, 3, 4, 5, 6]   
        // res = [], stack = [0]
        // temp[i] = 38 > temp[stack.peek()] (30)
        // res[i] = # stack.pop() = 1
        // res = [1], stack = [1]
        // temp[i] = 30 < temp[stack.peek()] (38), stack = [1, 2]
        // 36 < 38 -> stack = [1, 2, 3]
        // 35 < 38 -> stack = [1, 2, 3, 4]
        // 40 > 38 -> res[j++] = stack.pop() -> res = [1, 4], stack = [1, 2]

        // Stack is helping us keep track of the days waiting for a warmer temperature

        int[] result = new int[temperatures.length];
        Stack<Integer> stack = new Stack();

        for (int i = 0; i < temperatures.length; i++) {
            // We store indices of the temperatures array as we go through it
            // stack represents how many days are waiting for a warmer temperature.
            // Check if current temp > top of stack's temp? 
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int index = stack.pop();
                result[index] = i - index;
            }
            stack.push(i);
        }
        return result;
    }
}
