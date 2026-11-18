class Solution {
    public int maxArea(int[] heights) {
        // height = [1,7,2,5,4,7,3,6] -> op: 36
        // Max amount of water/area a container can store
        // area = height x width
        // Calculate rolling area, and keep track of max
        // What if I start my pointer at the two opposite ends? 
        // > I need two heights to store some water between them.
        // height = [1,7,2,5,4,7,3,6]
        // index  = [0,1,2,3,4,5,6,7], max area = 1
        // left = 0, right = 2, max = 2
        // area is -> smallest height (min(val[left, right])) x width (right - left) 
        // Move either left or right based on the smallest height
        
        int left = 0, right = heights.length - 1, maxArea = Integer.MIN_VALUE;
        while (left < right) {
            int width = right - left;
            int smallestHeight = Math.min(heights[left], heights[right]);
            maxArea = Math.max(maxArea, width * smallestHeight);

            if (heights[left] <= heights[right]) left++;
            else right--;
        }
        return maxArea;
    }
}
