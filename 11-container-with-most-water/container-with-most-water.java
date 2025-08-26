class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1, best = 0;
        while (l < r) {
            int h = Math.min(height[l], height[r]);
            best = Math.max(best, h * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return best;

        // approach 1
        /*    int n = height.length, best = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int h = Math.min(height[i], height[j]);
                int area = h * (j - i);
                if (area > best)
                    best = area;
            }
        }
        return best;
        */
    }
}