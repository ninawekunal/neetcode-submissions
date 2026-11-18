class Solution {
    public int removeElement(int[] nums, int val) {
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                list.add(nums[i]);
            }
        }
        int j = 0;
        for (int num: list) {
            nums[j++] = num;
        }
        // System.out.println(list.toString());
        return j;
    }
}