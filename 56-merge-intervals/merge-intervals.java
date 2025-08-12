import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
         if (intervals == null || intervals.length == 0) return new int[0][2];

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int k = 0; 
        int curStart = intervals[0][0], curEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int s = intervals[i][0], e = intervals[i][1];
            if (s <= curEnd) {
                if (e > curEnd) curEnd = e;
            } else {
                intervals[k][0] = curStart;
                intervals[k][1] = curEnd;
                k++;
                curStart = s;
                curEnd = e;
            }
        }

        intervals[k][0] = curStart;
        intervals[k][1] = curEnd;
        k++;

        return Arrays.copyOf(intervals, k);

      /*  if (intervals == null || intervals.length == 0) return new int[0][2];

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();
        int[] cur = Arrays.copyOf(intervals[0], 2);

        for (int i = 1; i < intervals.length; i++) {
            int[] nxt = intervals[i];
            if (nxt[0] <= cur[1]) {                 
                cur[1] = Math.max(cur[1], nxt[1]);  
            } else {
                merged.add(cur);                   
                cur = Arrays.copyOf(nxt, 2);        
            }
        }
        merged.add(cur);
        return merged.toArray(new int[merged.size()][]);
        */
    }
}