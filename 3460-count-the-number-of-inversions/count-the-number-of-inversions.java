import java.util.*;

class Solution {
   static final int MOD9 = 1_000_000_007;

    public int numberOfPermutations(int n, int[][] req) {
        int[] need = new int[n];
        Arrays.fill(need, -1);
        int LIM = 0;
        for (int[] z : req) {
            need[z[0]] = z[1];
            LIM = Math.max(LIM, z[1]);
        }
        if (need[n - 1] == -1) return 0;

        int[] bag = new int[LIM + 1];
        bag[0] = 1;

        for (int m = 1; m <= n; m++) {
            int mx = Math.min(LIM, m * (m - 1) / 2);
            int[] acc = new int[LIM + 1];
            acc[0] = bag[0];
            for (int k = 1; k <= LIM; k++) {
                int t = acc[k - 1] + bag[k];
                if (t >= MOD9) t -= MOD9;
                acc[k] = t;
            }
            int[] tray = new int[LIM + 1];
            for (int k = 0; k <= mx; k++) {
                int L = k - (m - 1) - 1;
                int v = acc[k];
                if (L >= 0) {
                    v -= acc[L];
                    if (v < 0) v += MOD9;
                }
                tray[k] = v;
            }
            if (need[m - 1] != -1) {
                int r = need[m - 1];
                if (r > mx) return 0;
                int keep = tray[r];
                Arrays.fill(tray, 0);
                tray[r] = keep;
            }
            bag = tray;
        }
        return bag[need[n - 1]];




       /* int[] want = new int[n];
        Arrays.fill(want, -1);
        for (int[] x : req) want[x[0]] = x[1];
        for (int e = 0; e < n; e++) {
            if (want[e] != -1) {
                long m = e + 1L;
                long cap = m * (m - 1) / 2;
                if (want[e] < 0 || want[e] > cap) return 0;
            }
        }
        ZFenw fw = new ZFenw(n);
        boolean[] mark = new boolean[n];
        ArrayList<Integer> stops = new ArrayList<>();
        for (int i = 0; i < n; i++) if (want[i] != -1) stops.add(i);
        long[] box = new long[1];
        dfsZ(0, 0, n, want, mark, fw, stops, box);
        return (int) (box[0] % M__);
    }

    private void dfsZ(int pos, int inv, int N, int[] need, boolean[] use, ZFenw f,
                      ArrayList<Integer> stops, long[] out) {
        if (need[pos == 0 ? 0 : pos - 1] != -1 && pos > 0) {
            if (inv != need[pos - 1]) return;
        }
        for (int e : stops) {
            if (e < pos) continue;
            int m = e + 1;
            int r = m - pos;
            long maxAdd = (long) pos * r + (long) r * (r - 1) / 2;
            int want = need[e];
            if (want == -1) continue;
            if (inv > want) return;
            if (inv + maxAdd < want) return;
        }
        if (pos == N) {
            if (need[N - 1] == -1 || inv == need[N - 1]) {
                out[0] = (out[0] + 1) % M__;
            }
            return;
        }
        for (int v = 0; v < N; v++) {
            if (use[v]) continue;
            int usedCnt = f.sum(N - 1);
            int notGreater = f.sum(v);
            int add = usedCnt - notGreater;
            use[v] = true;
            f.add(v, 1);
            dfsZ(pos + 1, inv + add, N, need, use, f, stops, out);
            f.add(v, -1);
            use[v] = false;
        }
    }

    static class ZFenw {
        int n;
        int[] bit;
        ZFenw(int n) { this.n = n; this.bit = new int[n + 1]; }
        void add(int idx, int d) {
            for (int i = idx + 1; i <= n; i += i & -i) bit[i] += d;
        }
        int sum(int idx) {
            if (idx < 0) return 0;
            int s = 0;
            for (int i = idx + 1; i > 0; i -= i & -i) s += bit[i];
            return s;
        } */
    }
}