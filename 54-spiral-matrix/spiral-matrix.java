class Solution {
    public List<Integer> spiralOrder(int[][] m) {
        int R = m.length, C = m[0].length;
        boolean[][] v = new boolean[R][C];
        List<Integer> res = new ArrayList<>();
        int[] dr = {0, 1, 0, -1}, dc = {1, 0, -1, 0};
        int r = 0, c = 0, d = 0;
        for (int k = 0; k < R * C; k++) {
            res.add(m[r][c]);
            v[r][c] = true;
            int nr = r + dr[d], nc = c + dc[d];
            if (nr < 0 || nc < 0 || nr >= R || nc >= C || v[nr][nc]) {
                d = (d + 1) % 4;
                nr = r + dr[d];
                nc = c + dc[d];
            }
            r = nr; c = nc;
        }
        return res;
    }
}