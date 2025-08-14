class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length, n = board[0].length;
        boolean[][] vis = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0, vis)) return true;
            }
        }
        return false;
    }

    private boolean dfs(char[][] b, String w, int r, int c, int k, boolean[][] vis) {
        if (k == w.length()) return true;
        if (r < 0 || c < 0 || r >= b.length || c >= b[0].length) return false;
        if (vis[r][c] || b[r][c] != w.charAt(k)) return false;

        vis[r][c] = true;
        boolean ok = dfs(b, w, r + 1, c, k + 1, vis)
                  || dfs(b, w, r - 1, c, k + 1, vis)
                  || dfs(b, w, r, c + 1, k + 1, vis)
                  || dfs(b, w, r, c - 1, k + 1, vis);
        vis[r][c] = false;
        return ok;
    }
}