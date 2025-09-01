class Solution {
    public boolean isValidSudoku(char[][] board) {
        int[] row = new int[9], col = new int[9], box = new int[9];

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char ch = board[r][c];
                if (ch == '.')
                    continue;

                int bit = 1 << (ch - '1');
                int b = (r / 3) * 3 + (c / 3);

                if ((row[r] & bit) != 0 || (col[c] & bit) != 0 || (box[b] & bit) != 0)
                    return false;

                row[r] |= bit;
                col[c] |= bit;
                box[b] |= bit;
            }
        }
        return true;
        // approach 1
        /*
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
        */
    }
}