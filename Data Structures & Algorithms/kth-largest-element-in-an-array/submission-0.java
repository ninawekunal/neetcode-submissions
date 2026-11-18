class Solution {
    public int findKthLargest(int[] nums, int k) {
        List<Integer> numsList = new ArrayList<>();
        for (int num: nums) numsList.add(num);

        PriorityQueue<Integer> sorted = new PriorityQueue<>(Collections.reverseOrder());
        sorted.addAll(numsList);
        
        while (k > 1) {
            sorted.poll();
            k--;
        }
        // System.out.println("sorted is: " + sorted.toString());  
        return sorted.poll();
    }
}
