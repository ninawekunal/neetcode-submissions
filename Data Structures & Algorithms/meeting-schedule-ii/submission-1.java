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
        if (intervals.size() == 1) return 1;
        /**
            We want to know at each interval, how many meetings are active right now?
            And we can use a minHeap to keep track of the endingTimes of the intervals.
            Our heap at each point tells us how many meetings are active.
        */
        int maxRoomCount = 0;
        Collections.sort(intervals, (a, b) -> a.start - b.start);

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (Interval interval: intervals) {
            int currentStartTime = interval.start;
            int currentEndTime = interval.end;
            while (!minHeap.isEmpty() && minHeap.peek() <= currentStartTime) {
                minHeap.poll();
            }
            minHeap.add(currentEndTime); // allocate a room
            maxRoomCount = Math.max(maxRoomCount, minHeap.size());
        }
        return maxRoomCount;
    }
}
