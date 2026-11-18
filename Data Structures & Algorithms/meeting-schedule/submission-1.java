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
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals.size() <= 1) return true;
        
        Collections.sort(intervals, (a,b) -> a.start - b.start);
        
        // guaranteed to have 2 elements
        int lastEndTime = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            int currentStartTime = intervals.get(i).start;
            if (currentStartTime < lastEndTime) return false;
            lastEndTime = intervals.get(i).end;
        }
        return true;
    }
}
