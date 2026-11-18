class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        int n = intervals.size();
        if (n == 0 || n == 1) return true;
        intervals.sort((a, b) -> a.start - b.start);

        Interval prev = intervals.get(0);
        for (int i = 1; i < n; i++) {
            Interval curr = intervals.get(i);
            if (curr.start < prev.end) return false;
            prev = curr;
        }
        return true;
    }
}
