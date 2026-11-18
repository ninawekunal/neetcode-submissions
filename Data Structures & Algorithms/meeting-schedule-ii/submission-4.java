/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int n = intervals.size();
        if (n == 1) return 1;
        if (n == 0) return 0;

        intervals.sort((a, b) -> a.start - b.start);
        PriorityQueue<Interval> maxHeap = new PriorityQueue<>((a, b) -> a.end - b.end);

        maxHeap.offer(intervals.get(0));
        int minRooms = 1;

        for (int i = 1; i < n; i++) {
            Interval curr = intervals.get(i);
            while (!maxHeap.isEmpty() && curr.start >= maxHeap.peek().end) maxHeap.poll();
            maxHeap.offer(curr);
            minRooms = Math.max(minRooms, maxHeap.size());
        }

        return minRooms;
    }
}
