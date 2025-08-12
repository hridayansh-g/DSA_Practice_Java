import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return new int[0][2];

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
    }
}