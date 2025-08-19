class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1) return -1;

        int[] parent = new int[n];
        int[] rank   = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        int components = n;
        for (int[] e : connections) {
            if (union(e[0], e[1], parent, rank)) {
                components--;                 
            }
        }
        return components - 1;               
    }

    private int find(int x, int[] parent) {
        while (x != parent[x]) {
            parent[x] = parent[parent[x]];    
            x = parent[x];
        }
        return x;
    }

    private boolean union(int a, int b, int[] parent, int[] rank) {
        int ra = find(a, parent), rb = find(b, parent);
        if (ra == rb) return false;
        if (rank[ra] < rank[rb]) parent[ra] = rb;
        else if (rank[ra] > rank[rb]) parent[rb] = ra;
        else { parent[rb] = ra; rank[ra]++; }
        return true;
    }
}