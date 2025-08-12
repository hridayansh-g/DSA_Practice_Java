class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
         int a = matrix.length;
        if (a == 0) return false;
        int b = matrix[0].length;
        if (b == 0) return false;

        int l = 0, h = a * b - 1;
        while (l <= h) {
            int mid = l + ((h - l) >> 1);
            int i = mid / b, j = mid % b;
            int x = matrix[i][j];
            if (x == target) return true;
            if (x < target) l = mid + 1;
            else h = mid - 1;
        }
        return false;
    }
}

