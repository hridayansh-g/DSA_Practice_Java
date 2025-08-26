class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows)
            return s;

        int n = s.length(), r = numRows, cycle = 2 * r - 2;
        int cols = n;
        char[][] grid = new char[r][cols];

        int i = 0, col = 0;
        while (i < n) {
            for (int row = 0; row < r && i < n; row++) {
                grid[row][col] = s.charAt(i++);
            }
            for (int k = r - 2; k >= 1 && i < n; k--) {
                col++;
                grid[k][col] = s.charAt(i++);
            }
            col++;
        }

        StringBuilder ans = new StringBuilder(n);
        for (int row = 0; row < r; row++) {
            for (int c = 0; c <= col && c < cols; c++) {
                if (grid[row][c] != '\0')
                    ans.append(grid[row][c]);
            }
        }
        return ans.toString();
    }
}