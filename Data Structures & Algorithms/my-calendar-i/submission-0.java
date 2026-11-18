class MyCalendar {
    private TreeSet<int[]> bst;
    public MyCalendar() {
        bst = new TreeSet<>((a, b) -> Integer.compare(a[0], b[0]));
    }
    
    public boolean book(int startTime, int endTime) {

        int[] key = {startTime, endTime};
        int[] before = this.bst.floor(key); // latest booking starting at or before startTime.

        // booking before this must end before new startTime.
        if (before != null && before[1] > startTime) return false;
        int[] after = this.bst.ceiling(key);
        // booking after this must start on or after endTime.
        if (after != null && after[0] < endTime ) return false;
        this.bst.add(key);
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(startTime,endTime);
 */