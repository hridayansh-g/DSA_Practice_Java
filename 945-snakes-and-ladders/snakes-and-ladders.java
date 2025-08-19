import java.util.*;

class Solution {
    public int snakesAndLadders(int[][] board) {
        int n = board.length, N = n * n;

        int[] jump = new int[N + 1];
        Arrays.fill(jump, -1);
        int lab = 1; boolean ltr = true;
        for (int r = n - 1; r >= 0; r--) {
            if (ltr) {
                for (int c = 0; c < n; c++, lab++)
                    if (board[r][c] != -1) jump[lab] = board[r][c];
            } else {
                for (int c = n - 1; c >= 0; c--, lab++)
                    if (board[r][c] != -1) jump[lab] = board[r][c];
            }
            ltr = !ltr;
        }

        boolean[] vis = new boolean[N + 1];
        ArrayDeque<Integer> q = new ArrayDeque<>();
        q.offer(1); vis[1] = true;

        int moves = 0;
        while (!q.isEmpty()) {
            for (int sz = q.size(); sz > 0; sz--) {
                int u = q.poll();
                if (u == N) return moves;

                for (int d = 1; d <= 6 && u + d <= N; d++) {
                    int v = u + d;
                    if (jump[v] != -1) v = jump[v];   // take snake/ladder once
                    if (!vis[v]) {
                        vis[v] = true;
                        q.offer(v);
                    }
                }
            }
            moves++;
        }
        return -1;
    }
}