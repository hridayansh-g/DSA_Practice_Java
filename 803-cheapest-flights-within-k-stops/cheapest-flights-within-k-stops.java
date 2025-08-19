import java.util.*;

class Solution { 
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<int[]>[] g = new ArrayList[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        for (int[] f : flights) g[f[0]].add(new int[]{f[1], f[2]});

        int[][] best = new int[n][k + 2];
        for (int i = 0; i < n; i++) Arrays.fill(best[i], Integer.MAX_VALUE);

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.offer(new int[]{0, src, 0}); 
        best[src][0] = 0;

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int cost = cur[0], u = cur[1], used = cur[2];
            if (u == dst) return cost;
            if (used == k + 1) continue;

            for (int[] e : g[u]) {
                int v = e[0], w = e[1];
                int nc = cost + w, ns = used + 1;
                if (nc < best[v][ns]) {
                    best[v][ns] = nc;
                    pq.offer(new int[]{nc, v, ns});
                }
            }
        }
        return -1;
    }
    // approach 2
   /*  public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        final int INF = 1_000_000_000;
        int[] dist = new int[n];
        Arrays.fill(dist, INF);
        dist[src] = 0;

        for (int i = 0; i <= k; i++) {       
            int[] next = dist.clone();        
            for (int[] e : flights) {
                int u = e[0], v = e[1], w = e[2];
                if (dist[u] != INF && dist[u] + w < next[v]) {
                    next[v] = dist[u] + w;
                }
            }
            dist = next;
        }
        return dist[dst] == INF ? -1 : dist[dst];
    }
    */

    // approach 1
    /*
    List<int[]>[] g;
    int best = Integer.MAX_VALUE;

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        g = new ArrayList[n];
        for (int i = 0; i < n; i++) g[i] = new ArrayList<>();
        for (int[] f : flights) g[f[0]].add(new int[]{f[1], f[2]});

        dfs(src, dst, k + 1, 0, new boolean[n]);  
        return best == Integer.MAX_VALUE ? -1 : best;
    }

    void dfs(int u, int dst, int flightsLeft, int cost, boolean[] vis) {
        if (cost >= best) return;
        if (u == dst) { best = cost; return; }
        if (flightsLeft == 0) return;

        vis[u] = true;
        for (int[] e : g[u]) {
            int v = e[0], w = e[1];
            if (!vis[v]) dfs(v, dst, flightsLeft - 1, cost + w, vis);
        }
        vis[u] = false;
    }
    */
}