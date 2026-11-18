class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        
        int left = 1; // at least 1 banana per hour
        int max = -1;
        for (int pile: piles) max = Math.max(max, pile);

        int right = max;
        while (left < right) {
            int mid = left + (right - left)/2;
            int totalHours = totalHoursToFinish(mid, piles);
            if (totalHours <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        // at the end left will have the smallest valid value
        return left;
    }

    private int totalHoursToFinish(int speed, int[] piles) {
        int totalHours = 0;
        for (int pile: piles) {
            totalHours += (int) Math.ceil((double) pile/speed);
        }

        return totalHours;
    }
}
