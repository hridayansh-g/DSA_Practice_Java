/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
     private int best = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        gain(root);
        return best;
    }

    private int gain(TreeNode node) {
        if (node == null) return 0;
        int L = Math.max(0, gain(node.left));
        int R = Math.max(0, gain(node.right));
        best = Math.max(best, node.val + L + R);   
        return node.val + Math.max(L, R);          
    }
// approach 1
 /*   public int maxPathSum(TreeNode root) {
        int[] ans = {Integer.MIN_VALUE};
        visit(root, ans);
        return ans[0];
    }
     private void visit(TreeNode node, int[] ans) {
        if (node == null) return;
        int leftDown  = maxDownSlow(node.left);
        int rightDown = maxDownSlow(node.right);
        int through = node.val + Math.max(0, leftDown) + Math.max(0, rightDown);
        ans[0] = Math.max(ans[0], through);
        visit(node.left, ans);
        visit(node.right, ans);
    }

    private int maxDownSlow(TreeNode node) {
        if (node == null) return 0;
        int left  = maxDownSlow(node.left);
        int right = maxDownSlow(node.right);
        return node.val + Math.max(0, Math.max(left, right));
    }
    */
}