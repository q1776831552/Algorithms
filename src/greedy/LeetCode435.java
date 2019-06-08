package greedy;

import java.util.Arrays;
import java.util.Comparator;

class Interval {
    int start;
    int end;
    Interval() { start = 0; end = 0; }
    Interval(int s, int e) { start = s; end = e; }
 }
public class LeetCode435 {
    public int eraseOverlapIntervals(Interval[] intervals) {
        int res = 0, last = 0, n = intervals.length;
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        for(int i = 1; i < n; i++) {
            if(intervals[last].end > intervals[i].start) {
                res++;
                if(intervals[last].end > intervals[i].end)
                    last = i;
            }
            last = i;
        }
        return res;
    }
}
