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
        
        if (intervals.size() <= 1) return intervals.size(); 
        intervals.sort((a, b) -> a.start - b.start);
        
        PriorityQueue<Interval> minHeap = new PriorityQueue<>((a, b) -> a.end - b.end);

        for (Interval current: intervals) {
            if (!minHeap.isEmpty() && minHeap.peek().end <= current.start) {
                minHeap.poll();
            }
            minHeap.offer(current);
        }
        return minHeap.size();
    }
}
