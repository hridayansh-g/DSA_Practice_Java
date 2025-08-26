class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int total = 0, tank = 0, start = 0;
        for (int i = 0; i < gas.length; i++) {
            int diff = gas[i] - cost[i];
            total += diff;
            tank += diff;
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }
        return total >= 0 ? start : -1;

        // approach 1
        /*    int n = gas.length;
        for (int s = 0; s < n; s++) {
            int tank = 0, steps = 0, i = s;
            while (steps < n) {
                tank += gas[i] - cost[i];
                if (tank < 0)
                    break;
                i = (i + 1) % n;
                steps++;
            }
            if (steps == n)
                return s;
        }
        return -1;
        */
    }
}