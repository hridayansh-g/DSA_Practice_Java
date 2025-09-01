class Solution {
    private static final int[][] DIRS = {
            { -1, -1 }, { -1, 0 }, { -1, 1 },
            { 0, -1 }, { 0, 1 },
            { 1, -1 }, { 1, 0 }, { 1, 1 }
    };

    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        int[][] next = new int[m][n];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                int live = 0;
                for (int[] d : DIRS) {
                    int nr = r + d[0], nc = c + d[1];
                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && board[nr][nc] == 1)
                        live++;
                }
                if (board[r][c] == 1) {
                    next[r][c] = (live == 2 || live == 3) ? 1 : 0;
                } else {
                    next[r][c] = (live == 3) ? 1 : 0;
                }
            }
        }

        for (int i = 0; i < m; i++)
            System.arraycopy(next[i], 0, board[i], 0, n);
    }
}