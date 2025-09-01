class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char ch = board[r][c];
                if (ch == '.')
                    continue;

                // row
                for (int j = 0; j < 9; j++) {
                    if (j != c && board[r][j] == ch)
                        return false;
                }
                // column
                for (int i = 0; i < 9; i++) {
                    if (i != r && board[i][c] == ch)
                        return false;
                }
                // box
                int br = (r / 3) * 3, bc = (c / 3) * 3;
                for (int i = br; i < br + 3; i++) {
                    for (int j = bc; j < bc + 3; j++) {
                        if ((i != r || j != c) && board[i][j] == ch)
                            return false;
                    }
                }
            }
        }
        return true;
    }
}