class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // numbers = [1,2,3,4], target = 3, op = 1

        // Using two pointers basic format
        int[] result = new int[] {1, 1};
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            // invalid left, move left forward
            if (sum < target) left++;
            // invalid right, move right behind
            else if (sum > target) right--;
            else { 
                // They're equal, we found our solution
                result[0] += left++;
                result[1] += right--;
            }
        }
        return result;
    }
}
