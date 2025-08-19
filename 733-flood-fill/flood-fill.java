import java.util.*;
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length, n = image[0].length;
        int start = image[sr][sc];
        if (start == color) return image;

        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sr, sc});
        image[sr][sc] = color;

        int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!q.isEmpty()) {
            int[] p = q.poll();
            for (int[] d : dir) {
                int nr = p[0] + d[0], nc = p[1] + d[1];
                if (nr>=0 && nc>=0 && nr<m && nc<n && image[nr][nc]==start) {
                    image[nr][nc] = color;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
        return image;
    }
    // approach 1
   /* public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length, n = image[0].length;
        int start = image[sr][sc];
        if (start == color) return image; 

        dfs(image, sr, sc, start, color, m, n);
        return image;
    }

    private void dfs(int[][] img, int r, int c, int start, int newColor, int m, int n) {
        if (r < 0 || c < 0 || r >= m || c >= n) return;
        if (img[r][c] != start) return;

        img[r][c] = newColor;
        dfs(img, r + 1, c, start, newColor, m, n);
        dfs(img, r - 1, c, start, newColor, m, n);
        dfs(img, r, c + 1, start, newColor, m, n);
        dfs(img, r, c - 1, start, newColor, m, n);
    }
    */
}